import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class LoginPage extends JFrame {
    public static String adminUsername = "Admin";
    public static String adminPassword = "ADMIN@123";

    LoginPage() {

        setTitle("Login");
        setBounds(0, 0, 1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(121, 164, 176));
        leftPanel.setLayout(null);
        leftPanel.setBounds(0, 0, 490, 1080);
        add(leftPanel);

        JPanel image = new JPanel();
        image.setBounds(81, 25, 291, 291);
        image.setLayout(new BorderLayout());
        ImageIcon logo = new ImageIcon(getClass().getResource("Logo.png"));
        JLabel imageLabel = new JLabel(logo);
        image.setBackground(null);
        image.add(imageLabel);
        leftPanel.add(image);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(null);
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setBounds(490, 0, 1430, 1080);
        add(bodyPanel);


        JLabel mainHeading = new JLabel("tranzzy");
        mainHeading.setBounds(138, 150, 300, 70);
        mainHeading.setForeground(new Color(75, 129, 144));
        mainHeading.setFont(new Font("Krona One", Font.BOLD, 52));
        bodyPanel.add(mainHeading);

        JLabel header = new JLabel("Login");
        header.setBounds(138, 230, 300, 52);
        header.setForeground(new Color(75, 129, 144));
        header.setFont(new Font("Krona One", Font.PLAIN, 24));
        bodyPanel.add(header);

        JLabel enterDetails = new JLabel("Enter login details to continue");
        enterDetails.setBounds(138, 276, 360, 52);
        enterDetails.setForeground(new Color(121, 164, 176));
        enterDetails.setFont(new Font("Krona One", Font.PLAIN, 18));
        bodyPanel.add(enterDetails);


        JLabel username = new JLabel("Enter Username");
        username.setBounds(138, 346, 200, 30);
        username.setForeground(new Color(138, 182, 194));
        username.setFont(new Font("Krona One", Font.PLAIN, 16));
        bodyPanel.add(username);

        JTextField nameField = new JTextField();
        nameField.setBounds(138, 379, 500, 60);
        nameField.setOpaque(false);
        nameField.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194), 4));
        nameField.setForeground(new Color(75, 129, 144));
        nameField.setFont(new Font("Krona One", Font.PLAIN, 18));
        bodyPanel.add(nameField);

        JLabel password = new JLabel("Enter Password");
        password.setBounds(138, 448, 200, 30);
        password.setForeground(new Color(138, 182, 194));
        password.setFont(new Font("Krona One", Font.PLAIN, 16));
        bodyPanel.add(password);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(138, 481, 500, 60);
        passwordField.setOpaque(false);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194), 4));
        passwordField.setForeground(new Color(75, 129, 144));
        passwordField.setEchoChar('•');
        passwordField.setFont(new Font("Krona One", Font.PLAIN, 18));
        bodyPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Krona One", Font.PLAIN, 18));
        loginButton.setBounds(138, 568, 500, 60);
        loginButton.setBorder(null);
        loginButton.setForeground(Color.WHITE);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String givenUsername = nameField.getText();
                String givenPassword = new String(passwordField.getPassword());

                if (givenUsername.equals(adminUsername) && givenPassword.equals(adminPassword)) {
                    dispose();
                    new AdminPanel();
                    return;
                }
                if(login(givenUsername,givenPassword)){
                    dispose();
                    new MainMenu();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Credentials","Try Again",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(new Color(167, 210, 221));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(new Color(138, 182, 194));
            }
        });
        loginButton.setBackground(new Color(138, 182, 194));
        bodyPanel.add(loginButton);

        JButton registerButton = new JButton("New to tranzzy? Register");
        registerButton.setFont(new Font("Krona One", Font.PLAIN, 16));
        registerButton.setBounds(138, 628, 500, 60);
        registerButton.setForeground(new Color(121,164,176));
        registerButton.setBorder(null);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterPage();
            }
        });
        registerButton.setBackground(Color.white);
        registerButton.setOpaque(false);
        bodyPanel.add(registerButton);

        setExtendedState(JFrame.MAXIMIZED_BOTH);


        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }

    public static boolean login(String username, String password) {

        try {
            Connection connection = DriverManager.getConnection(Main.urlSQL, Main.usernameSQL, Main.passwordSQL);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM users;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String gottenUsername = resultSet.getString("name");
                String gottenPassword = resultSet.getString("password");
                int gottenUserID = resultSet.getInt("user_id");

                if (username.equals(gottenUsername) && password.equals(gottenPassword)) {
                    User.userID=gottenUserID;
                    User.username=gottenUsername;
                    User.password=gottenPassword;
                    return true;
                }
            }
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null,exception.getMessage(),"404",JOptionPane.QUESTION_MESSAGE);
        }
        return false;
    }
}

