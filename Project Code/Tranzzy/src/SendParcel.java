import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class SendParcel extends JFrame{
    SendParcel(){
        setTitle("Send Parcel");
        setBounds(0,0,1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(121, 164, 176));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

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
                new MainMenu();
            }
        });

        JPanel constraint=new JPanel();
        constraint.setLayout(null);
        constraint.setBackground(Color.white);
        constraint.setBounds(200,160,1115,590);
        add(constraint);
        toolBar.add(backButton);

        JLabel sendParcelLabel = new JLabel("Send Parcel", SwingConstants.CENTER);
        sendParcelLabel.setFont(new Font("Krona One", Font.BOLD, 24));
        sendParcelLabel.setForeground(new Color(75, 129, 144));
        sendParcelLabel.setBounds(220, 20, 1080, 40);
        toolBar.add(sendParcelLabel);

        JLabel enterDetailsText= new JLabel("Enter Details");
        enterDetailsText.setForeground(new Color(121, 164, 176));
        enterDetailsText.setBounds(470,20,200,18);
        enterDetailsText.setFont(new Font("Krona One",Font.PLAIN,18));
        constraint.add(enterDetailsText);

        JLabel senderName=new JLabel("Sender's Name");
        senderName.setBounds(30,50,360,52);
        senderName.setForeground(new Color(121,164,176));
        senderName.setFont(new Font("Krona One",Font.PLAIN,16));
        constraint.add(senderName);

        JTextField senderNameField=new JTextField();
        senderNameField.setBounds(30,92,500,60);
        senderNameField.setOpaque(false);
        senderNameField.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        senderNameField.setForeground(new Color(75, 129, 144));
        senderNameField.setFont(new Font("Krona One",Font.PLAIN,18));
        constraint.add(senderNameField);

        JLabel receiverName=new JLabel("Receiver's Name");
        receiverName.setBounds(580,50,360,52);
        receiverName.setForeground(new Color(121,164,176));
        receiverName.setFont(new Font("Krona One",Font.PLAIN,16));
        constraint.add(receiverName);

        JTextField receiverNameField=new JTextField();
        receiverNameField.setBounds(580,92,500,60);
        receiverNameField.setOpaque(false);
        receiverNameField.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        receiverNameField.setForeground(new Color(75, 129, 144));
        receiverNameField.setFont(new Font("Krona One",Font.PLAIN,18));
        constraint.add(receiverNameField);

        JLabel senderNo=new JLabel("Sender's Contact No.");
        senderNo.setBounds(30,150,500,52);
        senderNo.setForeground(new Color(121,164,176));
        senderNo.setFont(new Font("Krona One",Font.PLAIN,16));
        constraint.add(senderNo);

        JTextField senderNoField=new JTextField();
        senderNoField.setBounds(30,192,500,60);
        senderNoField.setOpaque(false);
        senderNoField.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        senderNoField.setForeground(new Color(75, 129, 144));
        senderNoField.setFont(new Font("Krona One",Font.PLAIN,18));
        constraint.add(senderNoField);

        JLabel recieverNo=new JLabel("Receiver's Contact No.");
        recieverNo.setBounds(580,150,360,52);
        recieverNo.setForeground(new Color(121,164,176));
        recieverNo.setFont(new Font("Krona One",Font.PLAIN,16));
        constraint.add(recieverNo);

        JTextField recieverNoField=new JTextField();
        recieverNoField.setBounds(580,192,500,60);
        recieverNoField.setOpaque(false);
        recieverNoField.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        recieverNoField.setForeground(new Color(75, 129, 144));
        recieverNoField.setFont(new Font("Krona One",Font.PLAIN,18));
        constraint.add(recieverNoField);

        String[] cities = {
                "Karachi",
                "Lahore",
                "Islamabad",
                "Rawalpindi",
                "Faisalabad",
                "Multan",
                "Peshawar",
                "Quetta",
                "Hyderabad",
                "Sialkot",
                "Gujranwala",
                "Bahawalpur",
                "Sukkur",
                "Mardan",
                "Abbottabad",
                "Larkana",
                "Sargodha",
                "Sheikhupura",
                "Mirpur",
                "Dera Ghazi Khan"
        };

        JLabel sendingLocationLabel=new JLabel("Sending Location");
        sendingLocationLabel.setBounds(30,194+54,360,52);
        sendingLocationLabel.setForeground(new Color(121,164,176));
        sendingLocationLabel.setFont(new Font("Krona One",Font.PLAIN,16));
        constraint.add(sendingLocationLabel);

        JComboBox <String> senderComboBox=new JComboBox<>(cities);
        senderComboBox.setBounds(30,194+54+42,500,60);
        senderComboBox.setOpaque(false);
        senderComboBox.setBackground(Color.WHITE);
        senderComboBox.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        senderComboBox.setForeground(new Color(75, 129, 144));
        senderComboBox.setFont(new Font("Krona One",Font.PLAIN,18));
        constraint.add(senderComboBox);

        JLabel receivingLocationLabel=new JLabel("Receiving Location");
        receivingLocationLabel.setForeground(new Color(121,164,176));
        receivingLocationLabel.setBounds(580,194+54,360,52);
        receivingLocationLabel.setFont(new Font("Krona One",Font.PLAIN,16));
        constraint.add(receivingLocationLabel);

        JComboBox <String> receiverComboBox=new JComboBox<>(cities);
        receiverComboBox.setBounds(580,194+54+42,500,60);
        receiverComboBox.setBackground(Color.WHITE);
        receiverComboBox.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        receiverComboBox.setForeground(new Color(75, 129, 144));
        receiverComboBox.setFont(new Font("Krona One",Font.PLAIN,18));
        constraint.add(receiverComboBox);

        JLabel weightLabel=new JLabel("Weight (KG) ");
        weightLabel.setBounds(30,194+54+42+54,360,52);
        weightLabel.setForeground(new Color(121,164,176));
        weightLabel.setFont(new Font("Krona One",Font.PLAIN,16));
        constraint.add(weightLabel);

        DecimalFormat decimalFormat=new DecimalFormat("#0.00");
        NumberFormatter numberFormatter=new NumberFormatter(decimalFormat);
        numberFormatter.setAllowsInvalid(false);

        JFormattedTextField weightField=new JFormattedTextField(numberFormatter);
        weightField.setBounds(30,194+54+42+54+42,500,60);
        weightField.setOpaque(false);
        weightField.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        weightField.setForeground(new Color(75, 129, 144));
        weightField.setFont(new Font("Krona One",Font.PLAIN,18));
        constraint.add(weightField);

        JCheckBox fragileCheckBox=new JCheckBox("Fragile");
        fragileCheckBox.setForeground(new Color(121, 164, 176));
        fragileCheckBox.setFont(new Font("Krona One",Font.PLAIN,18));
        fragileCheckBox.setBounds(580,390,120,50);
        fragileCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        fragileCheckBox.setOpaque(false);
        constraint.add(fragileCheckBox);

        JCheckBox urgentCheckBox=new JCheckBox("Urgent");
        urgentCheckBox.setForeground(new Color(121, 164, 176));
        urgentCheckBox.setFont(new Font("Krona One",Font.PLAIN,18));
        urgentCheckBox.setBounds(714,390,130,50);
        urgentCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        urgentCheckBox.setOpaque(false);
        constraint.add(urgentCheckBox);

        JCheckBox CODCheckBox=new JCheckBox("Cash On Delivery");
        CODCheckBox.setForeground(new Color(121, 164, 176));
        CODCheckBox.setFont(new Font("Krona One",Font.PLAIN,18));
        CODCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        CODCheckBox.setBounds(850,390,250,50);
        CODCheckBox.setOpaque(false);
        constraint.add(CODCheckBox);

        JButton confirmParcelBtn=new JButton("Confirm Parcel");
        confirmParcelBtn.setFont(new Font("Krona One",Font.PLAIN,16));
        confirmParcelBtn.setForeground(Color.WHITE);
        confirmParcelBtn.setBorder(null);
        confirmParcelBtn.setBounds(30,486,1100-30-30,60);
        confirmParcelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        confirmParcelBtn.setBackground(new Color(121,164,176));
        confirmParcelBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                confirmParcelBtn.setBackground(new Color(167, 210, 221));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                confirmParcelBtn.setBackground(new Color(138,182,194));
            }
        });
        constraint.add(confirmParcelBtn);
        confirmParcelBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String senderContactNo=senderNoField.getText();
                String receiverContactNo=recieverNoField.getText();

                if(senderContactNo.length()==11 && receiverContactNo.length()==11&& receiverContactNo.startsWith("03") && senderContactNo.startsWith("03") ){
                    String userGivenWeight=weightField.getText();
                    double weightFromUser=Double.parseDouble(userGivenWeight);

                    if(weightFromUser>0){
                        String senderName=senderNameField.getText();
                        String receiverName=receiverNameField.getText();
                        String senderLoc=(String)senderComboBox.getSelectedItem();
                        String receiverLoc=(String) receiverComboBox.getSelectedItem();
                        boolean fragile=fragileCheckBox.isSelected();
                        boolean cashOnDelivery=CODCheckBox.isSelected();
                        boolean urgent=urgentCheckBox.isSelected();

                        double charges=150;//Same for every destination
                        charges*=weightFromUser;
                        if(fragile){
                            charges*=1.4;
                        }
                        if(urgent){
                            charges*=1.3;
                        }
                        if(cashOnDelivery){
                            charges+=150;
                        }
                        if(Main.sendingParcel(senderName,senderContactNo,senderLoc,receiverName,receiverContactNo,receiverLoc,weightFromUser,fragile,urgent,cashOnDelivery,charges)){
                            dispose();
                            new ParcelSent(senderName,senderContactNo,senderLoc,receiverName,receiverContactNo,receiverLoc,weightFromUser,fragile,cashOnDelivery,urgent,charges);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Weight can not be "+weightFromUser,"Error",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Contact Number must be correct","Error",JOptionPane.WARNING_MESSAGE);

                }

            }
        });


        setVisible(true);
    }

}
