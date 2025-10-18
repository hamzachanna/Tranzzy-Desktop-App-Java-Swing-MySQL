import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.*;

class Main{
    static{
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
    public static final String urlSQL = "jdbc:mysql://127.0.0.1:3306/project";
    public static final String usernameSQL = "root";
    public static final String passwordSQL = "OnePlus.NIGGA";

    public static void main(String[] args) {
        new LoginPage();
    }
    public static boolean tourBooking(String name,int seats ,String pickup,String destination,String vehicle,boolean hasAC,double fare){
        String query="INSERT INTO tours(user_id,seats,fare,pickUp,destination,hasAC,vehicle,name) VALUES (?,?,?,?,?,?,?,?);";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection(urlSQL,usernameSQL,passwordSQL);
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setInt(1,User.userID);
            ps.setInt(2,seats);
            ps.setString(4,pickup);
            ps.setDouble(3,fare);
            ps.setString(5,destination);
            ps.setBoolean(6,hasAC);
            ps.setString(7,vehicle);
            ps.setString(8,name);
            int rows=ps.executeUpdate();
            if(rows>0){
                return true;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    return false;
    }
    public static boolean sendingParcel(String senderName,String senderNo,String senderLoc,String
                                        receiverName,String receiverNo,String receiverLoc,double weight
                                        ,boolean fragile,boolean urgent,boolean cashOnDelivery,double charges){
        String query="INSERT INTO parcels(user_id,senderName,receiverName,senderNo,receiverNo,weight,senderLocation,receiverLocation,fragile,urgent,cashOnDelivery,charges) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection(urlSQL,usernameSQL,passwordSQL);
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,User.userID);
            preparedStatement.setString(2,senderName);
            preparedStatement.setString(3,receiverName);
            preparedStatement.setString(4,senderNo);
            preparedStatement.setString(5,receiverNo);
            preparedStatement.setDouble(6,weight);
            preparedStatement.setString(7,senderLoc);
            preparedStatement.setString(8,receiverLoc);
            preparedStatement.setBoolean(9,fragile);
            preparedStatement.setBoolean(10,urgent);
            preparedStatement.setBoolean(11,cashOnDelivery);
            preparedStatement.setDouble(12,charges);

            int rows=preparedStatement.executeUpdate();
            if(rows>0){
                return true;
            }
        }catch(Exception exception){
            JOptionPane.showMessageDialog(null,exception.getMessage(),"404",JOptionPane.QUESTION_MESSAGE);
        }
        return false;
    }
}

