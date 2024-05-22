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


public  class ManagementDashboard extends JFrame 
{
  

    JPanel panel1,panel2,panel3;
    JLabel cardiologist,neurologist, urologist ,orthopedic, intro,intro1,pic1,pic2,pic3,pic4, name, intro2;
    ImageIcon img1,img2,img3,img4,img5;
    JButton appointMentbtn, logOutbtn,cardiobtn ,  neurobtn, orthobtn, urobtn ;
    JScrollPane scrollPane;


        
    // private User user;
    DefaultTableModel tableModel;
    JTable userTable;
    String[] cols = {"Patient", "Date", "Time"};
    // String [][] rows;
    String[][] rows =null;
   
    

        

        Color color1 =new Color(63,105,179,255);
		Color color2 =new Color(20,132,202,255);
        // Color color3=new Color(117,154,186,255);



        Font myfont1=new Font ("Calibri", Font.BOLD,17);
        Font myfont2=new Font ("Calibri", Font.BOLD,23);
        Font myfont3=new Font ("Calibri", Font.BOLD,30);


        Management management;
	   
         public ManagementDashboard(Management management){

           
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

  
 
            appointMentbtn = new JButton();
            appointMentbtn.setText("Appointments");
		    appointMentbtn.setContentAreaFilled(false);
            appointMentbtn.setBorderPainted(false);
		    appointMentbtn.setForeground(Color.WHITE);
		    appointMentbtn.setFont(myfont2);
		    appointMentbtn.setBounds(0, 80, 210, 60);
            panel2.add(appointMentbtn);

           logOutbtn = new JButton();
           logOutbtn.setText("Log Out");
		   logOutbtn.setContentAreaFilled(false);
           logOutbtn.setBorderPainted(false);
		   logOutbtn.setForeground(Color.WHITE);
		   logOutbtn.setFont(myfont2);
           logOutbtn.setBounds(0, 170, 130, 50);
           panel2.add(logOutbtn);


           try (BufferedReader reader = new BufferedReader(new FileReader("Appointment.txt"))) {
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

        scrollPane = new JScrollPane(userTable);
        scrollPane.setBounds(50, 200, 600, 200);
        userTable.setPreferredScrollableViewportSize(new Dimension(600, 400)); // Set preferred size of the table
        panel3.add(scrollPane);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(true);
    }
    
}