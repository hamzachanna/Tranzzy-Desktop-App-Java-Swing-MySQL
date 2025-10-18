import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParcelSent extends JFrame {
    ParcelSent(String senderName,String senderNo,String senderLoc,String receiverName,String receiverNo,String receiverLoc,double weight,boolean fragile,boolean cashOnDelivery,boolean urgent,double charges){
        setTitle("Parcel Confirmed");
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

        JLabel parcelConfirmedLabel = new JLabel("Parcel Confirmed", SwingConstants.CENTER);
        parcelConfirmedLabel.setFont(new Font("Krona One", Font.BOLD, 24));
        parcelConfirmedLabel.setForeground(new Color(121,164,176));
        parcelConfirmedLabel.setBounds(220, 20, 1080, 40);
        toolBar.add(parcelConfirmedLabel);

        JPanel leftPanel=new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(440+132,180,250,430);
        leftPanel.setBackground(Color.white);

        JPanel rightPanel=new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.white);
        rightPanel.setBounds(670+132,180,250,430);
        add(rightPanel);


        JLabel senderNameLabel=new JLabel("Sender Name:");
        senderNameLabel.setForeground(new Color(121, 164, 176));
        senderNameLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        senderNameLabel.setBounds(0,0,250,30);
        leftPanel.add(senderNameLabel);
        JLabel userSenderNameLabel=new JLabel(senderName);
        userSenderNameLabel.setForeground(new Color(121, 164, 176));
        userSenderNameLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userSenderNameLabel.setBounds(0,0,250,30);
        rightPanel.add(userSenderNameLabel);

        JLabel receiverNameLabel=new JLabel("Receiver Name:");
        receiverNameLabel.setForeground(new Color(121, 164, 176));
        receiverNameLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        receiverNameLabel.setBounds(0,40,250,30);
        leftPanel.add(receiverNameLabel);
        JLabel userReceiverNameLabel=new JLabel(receiverName);
        userReceiverNameLabel.setForeground(new Color(121, 164, 176));
        userReceiverNameLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userReceiverNameLabel.setBounds(0,40,250,30);
        rightPanel.add(userReceiverNameLabel);

        JLabel senderNoLabel=new JLabel("Sender Contact No:");
        senderNoLabel.setForeground(new Color(121, 164, 176));
        senderNoLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        senderNoLabel.setBounds(0,80,250,30);
        leftPanel.add(senderNoLabel);
        JLabel userSenderNoLabel=new JLabel(senderNo);
        userSenderNoLabel.setForeground(new Color(121, 164, 176));
        userSenderNoLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userSenderNoLabel.setBounds(0,80,250,30);
        rightPanel.add(userSenderNoLabel);

        JLabel receiverNoLabel=new JLabel("Receiver Contact No:");
        receiverNoLabel.setForeground(new Color(121, 164, 176));
        receiverNoLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        receiverNoLabel.setBounds(0,120,250,30);
        leftPanel.add(receiverNoLabel);
        JLabel userReceiverNoLabel=new JLabel(receiverNo);
        userReceiverNoLabel.setForeground(new Color(121, 164, 176));
        userReceiverNoLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userReceiverNoLabel.setBounds(0,120,250,30);
        rightPanel.add(userReceiverNoLabel);

        JLabel senderLocationLabel=new JLabel("Sender Location:");
        senderLocationLabel.setForeground(new Color(121, 164, 176));
        senderLocationLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        senderLocationLabel.setBounds(0,160,250,30);
        leftPanel.add(senderLocationLabel);
        JLabel userSenderLocationLabel=new JLabel(senderLoc);
        userSenderLocationLabel.setForeground(new Color(121, 164, 176));
        userSenderLocationLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userSenderLocationLabel.setBounds(0,160,250,30);
        rightPanel.add(userSenderLocationLabel);

        JLabel receiverLocationLabel=new JLabel("Receiver Location:");
        receiverLocationLabel.setForeground(new Color(121, 164, 176));
        receiverLocationLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        receiverLocationLabel.setBounds(0,200,250,30);
        leftPanel.add(receiverLocationLabel);
        JLabel userReceiverLocationLabel=new JLabel(receiverLoc);
        userReceiverLocationLabel.setForeground(new Color(121, 164, 176));
        userReceiverLocationLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userReceiverLocationLabel.setBounds(0,200,250,30);
        rightPanel.add(userReceiverLocationLabel);

        JLabel weightLabel=new JLabel("Weight:");
        weightLabel.setForeground(new Color(121, 164, 176));
        weightLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        weightLabel.setBounds(0,240,250,30);
        leftPanel.add(weightLabel);
        JLabel userWeightLabel=new JLabel(Double.toString(weight));
        userWeightLabel.setForeground(new Color(121, 164, 176));
        userWeightLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userWeightLabel.setBounds(0,240,250,30);
        rightPanel.add(userWeightLabel);

        JLabel fragileLabel=new JLabel("Fragile:");
        fragileLabel.setForeground(new Color(121, 164, 176));
        fragileLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        fragileLabel.setBounds(0,280,250,30);
        leftPanel.add(fragileLabel);
        JLabel userFragileLabel=new JLabel(fragile ? "Yes": "No");
        userFragileLabel.setForeground(new Color(121, 164, 176));
        userFragileLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userFragileLabel.setBounds(0,280,250,30);
        rightPanel.add(userFragileLabel);

        JLabel codLabel=new JLabel("Cash On Delivery:");
        codLabel.setForeground(new Color(121, 164, 176));
        codLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        codLabel.setBounds(0,320,250,30);
        leftPanel.add(codLabel);
        JLabel userCODLabel=new JLabel(cashOnDelivery ? "Yes": "No");
        userCODLabel.setForeground(new Color(121, 164, 176));
        userCODLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userCODLabel.setBounds(0,320,250,30);
        rightPanel.add(userCODLabel);

        JLabel urgentLabel=new JLabel("Urgent:");
        urgentLabel.setForeground(new Color(121, 164, 176));
        urgentLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        urgentLabel.setBounds(0,360,250,30);
        leftPanel.add(urgentLabel);
        JLabel userUrgentLabel=new JLabel(urgent ? "Yes": "No");
        userUrgentLabel.setForeground(new Color(121, 164, 176));
        userUrgentLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userUrgentLabel.setBounds(0,360,250,30);
        rightPanel.add(userUrgentLabel);

        JLabel chargesLabel=new JLabel("Charges:");
        chargesLabel.setForeground(new Color(121, 164, 176));
        chargesLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        chargesLabel.setBounds(0,400,250,30);
        leftPanel.add(chargesLabel);
        JLabel userChargesLabel=new JLabel(Double.toString(charges));
        userChargesLabel.setForeground(new Color(121, 164, 176));
        userChargesLabel.setFont(new Font("Krona One",Font.PLAIN,14));
        userChargesLabel.setBounds(0,400,250,30);
        rightPanel.add(userChargesLabel);
        add(leftPanel);

        JPanel constraint=new JPanel();
        constraint.setLayout(null);
        constraint.setBackground(Color.white);
        constraint.setBounds(350+112,120,600,600);
        add(constraint);

        JLabel detailsLabel= new JLabel("Details:");
        detailsLabel.setForeground(new Color(121, 164, 176));
        detailsLabel.setBounds(250,20,600,18);
        detailsLabel.setFont(new Font("Krona One",Font.PLAIN,18));
        constraint.add(detailsLabel);

        JButton okBtn=new JButton("OK");
        okBtn.setForeground(Color.white);
        okBtn.setBorder(null);
        okBtn.setFont(new Font("Krona One",Font.PLAIN,14));
        okBtn.setBackground(new Color(121,164,176));
        okBtn.setBounds(88,510,500-80,50);
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

    public static void main(String[] args) {
        new ParcelSent("a","a","a","a","a","a",2,true,true,true,4);
    }
}
