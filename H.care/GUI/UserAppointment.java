package GUI;
import Entity.*;
import java.lang.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class UserAppointment extends JFrame 
{

    JPanel panel1,panel2,panel3;
    JFrame frame;


    JLabel cardiologist,neurologist, urologist ,orthopedic, intro,intro1,pic1,pic2,pic3,pic4, name, intro2;
    ImageIcon img1,img2,img3,img4,img5;

    JButton homebtn, appointMentbtn, logOutbtn,cardiobtn ,  neurobtn, orthobtn, urobtn ;
    JScrollPane scrollPane;



    // private User user;
    private DefaultTableModel tableModel;
    private JTable userTable;
    private String[] cols = {"Doctor", "Date", "Time"};
    private String rows[][];
   
    

        

        Color color1 =new Color(63,105,179,255);
		Color color2 =new Color(20,132,202,255);
        Color color3=new Color(117,154,186,255);



        Font myfont1=new Font ("Calibri", Font.BOLD,17);
        Font myfont2=new Font ("Calibri", Font.BOLD,20);
        Font myfont3=new Font ("Calibri", Font.BOLD,30);


        User user;
	   
         public UserAppointment(User user){
            this.user = user;


            this.setSize(1000, 600);
            this.setLocationRelativeTo(null); // Center the frame
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            img1 = new ImageIcon("Image/logo.png");

            panel1 = new JPanel();
            panel1.setBounds(0, 0, 300, 100);
            panel1.setBackground(color2);
            panel1.setLayout(new BorderLayout());
            panel1.setLayout(null);
           

            // pic1 = new JLabel(img);
            // panel1.add(pic1);


            panel2 = new JPanel();
            panel2.setBackground(color1);
            panel2.setBounds(0, 70, 300, 500);
            panel2.setLayout(null);

            panel3=new JPanel();
            panel3.setBounds(300, 0, 700, 600);
            // panel3.setBackground(color3);
            panel3.setLayout(null);



            name=new JLabel("WELCOME TO H.Care");
		    name.setBounds(15,10,300,90);
		    name.setFont(myfont3);
		    name.setForeground(Color.WHITE);
		    panel1.add(name);

       
            // intro1=new JLabel("Health Checkup");
            // intro1.setBounds(260,0,1000,50);
            // intro1.setFont(myfont3);
		    // intro1.setForeground(Color.WHITE);


		    // intro2= new JLabel("  Find experienced doctors across all specialties");
		    // intro2.setBounds(50,40,1000,50);
		    // intro2.setFont(myfont3);
            // intro2.setForeground(Color.WHITE);
		    // panel3.add(intro2);
		    // panel3.add(intro1);

            homebtn = new JButton();
            homebtn.setText("Home");
		    homebtn .setContentAreaFilled(false);
            homebtn .setBorderPainted(false);
		    homebtn.setForeground(Color.WHITE);
		    homebtn.setFont(myfont1);
            homebtn .setBounds(5, 50, 130, 50);
            panel2.add(homebtn);
 
            appointMentbtn = new JButton();
            appointMentbtn.setText("My Appointment");
		    appointMentbtn.setContentAreaFilled(false);
            appointMentbtn.setBorderPainted(false);
		    appointMentbtn.setForeground(Color.WHITE);
		    appointMentbtn.setFont(myfont1);
		    appointMentbtn.setBounds(0, 110, 210, 60);
            panel2.add(appointMentbtn);

           logOutbtn = new JButton();
           logOutbtn.setText("Log Out");
		   logOutbtn.setContentAreaFilled(false);
           logOutbtn.setBorderPainted(false);
		   logOutbtn.setForeground(Color.WHITE);
		   logOutbtn.setFont(myfont1);
           logOutbtn.setBounds(5, 170, 130, 50);
           panel2.add(logOutbtn);


           try (BufferedReader reader = new BufferedReader(new FileReader("Data/Appointment.txt"))) {
             String line;
             int numRows = 0;
            while ((line = reader.readLine()) != null) {
                numRows++;
             }
            rows = new String[numRows][cols.length];
        
            int row = 0; // Reset row counter
            reader.close(); // Close the reader after counting rows
        
            // Reopen the file and read it again
            try (BufferedReader newReader = new BufferedReader(new FileReader("Appointment.txt"))) {
                while ((line = newReader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length >= 3) {
                        for (int col = 0; col < cols.length; col++) {
                            rows[row][col] = data[col];
                        }
                    } else {
                        // Handle the case where data has fewer than three elements
                        // For example, you might want to skip or log these cases
                    }
                    row++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading appointments from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        

        tableModel = new DefaultTableModel(rows, cols);
        userTable = new JTable(tableModel);
        userTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        userTable.setRowHeight(30);
        userTable.setFont(new Font("Calibri", Font.BOLD, 20));

        userTable.getColumnModel().getColumn(0).setPreferredWidth(300);
        userTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        userTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        
        userTable.setBounds(280,150,600,200);
        Font font=new Font("Calibri",Font.BOLD,15);
        userTable.setFont(font);

        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBounds(50, 200, 600, 200);
        userTable.setPreferredScrollableViewportSize(new Dimension(600, 400)); // Set preferred size of the table
        panel3.add(scrollPane);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(true);



            // table.getColumnModel().getColumn(1).setPreferredWidth(423);
            // table.setBounds(280,150,400,400);
            // font=new Font("Calibri",Font.BOLD,15);
            // table.setFont(font);
            // scroll = new JScrollPane(table);
            // scroll.setBounds(280,180,500,200);
            // homepagPanel.add(scroll);
        



        
    }


    public void actionPerformed(ActionEvent ae)
    {


        if (ae.getSource() == logOutbtn) {
            // 
            HomePage h1 = new HomePage();
            h1.setVisible(true);
            this.setVisible(false);



        }
        else if (ae.getSource() == homebtn) {
            // 
            UserDashboard ud=new UserDashboard(user);
            ud.setVisible(true);
            this.setVisible(false);



        }
       
   }
}
//     public void loadUserData(){
//         tableModel = new DefaultTableModel(new Object[]{"Name", "Phone Number", "Date of Birth", "Password"}, 0);
//         userTable = new JTable(tableModel);
//         // userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only one row selection

//         JScrollPane scrollPane = new JScrollPane(userTable);
//         scrollPane.setBounds(50, 50, 500, 300); // Adjust the bounds as needed
//         panel3.add(scrollPane); 
//         this.add(panel3);
//     //     // updateButton = new JButton("Update User");
//     //     // updateButton.addActionListener(this);
//     //     // updateButton.setEnabled(false); // Initially disabled until a row is selected
//     //     // updateButton.setBounds(200, 600, 150, 30); // Adjust the bounds as needed
//     //     // add(updateButton);

//     //     // deleteButton = new JButton("Delete User");
//     //     // deleteButton.addActionListener(this);
//     //     // deleteButton.setEnabled(false); // Initially disabled until a row is selected
//     //     // deleteButton.setBounds(400, 600, 150, 30); // Adjust the bounds as needed
//     //     // add(deleteButton);

//     //     // signoutButton = new JButton("Sign Out");
//     //     // signoutButton.addActionListener(this);
//     //     // signoutButton.setBounds(600, 600, 150, 30); // Adjust the bounds as needed
//     //     // add(signoutButton);
//  }

//    public void showAppointments() {
//     // Method to show appointments of the user
//     // Clear existing rows
//     tableModel.setRowCount(0);

//     String fileName = "Appoinment.txt";
//     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//         String line;
//         boolean hasAppointments = false;
//         while ((line = reader.readLine()) != null) {
//             String[] appointmentData = line.split(",");
//             if (appointmentData.length == 3) { // Assuming each line contains doctor name, date, and time separated by comma
//                 tableModel.addRow(new Object[]{appointmentData[0], appointmentData[1], appointmentData[2]});
//                 hasAppointments = true;
//             }
//         }

//         if (!hasAppointments) {
//             JOptionPane.showMessageDialog(this, "You have no appointments.", "No Appointments", JOptionPane.INFORMATION_MESSAGE);
//         }
//     } catch (IOException e) {
//         e.printStackTrace();
//         JOptionPane.showMessageDialog(this, "Error reading appointments from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//     }
// }
