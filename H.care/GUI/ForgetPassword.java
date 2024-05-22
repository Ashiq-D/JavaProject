package GUI;
import Entity.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class ForgetPassword  extends JFrame {


	//JPanel=a GUI component that functions as a container to hold other components
	   
	   
		   JPanel panel1,panel2;
		   JFrame frame;
		   JLabel intro, phoneNo, newPassword, confirmPassword, pic1;
		   JTextField phoneNofield, newPasswordfield, confirmPasswordfield; 
		   JButton loginbtn;
   
		   ImageIcon image1 = new ImageIcon("Image/H.care.png");
		   ImageIcon image=new ImageIcon("Image/logo.png");
   
		   Color mycolor = new Color(25, 119, 212, 255);
   
		   Font font1 = new Font("Calibri", Font.BOLD, 20);
		   Font font2 = new Font("Calibri", Font.BOLD, 30);
		   Font font3 = new Font("Calibri", Font.BOLD, 15);
		   Font font4 = new Font("Calibri", Font.BOLD, 40);
		   Font font5 = new Font("Calibri", Font.BOLD, 17);
		   Font font6 = new Font("Calibri", Font.BOLD, 25);
          
		   public ForgetPassword()
           {

			this.setSize(1000, 600);
			this.setLocationRelativeTo(null); // Center the frame
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);
   
		   panel1 = new JPanel();
		   panel1.setBounds(0, 0, 400, 600);
		   panel1.setLayout(new BorderLayout());
		   pic1 = new JLabel(image1);
		   panel1.add(pic1);
   
		   panel2 = new JPanel();
		   panel2.setBackground(mycolor);
		   panel2.setBounds(400, 0, 600, 600);
		   panel2.setLayout(null);
		   // panel2.setLayout(new FlowLayout()); to set a new dimension
   
	   
   
		   intro=new JLabel("Change Password");
		   intro.setBounds(150, 10, 500, 100);
		   intro.setFont(font4);
		   intro.setForeground(Color.WHITE);
		   panel2.add(intro);
   
   
		   phoneNo=new JLabel("Phone No*");
		   phoneNo.setBounds(110,120,100,50);
		   phoneNo.setFont(font1);
		   phoneNo.setForeground(Color.WHITE);
		   panel2.add(phoneNo);
		   
		   phoneNofield=new JTextField();
		   phoneNofield.setBounds(110,160,400,50);
		   phoneNofield.setFont(font6);
		   phoneNofield.setForeground(Color.BLACK);
		   panel2.add(phoneNofield);
   
		   newPassword=new JLabel("New Pass*");
		   newPassword.setBounds(110,220,150,50);
		   newPassword.setFont(font1);
		   newPassword.setForeground(Color.WHITE);
		   panel2.add(newPassword);
		   
		   newPasswordfield=new JTextField();
		   newPasswordfield.setBounds(110,260,400,50);
		   newPasswordfield.setFont(font6);
		   newPasswordfield.setForeground(Color.BLACK);
		   panel2.add(newPasswordfield);
   
		   confirmPassword=new JLabel("Confirm Pass*");
		   confirmPassword.setBounds(110,320,150,50);
		   confirmPassword.setFont(font1);
		   confirmPassword.setForeground(Color.WHITE);
		   panel2.add(confirmPassword);
		   
		   confirmPasswordfield=new JTextField();
		   confirmPasswordfield.setBounds(110,360,400,50);
		   confirmPasswordfield.setFont(font6);
		   confirmPasswordfield.setForeground(Color.BLACK);
		   panel2.add(confirmPasswordfield);
		   
   
		   
		   loginbtn=new JButton("Login");
		   loginbtn.setBounds(110,440,400,50);
		   loginbtn.setFont(font6);
		   loginbtn.setForeground(Color.BLACK);
		   //backbtn.addActionListener(this);
		   panel2.add(loginbtn);
   
   
   
		   this.add(panel1);
		   this.add(panel2);
		   this.setVisible(true);
				
    
    }

			    }
