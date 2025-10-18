import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TourConfirmed extends JFrame {
    TourConfirmed(String name,String pickup,String destination,String vehicle,boolean hasAC,int seats,double fare){
        setTitle("Tour Confirmed");
        setBounds(0,0,1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(121, 164, 176));

        JPanel toolBar = new JPanel(null);
        toolBar.setBackground(Color.WHITE);
        toolBar.setBounds(0, 0, 1920, 80);
        add(toolBar);
        setVisible(true);

        JLabel tourConfirmedLabel = new JLabel("Tour Confirmed", SwingConstants.CENTER);
        tourConfirmedLabel.setFont(new Font("Krona One", Font.BOLD, 24));
        tourConfirmedLabel.setForeground(new Color(121,164,176));
        tourConfirmedLabel.setBounds(220, 20, 1080, 40);
        toolBar.add(tourConfirmedLabel);

        JPanel leftPanel=new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(440+132,240,250,320);
        leftPanel.setBackground(Color.white);

        JPanel rightPanel=new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.white);
        rightPanel.setBounds(670+132,240,250,320);
        add(rightPanel);

        JLabel nameLabel=new JLabel("Name:");
        nameLabel.setForeground(new Color(121, 164, 176));
        nameLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        nameLabel.setBounds(0,0,250,30);
        leftPanel.add(nameLabel);

        JLabel pickupLabel=new JLabel("Pickup:");
        pickupLabel.setForeground(new Color(121, 164, 176));
        pickupLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        pickupLabel.setBounds(0,40,250,30);
        leftPanel.add(pickupLabel);

        JLabel destinationLabel=new JLabel("Destination:");
        destinationLabel.setForeground(new Color(121, 164, 176));
        destinationLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        destinationLabel.setBounds(0,80,250,30);
        leftPanel.add(destinationLabel);

        JLabel vehicleLabel=new JLabel("Vehicle:");
        vehicleLabel.setForeground(new Color(121, 164, 176));
        vehicleLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        vehicleLabel.setBounds(0,120,250,30);
        leftPanel.add(vehicleLabel);

        JLabel acLabel=new JLabel("AC:");
        acLabel.setForeground(new Color(121, 164, 176));
        acLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        acLabel.setBounds(0,160,250,30);
        leftPanel.add(acLabel);

        JLabel seatsLabel=new JLabel("Seats:");
        seatsLabel.setForeground(new Color(121, 164, 176));
        seatsLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        seatsLabel.setBounds(0,200,250,30);
        leftPanel.add(seatsLabel);


        JLabel fareLabel=new JLabel("Fare:");
        fareLabel.setForeground(new Color(121, 164, 176));
        fareLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        fareLabel.setBounds(0,240,250,30);
        leftPanel.add(fareLabel);


        JLabel userNameLabel=new JLabel(name);
        userNameLabel.setForeground(new Color(121, 164, 176));
        userNameLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userNameLabel.setBounds(0,0,250,30);
        rightPanel.add(userNameLabel);

        JLabel userPickupLabel=new JLabel(pickup);
        userPickupLabel.setForeground(new Color(121, 164, 176));
        userPickupLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userPickupLabel.setBounds(0,40,250,30);
        rightPanel.add(userPickupLabel);

        JLabel userDestinationLabel=new JLabel(destination);
        userDestinationLabel.setForeground(new Color(121, 164, 176));
        userDestinationLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userDestinationLabel.setBounds(0,80,250,30);
        rightPanel.add(userDestinationLabel);

        JLabel userVehicleLabel=new JLabel(vehicle);
        userVehicleLabel.setForeground(new Color(121, 164, 176));
        userVehicleLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userVehicleLabel.setBounds(0,120,250,30);
        rightPanel.add(userVehicleLabel);

        JLabel userACLabel=new JLabel(hasAC ? "Yes": "No");
        userACLabel.setForeground(new Color(121, 164, 176));
        userACLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userACLabel.setBounds(0,160,250,30);
        rightPanel.add(userACLabel);

        JLabel userSeatsLabel=new JLabel(Integer.toString(seats));
        userSeatsLabel.setForeground(new Color(121, 164, 176));
        userSeatsLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userSeatsLabel.setBounds(0,200,250,30);
        rightPanel.add(userSeatsLabel);

        JLabel userFareLabel=new JLabel(Double.toString(fare));
        userFareLabel.setForeground(new Color(121, 164, 176));
        userFareLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userFareLabel.setBounds(0,240,250,30);
        rightPanel.add(userFareLabel);
        add(leftPanel);


        JPanel constraint=new JPanel();
        constraint.setLayout(null);
        constraint.setBackground(Color.white);
        constraint.setBounds(350+112,150,600,500);
        add(constraint);



        JLabel detailsLabel= new JLabel("Details:");
        detailsLabel.setForeground(new Color(121, 164, 176));
        detailsLabel.setBounds(250,50,600,18);
        detailsLabel.setFont(new Font("Krona One",Font.PLAIN,18));
        constraint.add(detailsLabel);


        JButton okBtn=new JButton("OK");
        okBtn.setForeground(Color.white);
        okBtn.setFont(new Font("Krona One",Font.PLAIN,16));
        okBtn.setBorder(null);
        okBtn.setBackground(new Color(121,164,176));
        okBtn.setBounds(88,410,434,50);
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainMenu();
            }
        });
        constraint.add(okBtn);


        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
}
