import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class AdminPanel extends JFrame {
    AdminPanel(){
        setTitle("Admin Panel");
        setBounds(0,0,1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(121, 164, 176));

        JPanel toolBar = new JPanel(null);
        toolBar.setBackground(Color.WHITE);
        toolBar.setBounds(0, 0, 1920, 80);
        add(toolBar);

        ImageIcon logoutbtnIcon=new ImageIcon(getClass().getResource("logoutBtn.png"));
        Image scaledbtn=logoutbtnIcon.getImage().getScaledInstance(154,80,Image.SCALE_SMOOTH);
        ImageIcon scaledLogoutbtnIcon=new ImageIcon(scaledbtn);


        JButton logoutButton=new JButton("",scaledLogoutbtnIcon);
        logoutButton.setBounds(1354,0,200,88);
        logoutButton.setBorder(null);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.setBackground(Color.white);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int answer=JOptionPane.showConfirmDialog(null,"Are you sure you want to Logout?","Confirmation",JOptionPane.YES_NO_OPTION);
                if(answer==0){
                    dispose();
                    new LoginPage();
                }
            }
        });
        toolBar.add(logoutButton);

        JLabel welcomeLabel = new JLabel("Welcome Back, Admin", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Krona One", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(75, 129, 144));
        welcomeLabel.setBounds(570, 20, 400, 40);
        toolBar.add(welcomeLabel);

        JPanel bodyPanel = new JPanel(null);
        bodyPanel.setBounds(0, 80, 1920, 1000);
        bodyPanel.setBackground(new Color(121, 164, 176));
        add(bodyPanel);

        ImageIcon tourbtnIcon=new ImageIcon(getClass().getResource("tour_icon.png"));
        Image scaled=tourbtnIcon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scaledTourButtonIcon=new ImageIcon(scaled);

        JButton viewTourBtn = new JButton("View Tours",scaledTourButtonIcon);
        viewTourBtn.setBounds(470-60, 160, 300, 200);
        viewTourBtn.setBackground(Color.WHITE);
        viewTourBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewTourBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        viewTourBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        viewTourBtn.setForeground(new Color(75, 129, 144));
        viewTourBtn.setFont(new Font("Krona One", Font.PLAIN, 18));
        viewTourBtn.setFocusPainted(false);
        viewTourBtn.setBorder(null);
        viewTourBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewToursAdmin();
            }
        });
        viewTourBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                viewTourBtn.setBackground(new Color(223, 232, 234));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                viewTourBtn.setBackground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                viewTourBtn.setBackground(Color.WHITE);
            }
        });
        bodyPanel.add(viewTourBtn);

        ImageIcon parcelbtnIcon=new ImageIcon(getClass().getResource("parcel_icon.png"));
        Image scaledParcel=parcelbtnIcon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scaledParcelButtonIcon=new ImageIcon(scaledParcel);

        JButton viewParcelBtn = new JButton("View Parcels",scaledParcelButtonIcon);
        viewParcelBtn.setBounds(770+60, 160, 300, 200);
        viewParcelBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        viewParcelBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        viewParcelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewParcelBtn.setBackground(Color.WHITE);
        viewParcelBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                viewParcelBtn.setBackground(new Color(223, 232, 234));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                viewParcelBtn.setBackground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                viewParcelBtn.setBackground(Color.WHITE);
            }
        });
        viewParcelBtn.setForeground(new Color(75, 129, 144));
        viewParcelBtn.setFont(new Font("Krona One", Font.PLAIN, 18));
        viewParcelBtn.setFocusPainted(false);
        viewParcelBtn.setBorder(null);
        viewParcelBtn.addActionListener(toSendParcel ->{
            dispose();
            new ViewParcelsAdmin();
        });
        bodyPanel.add(viewParcelBtn);

        JButton deleteTourBtn = new JButton("Delete Tour");
        deleteTourBtn.setBounds(470-60, 460, 300, 60);
        deleteTourBtn.setBackground(Color.WHITE);
        deleteTourBtn.setBorder(null);
        deleteTourBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteTourBtn.setForeground(new Color(75, 129, 144));
        deleteTourBtn.setFont(new Font("Krona One", Font.PLAIN, 18));
        deleteTourBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result=Integer.parseInt(JOptionPane.showInputDialog("Enter Tour ID to Delete Particular Record"));
                if(deleteRecordByTourID(result)){
                    JOptionPane.showMessageDialog(null,"Deletion Successful","Success",JOptionPane.ERROR_MESSAGE);                }
                else{
                    JOptionPane.showMessageDialog(null,"No Record Found with Tour ID: "+result,"Error",JOptionPane.QUESTION_MESSAGE);
                }
            }
        });
        deleteTourBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                deleteTourBtn.setBackground(new Color(223, 232, 234));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteTourBtn.setBackground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                deleteTourBtn.setBackground(Color.WHITE);
            }
        });
        bodyPanel.add(deleteTourBtn);

        JButton deleteParcelBtn = new JButton("Delete Parcel");
        deleteParcelBtn.setBounds(770+60, 460, 300, 60);
        deleteParcelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteParcelBtn.setForeground(new Color(75, 129, 144));
        deleteParcelBtn.setBackground(Color.WHITE);
        deleteParcelBtn.setBorder(null);
        deleteParcelBtn.setFont(new Font("Krona One", Font.PLAIN, 18));
        deleteParcelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result=Integer.parseInt(JOptionPane.showInputDialog("Enter Parcel ID to Delete Particular Record"));
                if(deleteRecordByParcelID(result)){
                    JOptionPane.showMessageDialog(null,"Deletion Successful","Success",JOptionPane.ERROR_MESSAGE);                }
                else{
                    JOptionPane.showMessageDialog(null,"No Record Found with Parcel ID: "+result,"Error",JOptionPane.QUESTION_MESSAGE);
                }
            }
        });
        deleteParcelBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                deleteParcelBtn.setBackground(new Color(223, 232, 234));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteParcelBtn.setBackground(Color.WHITE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                deleteParcelBtn.setBackground(Color.WHITE);
            }
        });
        bodyPanel.add(deleteParcelBtn);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
    }
    public static boolean deleteRecordByTourID(int tourID){
        try{
            Connection connection= DriverManager.getConnection(Main.urlSQL,Main.usernameSQL,Main.passwordSQL);
            Statement statement=connection.createStatement();
            String query="DELETE FROM tours where tour_id="+tourID+";";
            int rows=statement.executeUpdate(query);
            if(rows>0){
                return true;
            }
        }catch(Exception exception){
            JOptionPane.showMessageDialog(null,exception.getMessage(),"404",JOptionPane.QUESTION_MESSAGE);
        }
    return false;
    }
    public static boolean deleteRecordByParcelID(int parcelID){
        try{
            Connection connection= DriverManager.getConnection(Main.urlSQL,Main.usernameSQL,Main.passwordSQL);
            Statement statement=connection.createStatement();
            String query="DELETE FROM parcels where parcel_id="+parcelID+";";
            int rows=statement.executeUpdate(query);
            if(rows>0){
                return true;
            }
        }catch(Exception exception){
            JOptionPane.showMessageDialog(null,exception.getMessage(),"404",JOptionPane.QUESTION_MESSAGE);
        }
        return false;
    }

    public static void main(String[] args) {
        new AdminPanel();
    }
}
