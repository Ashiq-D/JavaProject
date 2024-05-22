package GUI;
import Entity.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HomePage extends JFrame implements ActionListener
{

	
		JPanel panel;
		JLabel intro, pic;
		JButton logbtn, signupbtn;
		ImageIcon img,img1;
		Font  myfont1, myfont2;



        public HomePage()
		{
			super("Home Page");

        this.setSize(1000, 600);
        this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

		    myfont1=new Font ("Arial", Font.BOLD,35);
		    myfont2=new Font ("Arial", Font.BOLD,20);
		    img1 = new ImageIcon("image/logo.png");

		    panel=new JPanel();
			panel.setLayout(null);
            panel.setBounds(0, 0, 1000, 600);


		    intro=new JLabel("Checkup Regularly and Live a Healthy Life");
		    intro.setBounds(50,50,1000,50);
		    intro.setFont(myfont1);
		    panel.add(intro);

		    logbtn=new JButton("Login");//login button er jonno
	       	logbtn.setBounds(200,200,200,50);
	     	logbtn.setFont(myfont2);
		    // logbtn.addMouseListener(this);
		    logbtn.addActionListener(this);
		    panel.add(logbtn);
		
		    signupbtn=new JButton("SignUp");//signin buttoner jonno 
		    signupbtn.setBounds(500,200,200,50);
		    signupbtn.setFont(myfont2);
		    // signupbtn.addMouseListener(this);
		    signupbtn.addActionListener(this);
		    panel.add(signupbtn);

		    img=new ImageIcon("Image/HomePage.jpg");
		    pic=new JLabel(img);
		    pic.setBounds(0,0,1000,600);
		    panel.add(pic);
		    pic.setOpaque(true);
		
			this.add(panel);
			this.setIconImage(img1.getImage());
			this.setVisible(true);

	}
    // public void mouseEntered(MouseEvent me)
	// {
	// 	if(me.getSource()==logbtn)
	// 	{
	// 		logbtn.setBackground(Color.BLUE);
	// 		logbtn.setBackground(Color.WHITE);
	// 	}
	// 	else if(me.getSource()==signupbtn)
	// 	{
	// 		signupbtn.setBackground(Color.BLUE);
	// 		signupbtn.setBackground(Color.WHITE);
	// 	}
	// }
    
	// public void mouseExited(MouseEvent me)
	// {

	// 	if(me.getSource()==logbtn)
	// 	{
	// 		logbtn.setBackground(Color.BLUE);
	// 		logbtn.setBackground(Color.WHITE);
	// 	}
	// 	else if(me.getSource()==signupbtn)
	// 	{
	// 		signupbtn.setBackground(Color.BLUE);
	// 		signupbtn.setBackground(Color.WHITE);
	// 	}
		 

	// }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == signupbtn)
		 {
            this.setVisible(false);
            SignUp s1 = new SignUp();
            s1.setVisible(true);
        }
		else if (ae.getSource() == logbtn)
		 {
            LogIn L1 = new LogIn();
            L1.setVisible(true);
            this.setVisible(false);
         }
    }


	public static void main(String[] args) {

        HomePage h = new HomePage();
    }


}
