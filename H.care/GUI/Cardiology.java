package GUI;
import Entity.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public  class Cardiology extends JFrame implements  ActionListener
{


        JPanel panel1,panel2,panel3;
		JLabel name, intro,intro1,pic1,pic2,pic3,pic4;;
        // ImageIcon img1,img2,img3,img4,img5;
        JButton homebtn, appointMentbtn, logOutbtn,btn1,btn2, backbtn;
        

        Color color1 =new Color(63,105,179,255);
		Color color2 =new Color(20,132,202,255);
        Color color3=new Color(117,154,186,255);


        Font myfont1=new Font ("Calibri", Font.BOLD,17);
        Font myfont2=new Font ("Calibri", Font.BOLD,20);
        Font myfont3=new Font ("Calibri", Font.BOLD,30);
	    // img1 = new ImageIcon("Image/logo.png");

        String selectedDoctor;
        User user;

         public Cardiology(){
            super("H.Care");

            this.setSize(1000, 600);
            this.setLocationRelativeTo(null); // Center the frame
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);

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
		name.setBounds(10,20,290,70);
		name.setFont(myfont3);
		name.setForeground(Color.WHITE);
		panel1.add(name);

        homebtn = new JButton();
        homebtn.setText("Home");
		homebtn .setContentAreaFilled(false);
        homebtn .setBorderPainted(false);
		homebtn.setForeground(Color.WHITE);
		homebtn.setFont(myfont1);
        homebtn .setBounds(5, 50, 130, 50);
        homebtn .addActionListener(this);
        // btn1.add(pic1);
        panel2.add(homebtn);

        appointMentbtn = new JButton();
        appointMentbtn.setText("My Appointment");
		appointMentbtn.setContentAreaFilled(false);
        appointMentbtn.setBorderPainted(false);
		appointMentbtn.setForeground(Color.WHITE);
		appointMentbtn.setFont(myfont1);
		appointMentbtn.setBounds(0, 110, 210, 60);
        // btn1.add(pic1);
        panel2.add(appointMentbtn);

        logOutbtn = new JButton();
        logOutbtn.setText("Log Out");
		logOutbtn.setContentAreaFilled(false);
        logOutbtn.setBorderPainted(false);
		logOutbtn.setForeground(Color.WHITE);
		logOutbtn.setFont(myfont1);
        logOutbtn.setBounds(5, 170, 130, 50);
        logOutbtn.addActionListener(this);
        // btn1.add(pic1);
        panel2.add(logOutbtn);

        intro=new JLabel("Doctors of Cardiology");
        intro.setBounds(180,50,1000,50);
        intro.setFont(myfont3);
        intro.setForeground(Color.WHITE);
        panel3.add(intro);



        btn1 = new JButton();
        btn1.setText("Doctor Rahat");
        btn1.setBounds(20, 125, 180, 150);
        btn1.setFont(myfont2);
		btn1.setBackground(Color.RED);
        btn1.addActionListener(this);
        panel3.add(btn1);

        btn1 = new JButton();
        btn1.setText("<html>Dr. Mahbub Mansur<br />MBBS, MD (Cardiology), Fellow, Interventional Cardiology Fellow,<br /> Pacing, EP and Device Implantation");
        btn1.setBounds(230, 125, 400, 150);
        btn1.setFont(myfont2);
		btn1.setBackground(Color.WHITE);
        btn1.setForeground(Color.BLACK);
        btn1.addActionListener(this);
        // frame.add(btn1);
       panel3.add(btn1);


       btn2=new JButton("Doctor Sadik");
       btn2.setBounds(20,280,180,150);
       btn2.setFont(myfont2);
	   btn2.setBackground(Color.YELLOW);
       btn2.addActionListener(this);
       panel3.add(btn2);

       btn2= new JButton();
       btn2.setText("<html>Dr. Asif Manwar<br />MBBS, D. Card (London), Msc Cardiology (UK), Fellow, Pediatric Cardiology & Fetal Echocardiography (India)");
       btn2.setBounds(230, 280, 400, 150);
       btn2.setFont(myfont2);
       btn2.setBackground(Color.WHITE);
       btn2.setForeground(Color.BLACK);
       btn2.addActionListener(this);
    //    frame.add(btn2);
       panel3.add(btn2);

       backbtn = new JButton("BACK");
       backbtn .setBounds(520, 450, 170, 30);
       backbtn .setFont(myfont2);
       backbtn .setContentAreaFilled(false);
       backbtn .setBorderPainted(false);
       backbtn .setForeground(Color.WHITE);
       backbtn .addActionListener(this);
       panel3.add(backbtn );


        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(true);
        



        }
    
        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == btn1)
             {   selectedDoctor = "Dr. Mahbub Mansur"; // Set the selected doctor's name
                writeToAppointmentFile(selectedDoctor);
                new Appoinment(new UserDashboard(user));
                this.setVisible(true);
                this.setVisible(false);
            }
            else if (ae.getSource() == btn2)
             {
                selectedDoctor = "Dr. Asif Manwar   "; // Set the selected doctor's name
                writeToAppointmentFile(selectedDoctor);   
                new Appoinment(new UserDashboard(user));
                this.setVisible(true);
                this.setVisible(false);
             }

             else if(ae.getSource() == backbtn)
             {
              UserDashboard ua=new UserDashboard(user);
              ua.setVisible(true);
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
                UserDashboard d1 = new UserDashboard(user);
                d1.setVisible(true);
                this.setVisible(false);




            } 
        }

             private void writeToAppointmentFile(String doctorName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data/Appointment.txt", true))) {
            writer.write(doctorName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    



        }
        
    
       
    // public static void main(String[] args) {
    //     Cardiology m = new Cardiology();
    //     m.setVisible(true);
    // }
    }