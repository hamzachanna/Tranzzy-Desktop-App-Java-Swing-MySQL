import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame {

        MainMenu() {

        setTitle("Main Menu");
        setBounds(0,0,1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(121, 164, 176));

        JPanel toolBar = new JPanel(null);
        toolBar.setBackground(Color.WHITE);
        toolBar.setBounds(0, 0, 1920, 80);

        String welcomeLbl="Welcome, ";
        welcomeLbl=welcomeLbl.concat(User.username);

        JLabel welcomeLabel = new JLabel(welcomeLbl, SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Krona One", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(75, 129, 144));
        welcomeLabel.setBounds(220, 20, 1080, 40);
        toolBar.add(welcomeLabel);
        add(toolBar);


        JPanel bodyPanel = new JPanel(null);
        bodyPanel.setBounds(0, 80, 1920, 1000);
        bodyPanel.setBackground(new Color(121, 164, 176));
        add(bodyPanel);

        ImageIcon tourbtnIcon=new ImageIcon(getClass().getResource("tour_icon.png"));
        Image scaled=tourbtnIcon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scaledTourButtonIcon=new ImageIcon(scaled);

        ImageIcon logoutbtnIcon=new ImageIcon(getClass().getResource("logoutBtn.png"));
        Image scaledbtn=logoutbtnIcon.getImage().getScaledInstance(154,80,Image.SCALE_SMOOTH);
        ImageIcon scaledLogoutbtnIcon=new ImageIcon(scaledbtn);

        JButton logoutButton=new JButton("",scaledLogoutbtnIcon);
        logoutButton.setBounds(1354,0,200,88);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.setOpaque(true);
        logoutButton.setBorder(null);
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

        JButton bookTourBtn = new JButton("Book Tour",scaledTourButtonIcon);
        bookTourBtn.setBounds(470-60, 160, 300, 200);
        bookTourBtn.setBackground(Color.WHITE);
        bookTourBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bookTourBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        bookTourBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        bookTourBtn.setForeground(new Color(75, 129, 144));
        bookTourBtn.setFont(new Font("Krona One", Font.PLAIN, 18));
        bookTourBtn.setFocusPainted(false);
        bookTourBtn.setBorder(null);
        bookTourBtn.addActionListener(toBookTour ->{
                new BookTour();
                dispose();
        });
        bookTourBtn.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                        bookTourBtn.setBackground(new Color(223, 232, 234));
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                        bookTourBtn.setBackground(Color.WHITE);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                        bookTourBtn.setBackground(Color.WHITE);
                }
        });

        bodyPanel.add(bookTourBtn);

        ImageIcon parcelbtnIcon=new ImageIcon(getClass().getResource("parcel_icon.png"));
        Image scaledParcel=parcelbtnIcon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scaledParcelButtonIcon=new ImageIcon(scaledParcel);

        // Send Parcel button
        JButton sendParcelBtn = new JButton("Send Parcel",scaledParcelButtonIcon);
        sendParcelBtn.setBounds(770+60, 160, 300, 200);
        sendParcelBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        sendParcelBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        sendParcelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sendParcelBtn.setBackground(Color.WHITE);
        sendParcelBtn.setForeground(new Color(75, 129, 144));
        sendParcelBtn.setFont(new Font("Krona One", Font.PLAIN, 18));
        sendParcelBtn.setFocusPainted(false);
        sendParcelBtn.addActionListener(toSendParcel ->{
                dispose();
                new SendParcel();
        });

        sendParcelBtn.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                        sendParcelBtn.setBackground(new Color(223, 232, 234));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                        sendParcelBtn.setBackground(Color.WHITE);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                        sendParcelBtn.setBackground(Color.WHITE);
                }
        });


                bodyPanel.add(sendParcelBtn);

        // View Tour button
        JButton viewTourBtn = new JButton("View Tour");
        viewTourBtn.setBounds(470-60, 460, 300, 60);
        viewTourBtn.setBackground(Color.WHITE);
        viewTourBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewTourBtn.setForeground(new Color(75, 129, 144));
        viewTourBtn.setFont(new Font("Krona One", Font.PLAIN, 18));
        viewTourBtn.setBorder(null);
        viewTourBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        dispose();
                        new TourHistory();
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

        JButton viewParcelsBtn = new JButton("View Parcels");
        viewParcelsBtn.setBounds(770+60, 460, 300, 60);
        viewParcelsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewParcelsBtn.setForeground(new Color(75, 129, 144));
        viewParcelsBtn.setBackground(Color.WHITE);
        viewParcelsBtn.setBorder(null);
        viewParcelsBtn.setFont(new Font("Krona One", Font.PLAIN, 18));
        viewParcelsBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        dispose();
                        new ParcelHistory();
                }
        });
        viewParcelsBtn.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                        viewParcelsBtn.setBackground(new Color(223, 232, 234));
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                        viewParcelsBtn.setBackground(Color.WHITE);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                        viewParcelsBtn.setBackground(Color.WHITE);
                }
        });
        bodyPanel.add(viewParcelsBtn);


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

        public static void main(String[] args) {
                new MainMenu();
        }
}
