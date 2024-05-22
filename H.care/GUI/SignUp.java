package GUI;
import Entity.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUp extends JFrame implements ActionListener
{

   //JPanel=a GUI component that functions as a container to hold other components
        JPanel panel1,panel2;

        JLabel intro, name, pass, age, area, phn, pic;
	    JTextField namefield, agefield, areafield, phnfield;
        JPasswordField passfield;
        JButton backbtn, sign;

		ImageIcon img = new ImageIcon("Image/H.care.png");
		ImageIcon image=new ImageIcon("Image/logo.png");
        ImageIcon img2 = new ImageIcon("Image/Backbtn.png");

        Color color =new Color(25,119,212,255);
		Font myfont1=new Font ("Arial", Font.BOLD,35);
		Font myfont2=new Font ("Arial", Font.BOLD,20);


		

		public SignUp (){

        super("H.Care");
  
		this.setSize(1000, 600);
        this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);


        panel1 = new JPanel();
        panel1.setBounds(0, 0, 400, 600);
        panel1.setLayout(new BorderLayout());
        pic = new JLabel(img);
        panel1.add(pic, BorderLayout.CENTER);


        panel2=new JPanel();
        panel2.setBackground(color);
        panel2.setBounds(400, 0, 600, 600);
        panel2.setLayout(null);


        backbtn = new JButton(img2);
        backbtn.setBounds( 500,10, 25, 25);
		backbtn.setContentAreaFilled(false);
        backbtn.setBorderPainted(false);
        panel2.add(backbtn);
       
    

        intro=new JLabel("Create a free account now");
		intro.setBounds(50,30,500,50);
		intro.setFont(myfont1);
		intro.setForeground(Color.WHITE);
		panel2.add(intro);

		name=new JLabel("Name:");
		name.setBounds(50,100,100,50);
		name.setFont(myfont2);
		name.setForeground(Color.WHITE);
		panel2.add(name);
		
		namefield=new JTextField();
		namefield.setBounds(160,100,300,50);
		namefield.setFont(myfont2);
		panel2.add(namefield);
		
		pass=new JLabel("Password:");
		pass.setBounds(50,160,100,50);
		pass.setFont(myfont2);
		pass.setForeground(Color.WHITE);
		panel2.add(pass);
		
		passfield=new JPasswordField();
		passfield.setBounds(160,160,300,50);
		passfield.setFont(myfont2);
		panel2.add(passfield);
		
		age=new JLabel("Age:");
		age.setBounds(50,220,100,50);
		age.setFont(myfont2);
		age.setForeground(Color.WHITE);
		panel2.add(age);
		
		agefield=new JTextField();
		agefield.setBounds(160,220,300,50);
		agefield.setFont(myfont2);
		panel2.add(agefield);
		
		area=new JLabel("Area:");
		area.setBounds(50,280,100,50);
		area.setFont(myfont2);
		area.setForeground(Color.WHITE);
		panel2.add(area);
		
		areafield=new JTextField();
	    areafield.setBounds(160,280,300,50);
		areafield.setFont(myfont2);
		panel2.add(areafield);
		
		phn=new JLabel("Mobile:");
		phn.setBounds(50,340,100,50);
		phn.setFont(myfont2);
		phn.setForeground(Color.WHITE);
		panel2.add(phn);
		
		phnfield=new JTextField();
		phnfield.setBounds(160,340,300,50);
		phnfield.setFont(myfont2);
		panel2.add(phnfield);
		

		
		sign=new JButton("Sign-Up");
		sign.setBounds(350,420,150,50);
		sign.setFont(myfont2);
		sign.addActionListener(this);
		panel2.add(sign);

		this.add(panel1);
        this.add(panel2);
        this.setIconImage(image.getImage());
		this.setVisible(true);
		}

		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==sign)
			{
				String username = namefield.getText();
			    String userpass = passfield.getText();
				String userage=agefield.getText();
				String userarea=areafield.getText();
				String userphn=phnfield.getText();
				if (username.isEmpty()||userpass.isEmpty()||userage.isEmpty()||userarea.isEmpty()||userphn.isEmpty())
				{
					JOptionPane.showMessageDialog(null ,"Without information fill how can you signUp!"); // to popup a dialouge box
				}
				else
				{

				User ua=new User(username,userpass,userage,userarea,userphn);
				ua.addUserAccount();
				
				JOptionPane.showMessageDialog(null,"Sucessfully Registered");
				
				namefield.setText("");
				passfield.setText("");
				agefield.setText("");
				areafield.setText("");
				phnfield.setText("");
				
			    LogIn L1=new LogIn();
		        L1.setVisible(true);
			    this.setVisible(false);
			    }


			}
			/*else if(ae.getSource()==backbtn)
			{
				 Homepage h=new Homepage();
				 h.setVisible(true);
				 this.setVisible(false);
			}
			*/
		}
		public static void main(String[] args) {
			SignUp s = new SignUp();
			s.setVisible(true);
		}
    }