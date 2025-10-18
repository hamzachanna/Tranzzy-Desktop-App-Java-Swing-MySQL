import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class RegisterPage extends JFrame {
    RegisterPage(){
        setTitle("Register");
        setBounds(0,0,1920,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);


        JPanel rightPanel=new JPanel();
        rightPanel.setBackground(new Color(121,164,176));
        rightPanel.setLayout(null);
        rightPanel.setBounds(1046,0,490,1080);
        add(rightPanel);

        JPanel image =new JPanel();
        image.setBounds(81,25,291,291);
        image.setLayout(new BorderLayout());
        ImageIcon logo=new ImageIcon(getClass().getResource("Logo.png"));
        JLabel imageLabel=new JLabel(logo);
        image.setBackground(null);
        image.add(imageLabel);
        rightPanel.add(image);


        JPanel headingPanel=new JPanel();
        headingPanel.setLayout(null);
        headingPanel.setBounds(0,50,1440,180);
        add(headingPanel);

        JLabel mainHeading=new JLabel("tranzzy");
        mainHeading.setBounds(138,20,300,52);
        mainHeading.setForeground(new Color(75, 129, 144));
        mainHeading.setFont(new Font("Krona One",Font.BOLD,42));
        headingPanel.add(mainHeading);

        JLabel header=new JLabel("Register");
        header.setBounds(138,80,300,52);
        header.setForeground(new Color(75, 129, 144));
        header.setFont(new Font("Krona One",Font.PLAIN,22));
        headingPanel.add(header);

        JLabel enterDetails=new JLabel("Enter details to create account");
        enterDetails.setBounds(138,114,360,52);
        enterDetails.setForeground(new Color(121,164,176));
        enterDetails.setFont(new Font("Krona One",Font.PLAIN,16));
        headingPanel.add(enterDetails);

        JPanel EditTextPanel=new JPanel();
        EditTextPanel.setLayout(null);
        EditTextPanel.setBounds(0,220,1440,300);
        add(EditTextPanel);

        JLabel username=new JLabel("Create Username");
        username.setBounds(138,12,200,30);
        username.setForeground(new Color(138, 182, 194));
        username.setFont(new Font("Krona One",Font.PLAIN,16));
        EditTextPanel.add(username);

        JTextField nameField=new JTextField();
        nameField.setBounds(138,40,500,60);
        nameField.setOpaque(false);
        nameField.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        nameField.setForeground(new Color(75, 129, 144));
        nameField.setFont(new Font("Krona One",Font.PLAIN,18));
        EditTextPanel.add(nameField);

        JLabel password=new JLabel("Create Password");
        password.setBounds(138,114,200,30);
        password.setForeground(new Color(138, 182, 194));
        password.setFont(new Font("Krona One",Font.PLAIN,16));
        EditTextPanel.add(password);

        JPasswordField passwordField=new JPasswordField();
        passwordField.setBounds(138,140,500,60);
        passwordField.setOpaque(false);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(138,182,194),4));
        passwordField.setForeground(new Color(75, 129, 144));
        passwordField.setEchoChar('•');
        passwordField.setFont(new Font("Krona One",Font.PLAIN,18));
        EditTextPanel.add(passwordField);

        JLabel confirm=new JLabel("Confirm Password");
        confirm.setBounds(138,212,200,30);
        confirm.setForeground(new Color(138, 182, 194));
        confirm.setFont(new Font("Krona One",Font.PLAIN,16));
        EditTextPanel.add(confirm);

        JPasswordField confirmPassword=new JPasswordField();
        confirmPassword.setBounds(138,238,500,60);
        confirmPassword.setOpaque(false);
        confirmPassword.setBorder(BorderFactory.createLineBorder(new Color(138,182,194),4));
        confirmPassword.setForeground(new Color(75, 129, 144));
        passwordField.setEchoChar('•');
        confirmPassword.setFont(new Font("Krona One",Font.PLAIN,18));
        EditTextPanel.add(confirmPassword);

        JButton registerButton =new JButton("Register");
        registerButton.setFont(new Font("Krona One",Font.PLAIN,16));
        registerButton.setBorder(null);
        registerButton.setBounds(138,560,500,60);
        registerButton.setForeground(Color.WHITE);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=nameField.getText();
                String userPassword=new String(passwordField.getPassword());
                String userConfirmPassword=new String(confirmPassword.getPassword());

                if(userPassword.equals(userConfirmPassword)){
                    boolean isUnique=true;
                        try{
                            Connection connection=DriverManager.getConnection(Main.urlSQL,Main.usernameSQL,Main.passwordSQL);
                            Statement statement=connection.createStatement();
                            ResultSet resultSet=statement.executeQuery("SELECT * FROM users;");
                            while(resultSet.next()){
                                if(username.equals(resultSet.getString("name"))){
                                    isUnique = false;
                                    break;
                                }
                            }
                        }catch(Exception exception){
                            JOptionPane.showMessageDialog(null,exception.getMessage(),"404",JOptionPane.QUESTION_MESSAGE);
                        }
                        if(!isUnique){
                            JOptionPane.showMessageDialog(null, "This Username Already Exists","Try Another",JOptionPane.WARNING_MESSAGE);
                        }else {
                            if(register(username,userPassword)){
                                JOptionPane.showMessageDialog(null, "Account Created Successfully, Login Now","Success",JOptionPane.PLAIN_MESSAGE);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Error Occurred","404",JOptionPane.QUESTION_MESSAGE);
                            }
                            dispose();
                            new LoginPage();
                        }

                }else{
                    JOptionPane.showMessageDialog(null,"Password mismatched","Try Again",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        registerButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                registerButton.setBackground(new Color(167, 210, 221));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerButton.setBackground(new Color(138,182,194));
            }
        });
        registerButton.setBackground(new Color(138,182,194));
        add(registerButton);


        JButton loginButton = new JButton("Already have an account? Login");
        loginButton.setFont(new Font("Krona One",Font.PLAIN,16));
        loginButton.setBounds(138,620,500,60);
        loginButton.setBorder(null);
        loginButton.setForeground(new Color(121,164,176));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage();
            }
        });
        loginButton.setBackground(Color.white);
        loginButton.setOpaque(false);
        add(loginButton);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public static boolean register(String username, String password) {

        try {
            Connection connection = DriverManager.getConnection(Main.urlSQL, Main.usernameSQL, Main.passwordSQL);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO users (name,password) VALUES ('"+username+"','"+password+"');";
            int rows= statement.executeUpdate(query);
            if(rows>0){
                return true;
            }
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null,exception.getMessage(),"404",JOptionPane.QUESTION_MESSAGE);
        }
        return false;
    }
}