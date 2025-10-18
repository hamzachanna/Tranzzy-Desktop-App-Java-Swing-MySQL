import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class ViewParcelsAdmin extends JFrame {

    ViewParcelsAdmin() {
        setTitle("View Parcels");
        setBounds(0, 0, 1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(121, 164, 176));

        // Top toolbar panel
        JPanel toolBar = new JPanel(null);
        toolBar.setBackground(Color.WHITE);
        toolBar.setBounds(0, 0, 1920, 80);
        add(toolBar);

        ImageIcon backBtnIcon = new ImageIcon(getClass().getResource("backbtn.png"));
        Image scaledbtn = backBtnIcon.getImage().getScaledInstance(151, 88, Image.SCALE_SMOOTH);
        ImageIcon scaledBackBtnIcon = new ImageIcon(scaledbtn);


        JButton backButton = new JButton("", scaledBackBtnIcon);
        backButton.setBounds(1354, 0, 200, 88);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setOpaque(true);
        backButton.setBorder(null);
        backButton.setBackground(Color.white);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminPanel();
            }
        });
        toolBar.add(backButton);


        JLabel viewTourLabel = new JLabel("View Parcels", SwingConstants.CENTER);
        viewTourLabel.setFont(new Font("Krona One", Font.BOLD, 24));
        viewTourLabel.setForeground(new Color(75, 129, 144));
        viewTourLabel.setBounds(220, 20, 1080, 40);
        toolBar.add(viewTourLabel);

        // Main content area
        JPanel constraint = new JPanel(null);
        constraint.setBackground(Color.white);
        constraint.setBounds(100, 130, 1348, 600);
        add(constraint);

        // Tabbed pane with table
        JTabbedPane pane = new JTabbedPane();
        pane.setBounds(0, 0, 1348, 600);
        pane.add("All Couriers", new DisplayTableParcels());
        constraint.add(pane);

        // Maximize window
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

}

class DisplayTableParcels extends JPanel {

    DisplayTableParcels() {
        setLayout(new BorderLayout());
        setBackground(Color.white);

        String[] columns = {"User ID", "Parcel ID", "Sender Name", "Sender Contact", "Sending Location","Receiver Name", "Receiver Contact", "Receiving Location", "Weight","Fragile","Urgent","Cash On Delivery","Charges"};
        String[][] records;
        int dimension = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Main.urlSQL, Main.usernameSQL, Main.passwordSQL);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM parcels;";
            ResultSet resultSet = statement.executeQuery(query);

            // Count rows
            while (resultSet.next()) {
                dimension++;
            }

            // Re-run query to fetch data
            resultSet = statement.executeQuery(query);
            records = new String[dimension][13];

            int index = 0;
            while (resultSet.next()) {
                records[index][0] = Integer.toString(resultSet.getInt("user_id"));
                records[index][1] = Integer.toString(resultSet.getInt("parcel_id"));
                records[index][2] = resultSet.getString("senderName");
                records[index][3] = resultSet.getString("senderNo");
                records[index][4] = resultSet.getString("senderLocation");
                records[index][5] = resultSet.getString("receiverName");
                records[index][6] = resultSet.getString("receiverNo");
                records[index][7] = resultSet.getString("receiverLocation");
                records[index][8] = Double.toString(resultSet.getDouble("weight"));
                records[index][9] = Boolean.toString(resultSet.getBoolean("fragile"));
                records[index][10] = Boolean.toString(resultSet.getBoolean("urgent"));
                records[index][11] = Boolean.toString(resultSet.getBoolean("cashOnDelivery"));
                records[index][12] = Double.toString(resultSet.getDouble("charges"));
                index++;
            }

            JTable table = new JTable(records, columns);
            table.setFillsViewportHeight(true);
            table.setForeground(new Color(75, 129, 144));
            table.setFont(new Font("Krona One",Font.PLAIN,10));

            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null,exception.getMessage(),"404",JOptionPane.QUESTION_MESSAGE);
        }
    }
}
