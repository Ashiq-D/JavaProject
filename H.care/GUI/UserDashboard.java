package GUI;
import Entity.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class UserDashboard extends JFrame implements ActionListener
{

    JPanel panel1,panel2,panel3;
    JFrame frame;

    JLabel cardiologist,neurologist, urologist ,orthopedic, intro,intro1,pic1,pic2,pic3,pic4, name, intro2;
    ImageIcon img1,img2,img3,img4,img5;

    JButton homebtn, appointMentbtn, logOutbtn,cardiobtn ,  neurobtn, orthobtn, urobtn ;

    // private User user;
    private DefaultTableModel tableModel;
    private JTable userTable;
    

        

        Color color1 =new Color(63,105,179,255);
		Color color2 =new Color(20,132,202,255);
        Color color3=new Color(117,154,186,255);



        Font myfont1=new Font ("Calibri", Font.BOLD,17);
        Font myfont2=new Font ("Calibri", Font.BOLD,20);
        Font myfont3=new Font ("Calibri", Font.BOLD,30);

        User user;

	   
         public UserDashboard(User user){

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
            panel3.setBackground(color3);
            panel3.setLayout(null);



            name=new JLabel("WELCOME TO H.Care");
		    name.setBounds(15,10,300,90);
		    name.setFont(myfont3);
		    name.setForeground(Color.WHITE);
		    panel1.add(name);

       
            intro1=new JLabel("Health Checkup");
            intro1.setBounds(260,0,1000,50);
            intro1.setFont(myfont3);
		    intro1.setForeground(Color.WHITE);


		    intro2= new JLabel("  Find experienced doctors across all specialties");
		    intro2.setBounds(50,40,1000,50);
		    intro2.setFont(myfont3);
            intro2.setForeground(Color.WHITE);
		    panel3.add(intro2);
		    panel3.add(intro1);
  
            cardiologist=new JLabel("CARDIOLOGIST");
		    cardiologist.setBounds(150,250,200,50);
	        cardiologist.setFont(myfont1);
		    cardiologist.setForeground(Color.WHITE);
		    panel3.add(cardiologist);

            neurologist=new JLabel("NEUROLOGIST");
		    neurologist.setBounds(470,250,200,50);
	        neurologist.setFont(myfont1);
		    neurologist.setForeground(Color.WHITE);
		    panel3.add(neurologist);

            urologist=new JLabel("UROLOGIST");
		    urologist.setBounds(160,470,200,50);
	        urologist.setFont(myfont1);
		    urologist.setForeground(Color.WHITE);
		    panel3.add(urologist);

            orthopedic=new JLabel("ORTHOPEDIC");
		    orthopedic.setBounds(470,470,200,50);
	        orthopedic.setFont(myfont1);
		    orthopedic.setForeground(Color.WHITE);
		    panel3.add(orthopedic);


        img2 = new ImageIcon("Image/Cardiology.png");
        pic1 = new JLabel(img2);
        pic1.setBounds(0,0,200,150);
        pic1.setOpaque(true);
        
        img3 = new ImageIcon("Image/Neurology.png");
        pic2 = new JLabel(img3);
        pic2.setBounds(0,0,200,150);
        pic2.setOpaque(true);
        
		img4 = new ImageIcon("Image/Urology.png");
        pic3 = new JLabel(img4);
        pic3.setBounds(0,0,200,150);
        pic3.setOpaque(true);

		img5 = new ImageIcon("Image/Orthopedic.png");
        pic4 = new JLabel(img5);
        pic4.setBounds(0,0,200,150);
        pic4.setOpaque(true);


            cardiobtn = new JButton();
            cardiobtn.setText("Cardiology");
            cardiobtn.setBounds(100, 100, 200, 150);
            cardiobtn.setFont(myfont2);
            cardiobtn.addActionListener(this);
            cardiobtn.add(pic1);
            panel3.add(cardiobtn);


            neurobtn=new JButton("Neurology");
            neurobtn.setBounds(420,100,200,150);
	        neurobtn.setFont(myfont2);
            neurobtn.addActionListener(this);
            neurobtn.add(pic2);
            panel3.add( neurobtn);

       

            urobtn=new JButton("Urology");
	        urobtn.setBounds(100,320,200,150);
	        urobtn.setFont(myfont2);
            urobtn.addActionListener(this);
           urobtn.add(pic3);
            panel3.add(urobtn);


            orthobtn=new JButton("Orthopedic");
		    orthobtn.setBounds(420,320,200,150);
		    orthobtn.setFont(myfont2);
             orthobtn.addActionListener(this);
            orthobtn.add(pic4);
            panel3.add(orthobtn);


            homebtn = new JButton();
            homebtn.setText("Home");
		    homebtn .setContentAreaFilled(false);
            homebtn .setBorderPainted(false);
		    homebtn.setForeground(Color.WHITE);
		    homebtn.setFont(myfont1);
            homebtn .setBounds(5, 50, 130, 50);
            homebtn .addActionListener(this);
            panel2.add(homebtn);
 
            appointMentbtn = new JButton();
            appointMentbtn.setText("My Appointment");
		    appointMentbtn.setContentAreaFilled(false);
            appointMentbtn.setBorderPainted(false);
		    appointMentbtn.setForeground(Color.WHITE);
		    appointMentbtn.setFont(myfont1);
		    appointMentbtn.setBounds(0, 110, 210, 60);
            appointMentbtn.addActionListener(this);
            panel2.add(appointMentbtn);

           logOutbtn = new JButton();
           logOutbtn.setText("Log Out");
		   logOutbtn.setContentAreaFilled(false);
           logOutbtn.setBorderPainted(false);
		   logOutbtn.setForeground(Color.WHITE);
		   logOutbtn.setFont(myfont1);
           logOutbtn.setBounds(5, 170, 130, 50);
           logOutbtn.addActionListener(this);
           panel2.add(logOutbtn);

           

          this.add(panel1);
          this.add(panel2);
          this.add(panel3);
          this.setVisible(true);
        



        
    }

        //     public UserDashboard(User user)
        // {
        //     super("User Dashboard");
        //     this.user= user;
        //     UserDashboard();
        //     displayAppointments();
        
   
        // } 


    // private void displayAppointments() {
    //     for (Appointment appointment : user.getAppointments()) {
    //         tableModel.addRow(new Object[]{appointment.getDoctor(), appointment.getDate(), appointment.getTime()});
    //     }


    




        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == cardiobtn)
             {
            
                Cardiology c1 = new Cardiology();
                c1.setVisible(true);
                this.setVisible(false);
            }
            else if (ae.getSource() == neurobtn)
             {
                Neurology n1= new Neurology();
                n1.setVisible(true);
                this.setVisible(false);
             }
             else if (ae.getSource() == urobtn)
             {
                Urology u1= new Urology();
                u1.setVisible(true);
                this.setVisible(false);
             }
             else if (ae.getSource() == orthobtn)
             {
                Orthopedic o1= new Orthopedic();
                o1.setVisible(true);
                this.setVisible(false);
             }
             else if (ae.getSource() == appointMentbtn) {
                // 
                UserAppointment u = new UserAppointment(user);
                u.setVisible(true);
                this.setVisible(false);



            }

            else if (ae.getSource() == logOutbtn) {
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





            //  else if (ae.getSource() == appointMentbtn )
            //  {
            //     Appoinment a1= new Appoinment();
            //     a1.setVisible(true);
            //     this.setVisible(false);
            //  }
       

   }
    // public static void main(String[] args) {
    //     UserDashboard m = new UserDashboard();
    //     m.setVisible(true);
    // }
   
}