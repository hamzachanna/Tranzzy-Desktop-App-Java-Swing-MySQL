import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTour extends JFrame {
    BookTour(){
        setTitle("Book Tour");
        setBounds(0,0,1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(121, 164, 176));

        JPanel toolBar = new JPanel(null);
        toolBar.setBackground(Color.WHITE);
        toolBar.setBounds(0, 0, 1920, 80);
        add(toolBar);

        JLabel bookTourLabel = new JLabel("Book Tour", SwingConstants.CENTER);
        bookTourLabel.setFont(new Font("Krona One", Font.BOLD, 24));
        bookTourLabel.setForeground(new Color(75, 129, 144));
        bookTourLabel.setBounds(226, 20, 1080, 40);
        toolBar.add(bookTourLabel);
        setVisible(true);

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
        toolBar.add(backButton);

        JPanel constraint=new JPanel();
        constraint.setLayout(null);
        constraint.setBackground(Color.white);
        constraint.setBounds(230,160,1100,540);

        add(constraint);

        JLabel enterDetailsText= new JLabel("Enter Details");
        enterDetailsText.setForeground(new Color(121, 164, 176));
        enterDetailsText.setBounds(460,20,200,18);
        enterDetailsText.setFont(new Font("Krona One",Font.PLAIN,20));
        constraint.add(enterDetailsText);

        JLabel name=new JLabel("Enter name");
        name.setBounds(30,54,360,52);
        name.setForeground(new Color(121,164,176));
        name.setFont(new Font("Krona One",Font.PLAIN,16));
        constraint.add(name);

        JTextField nameField=new JTextField();
        nameField.setBounds(30,96,1100-30-30,60);
        nameField.setOpaque(false);
        nameField.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        nameField.setForeground(new Color(75, 129, 144));
        nameField.setFont(new Font("Krona One",Font.PLAIN,18));
        constraint.add(nameField);

        JLabel pickupLabel=new JLabel("Select Pickup");
        pickupLabel.setBounds(30,168,1100-30-30,40);
        pickupLabel.setFont(new Font("Krona One",Font.PLAIN,16));
        pickupLabel.setForeground(new Color(121,164,176));
        constraint.add(pickupLabel);

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
        
        JComboBox<String> comboBoxPickUp=new JComboBox<>(cities);
        comboBoxPickUp.setForeground(new Color(75, 129, 144));
        comboBoxPickUp.setOpaque(false);
        comboBoxPickUp.setBorder(BorderFactory.createLineBorder(new Color(75, 129, 144)));
        comboBoxPickUp.setFont(new Font("Krona One",Font.PLAIN,18));
        comboBoxPickUp.setBackground(Color.white);
        comboBoxPickUp.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        comboBoxPickUp.setBounds(30,168+36,500,60);
        constraint.add(comboBoxPickUp);

        JLabel destinationLabel=new JLabel("Select Destination");
        destinationLabel.setBounds(570,168,1100-30-30,40);
        destinationLabel.setFont(new Font("Krona One",Font.PLAIN,16));
        destinationLabel.setForeground(new Color(121,164,176));
        constraint.add(destinationLabel);

        JComboBox<String> comboBoxDestination=new JComboBox<>(cities);
        comboBoxDestination.setForeground(new Color(75, 129, 144));
        comboBoxDestination.setOpaque(false);
        comboBoxDestination.setBorder(BorderFactory.createLineBorder(new Color(75, 129, 144)));
        comboBoxDestination.setFont(new Font("Krona One",Font.PLAIN,18));
        comboBoxDestination.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        comboBoxDestination.setBackground(Color.white);
        comboBoxDestination.setBounds(570,168+36,500,60);
        constraint.add(comboBoxDestination);


        JLabel seatsLabel=new JLabel("Seats");
        seatsLabel.setBounds(570,168+106,1100-30-30,40);
        seatsLabel.setFont(new Font("Krona One",Font.PLAIN,16));
        seatsLabel.setForeground(new Color(121,164,176));
        constraint.add(seatsLabel);

        NumberFormatter numberFormatter=new NumberFormatter();
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMaximum(99);

        JFormattedTextField seatsField=new JFormattedTextField(numberFormatter);
        seatsField .setBounds(570,168+106+36,(500)/2,60);
        seatsField.setOpaque(false);
        seatsField.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        seatsField.setForeground(new Color(75, 129, 144));
        seatsField.setFont(new Font("Krona One",Font.PLAIN,16));
        constraint.add(seatsField);

        JLabel selectVehicleLabel=new JLabel("Select Vehicle");
        selectVehicleLabel.setBounds(30,168+106,1100-30-30,40);
        selectVehicleLabel.setFont(new Font("Krona One",Font.PLAIN,16));
        selectVehicleLabel.setForeground(new Color(121,164,176));
        constraint.add(selectVehicleLabel);

        String[] vehicles = {
                "Motorcycle",
                "Car - Economy",
                "Car - Luxury",
                "Car - Electric",
                "Van",
                "Bus"
        };

        JComboBox <String> vehicleComboBox=new JComboBox<>(vehicles);
        vehicleComboBox.setFont(new Font("Krona One",Font.PLAIN,18));
        vehicleComboBox.setBounds(30,168+106+36,500,60);
        vehicleComboBox.setForeground(new Color(75,129,144));
        vehicleComboBox.setBackground(Color.white);
        vehicleComboBox.setBorder(BorderFactory.createLineBorder(new Color(75,129,144)));
        vehicleComboBox.setBorder(BorderFactory.createLineBorder(new Color(138, 182, 194),4));
        constraint.add(vehicleComboBox);

        JCheckBox acCheckBox=new JCheckBox("Air Conditioned");
        acCheckBox.setForeground(new Color(121, 164, 176));
        acCheckBox.setFont(new Font("Krona One",Font.PLAIN,16));
        acCheckBox.setBounds(870,168+106+36,250,60);
        acCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        acCheckBox.setOpaque(false);
        constraint.add(acCheckBox);


        JButton confirmTourBtn=new JButton("Confirm Tour");
        confirmTourBtn.setFont(new Font("Krona One",Font.PLAIN,16));
        confirmTourBtn.setForeground(Color.WHITE);
        confirmTourBtn.setBounds(30,420,1100-30-30,60);
        confirmTourBtn.setBorder(null);
        confirmTourBtn.setBackground(new Color(121,164,176));
        confirmTourBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        confirmTourBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seats=Integer.parseInt(seatsField.getText());
                if(seats>0){
                    String name=nameField.getText();
                    String selectedPickup = (String) comboBoxPickUp.getSelectedItem();
                    String selectedDestination =(String) comboBoxDestination.getSelectedItem();
                    String selectedVehicle =(String) vehicleComboBox.getSelectedItem();
                    boolean hasAC=acCheckBox.isSelected();

                    double fare=1175; //Same For Every Distance
                    if(selectedVehicle.equals("Motorcycle")){
                        fare*=1.1;
                    } else if (selectedVehicle.equals("Car - Economy")) {
                        fare*=1.2;
                    } else if (selectedVehicle.equals("Car - Electric")) {
                        fare*=1.3;
                    } else if (selectedVehicle.equals("Car - Luxury")) {
                        fare*=1.4;
                    } else if (selectedVehicle.equals("Van")) {
                        fare*=1.15;
                    } else if (selectedVehicle.equals("Bus")) {
                        fare*=1.25;
                    }
                    if(hasAC){
                        fare*=1.4;
                    }
                    fare*=seats;
                    if(Main.tourBooking(name,seats,selectedPickup,selectedDestination,selectedVehicle,hasAC,fare)){
                        dispose();
                        new TourConfirmed(name,selectedPickup,selectedDestination,selectedVehicle,hasAC,seats,fare);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Seats Can Not Be "+seats);
                }
            }
        });
        confirmTourBtn.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                confirmTourBtn.setBackground(new Color(167, 210, 221));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                confirmTourBtn.setBackground(new Color(138,182,194));
            }
        });
        constraint.add(confirmTourBtn);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        new BookTour();
    }
}
