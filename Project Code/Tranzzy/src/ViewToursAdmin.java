import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class ViewToursAdmin extends JFrame {

    ViewToursAdmin() {
        setTitle("View Tours");
        setBounds(0, 0, 1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(121, 164, 176));

        JPanel toolBar = new JPanel(null);
        toolBar.setBackground(Color.WHITE);
        toolBar.setBounds(0, 0, 1920, 80);
        add(toolBar);

        ImageIcon backBtnIcon=new ImageIcon(getClass().getResource("backbtn.png"));
        Image scaledbtn=backBtnIcon.getImage().getScaledInstance(151,88,Image.SCALE_SMOOTH);
        ImageIcon scaledBackBtnIcon=new ImageIcon(scaledbtn);


        JButton backButton=new JButton("",scaledBackBtnIcon);
        backButton.setBounds(1354,0,200,88);
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


        JLabel viewTourLabel = new JLabel("View Tours", SwingConstants.CENTER);
        viewTourLabel.setFont(new Font("Krona One", Font.BOLD, 24));
        viewTourLabel.setForeground(new Color(75, 129, 144));
        viewTourLabel.setBounds(220, 20, 1080, 40);
        toolBar.add(viewTourLabel);


        JPanel constraint = new JPanel(null);
        constraint.setBackground(Color.white);
        constraint.setBounds(100, 130, 1348, 600);
        add(constraint);

        JTabbedPane pane = new JTabbedPane();
        pane.setBounds(0, 0, 1348, 600);

        pane.add("All Tours", new DisplayTable());
        constraint.add(pane);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}

class DisplayTable extends JPanel {


    DisplayTable() {
        setLayout(new BorderLayout());
        setBackground(Color.white);

        String[] columns = {"User ID", "Tour ID","Name", "Pickup", "Destination", "Vehicle", "Seats","AC", "Fare"};
        String[][] records = new String[0][];
        int dimension = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Main.urlSQL, Main.usernameSQL,Main.passwordSQL);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM tours;";
            ResultSet resultSet = statement.executeQuery(query);

            // Count rows
            while (resultSet.next()) {
                dimension++;
            }

            // Re-run query to fetch data
            resultSet = statement.executeQuery(query);
            records = new String[dimension][9];

            int index = 0;
            while (resultSet.next()) {
                records[index][0] = Integer.toString(resultSet.getInt("user_id"));
                records[index][1] = Integer.toString(resultSet.getInt("tour_id"));
                records[index][2]=resultSet.getString("name");
                records[index][3] = resultSet.getString("pickUp");
                records[index][4] = resultSet.getString("destination");
                records[index][5] = resultSet.getString("vehicle");
                records[index][6]=Integer.toString(resultSet.getInt("seats"));
                records[index][7] = Boolean.toString(resultSet.getBoolean("hasAC"));
                records[index][8] = Double.toString(resultSet.getDouble("fare"));
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