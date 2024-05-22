package GUI;
import Entity.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame implements ActionListener
 {
    JPanel panel1, panel2;
    JButton logbtn, forgetbtn, signUpbtn,backbtn;
    JLabel intro1, intro2, pic1,pic2, phnNo, pass, intro3;
    JTextField phnNofield;
    JPasswordField passfield;
    ImageIcon img, img1,img2;
    JRadioButton adminbtn, doctorbtn, patientbtn;


	Color mycolor = new Color(25, 119, 212, 255);
    Font font1 = new Font("Calibri", Font.BOLD, 20);
    Font font2 = new Font("Calibri", Font.BOLD, 30);
    Font font3 = new Font("Calibri", Font.BOLD, 15);
    Font font4 = new Font("Calibri", Font.BOLD, 40);
    Font font5 = new Font("Calibri", Font.BOLD, 17);
    Font font6 = new Font("Calibri", Font.BOLD, 25);


    User user;
    Doctor doctor;
    Management management;
   

    public LogIn() {
        super("My First Gui");
		
		
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // Use layout manager for better organization


        img = new ImageIcon("Image/H.care.png");
        img1 = new ImageIcon("Image/image/logo.png");
		img2 = new ImageIcon("Image/Backbtn.png");


        panel1 = new JPanel();
        panel1.setBounds(0, 0, 400, 600);
        panel1.setLayout(new BorderLayout());
        pic1 = new JLabel(img);
        panel1.add(pic1);


        panel2 = new JPanel();
        panel2.setBackground(mycolor);
        panel2.setBounds(400, 0, 600, 600);
        panel2.setLayout(null);
		
		
	    backbtn = new JButton(img2);
        backbtn.setBounds( 500,10, 25, 25);
		backbtn.setContentAreaFilled(false);
        backbtn.setBorderPainted(false);
        panel2.add(backbtn);
		
		intro1 = new JLabel("Welcome Back");
        intro1.setBounds(160, 10, 500, 100);
        intro1.setFont(font4);
        intro1.setForeground(Color.WHITE);
        panel2.add(intro1);

        intro2 = new JLabel("Log In");
        intro2.setBounds(240, 70, 100, 50);
        intro2.setFont(font2);
        intro2.setForeground(Color.WHITE);
        panel2.add(intro2);

        phnNo = new JLabel("Phone No*");
        phnNo.setBounds(80, 170, 100, 50);
        phnNo.setFont(font1);
        phnNo.setForeground(Color.WHITE);
        panel2.add(phnNo);

        phnNofield = new JTextField();
        phnNofield.setBounds(80, 220, 400, 50);
        phnNofield.setFont(font6);
        phnNofield.setForeground(Color.BLUE);
        panel2.add(phnNofield);

        
        pass = new JLabel("Password*");
        pass.setBounds(80, 280, 200, 50);
        pass.setFont(font1);
        pass.setForeground(Color.WHITE);
        panel2.add(pass);

        passfield = new JPasswordField();
        passfield.setBounds(80, 330, 400, 50);
        passfield.setFont(font6);
        passfield.setForeground(Color.BLUE);
        panel2.add(passfield);
		
		adminbtn = new JRadioButton("Admin");
        adminbtn.setBounds(80, 140, 100, 20);
        adminbtn.setContentAreaFilled(false);
        adminbtn.setBorderPainted(false);
        adminbtn.setForeground(Color.WHITE);
        adminbtn.setFont(font5);
        panel2.add(adminbtn);

        doctorbtn = new JRadioButton("Doctor");
        doctorbtn.setBounds(210, 140, 100, 20);
        doctorbtn.setContentAreaFilled(false);
        doctorbtn.setBorderPainted(false);
        doctorbtn.setForeground(Color.WHITE);
        doctorbtn.setFont(font5);
        panel2.add(doctorbtn);

        patientbtn = new JRadioButton("Patient");
        patientbtn.setBounds(345, 140, 100, 20);
        patientbtn.setContentAreaFilled(false);
        patientbtn.setBorderPainted(false);
        patientbtn.setForeground(Color.WHITE);
        patientbtn.setFont(font5);
        panel2.add(patientbtn);
		
		ButtonGroup group = new ButtonGroup();
        group.add(adminbtn);
        group.add(doctorbtn);
        group.add(patientbtn);
		
		
		logbtn = new JButton("Login");
        logbtn.setBounds(80, 420, 400, 50);
        logbtn.setFont(font3);
        logbtn.setForeground(mycolor);
        logbtn.setBackground(Color.WHITE);
        logbtn.addActionListener(this);
        panel2.add(logbtn);

        forgetbtn = new JButton("Forgot Password?");
        forgetbtn.setBounds(330, 380, 170, 30);
        forgetbtn.setFont(font3);
        forgetbtn.setForeground(Color.WHITE);
        forgetbtn.setContentAreaFilled(false);
        forgetbtn.setBorderPainted(false);
       forgetbtn.addActionListener(this);
        panel2.add(forgetbtn);
	
	
		intro3 = new JLabel("Don't have an account?");
        intro3.setBounds(180, 470, 320, 50);
        intro3.setFont(font3);
        intro3.setForeground(Color.WHITE);
        panel2.add(intro3);
		
		signUpbtn = new JButton("SignUp");
        signUpbtn.setBounds(290, 470, 120, 50);
        signUpbtn.setFont(font3);
        signUpbtn.setForeground(Color.WHITE);
        signUpbtn.setContentAreaFilled(false);
        signUpbtn.setBorderPainted(false);
        signUpbtn.addActionListener(this);
        panel2.add(signUpbtn);
		

        
		
        this.add(panel1);
        this.add(panel2);
        this.setIconImage(img1.getImage());
		this.setVisible(true);
       
        user = new User();
        doctor = new Doctor();
		management = new Management();
   
}
public void actionPerformed(ActionEvent ae)
		{
            
			if(ae.getSource()==logbtn)
			{
				String userphn=phnNofield.getText();
			    String userpass =new String(passfield.getPassword());

                user.setuserphn(userphn);
                user.setuserpass(userpass);
				
				if (userphn.isEmpty()||userpass.isEmpty())
				{
					JOptionPane.showMessageDialog(null ,"Without information how can you LogIn!"); // to popup a dialouge box
				}

				else if(user.UserLogIn(userphn, userpass) == true)
				{
                   

                  
			
			        JOptionPane.showMessageDialog(null,"Valid Account");
			
			        UserDashboard ud=new UserDashboard(user);
		            ud.setVisible(true);
	                this.setVisible(false);
                }
                else if(doctor.DoctorLogIn(userphn, userpass) == true)
                    {
    
                        JOptionPane.showMessageDialog(null,"Valid Account");
    
                        DoctorDashboard ud=new DoctorDashboard(doctor);
                        ud.setVisible(true);
                        this.setVisible(false);
                    }
                    else if(management.ManagementLogIn(userphn, userpass) == true)
{
    

                     JOptionPane.showMessageDialog(null,"Valid Account");

                    ManagementDashboard md=new ManagementDashboard(management);
                    md.setVisible(true);
                     this.setVisible(false);
                     }
                    



                    else
                    {
                        JOptionPane.showMessageDialog(null,"no match");



                    }
		            

                }
            
            else if(ae.getSource()==signUpbtn)
            {
                SignUp s = new SignUp();
                s.setVisible(true);
                this.setVisible(false);

            }

           else if(ae.getSource()==forgetbtn)
           {
               ForgetPassword FP1=new ForgetPassword();
               FP1.setVisible(true);
               this.setVisible(false);
           }

				
 }
                public static void main(String[] args) {
                    LogIn  l = new LogIn();
                    l.setVisible(true);
                }

}
			/*else if(ae.getSource()==backbtn)
			{
				 Homepage h=new Homepage();
				 h.setVisible(true);
				 this.setVisible(false);
			}
			*/