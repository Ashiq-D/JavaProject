package GUI;
import Entity.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Appoinment extends JFrame implements  ActionListener
{
        
        

   //JPanel=a GUI component that functions as a container to hold other components
    
    
        JPanel panel1, panel2, panel3;
        JComboBox comboBox;
        JLabel name, intro1, intro2, date, time, pic;
	    JTextField datefield, timefield;
        JButton sign,homebtn, appointMentbtn, logOutbtn, bookbtn,deletebtn;
        ImageIcon image, image1;

        Color color1 =new Color(63,105,179,255);
		Color color2 =new Color(20,132,202,255);
        Color color3=new Color(117,154,186,255);




        Font myfont1=new Font ("Calibri", Font.BOLD,17);
		Font myfont2=new Font ("Calibri", Font.BOLD,22);
		Font myfont3=new Font ("Calibri", Font.BOLD,30);
	    // img1 = new ImageIcon("Image/logo.png");

        UserDashboard userDashboard;
        String selectedDoctor;
        String selectedDate;
        String selectedTime;


        User user;


        public Appoinment(UserDashboard userDashboard)
        {

        super("Appointment Frame");


        this.setSize(1000, 600);
		this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        panel1=new JPanel();
        panel1.setBounds(0, 0, 300, 100);
        panel1.setBackground(color2);
        // panel1.setPreferredSize(new Dimension(300,100));
        // panel1.setLayout(new FlowLayout());
		panel1.setLayout(null);
       
        panel2=new JPanel();
        panel2.setBounds(0, 70, 300, 500);
        panel2.setBackground(color1);
        panel2.setPreferredSize(new Dimension(300,500));
        panel2.setLayout(new FlowLayout());




        panel3=new JPanel();
        panel3.setBounds(300, 0, 700, 600);
        panel3.setBackground(color3);
        panel3.setLayout(null);

        // panel3.setPreferredSize(new Dimension(600,1000));
        // panel3.setLayout(new FlowLayout());
       


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
        homebtn.addActionListener(this);
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

        

        intro1=new JLabel("APPOINTMENT");
		intro1.setBounds(250,30,500,50);
		intro1.setFont(myfont3);
		intro1.setForeground(Color.WHITE);
        panel3.setLayout(null);
		panel3.add(intro1);

        intro2=new JLabel("CHOOSE YOUR DATE AND TIME");
		intro2.setBounds(160,70,500,50);
		intro2.setFont(myfont3);
		intro2.setForeground(Color.WHITE);
        panel2.setLayout(null);
		panel3.add(intro2);
		
		date=new JLabel("Date*");
		date.setBounds(150,140,100,50);
		date.setFont(myfont2);
		date.setForeground(Color.WHITE);
		panel3.add(date);
		
		datefield=new JTextField();
		datefield.setBounds(150,180,400,50);
		datefield.setFont(myfont2);
        datefield.setForeground(Color.BLACK);
		panel3.add(datefield);
		
		time=new JLabel("Time*");
		time.setBounds(150,240,100,50);
		time.setFont(myfont2);
		time.setForeground(Color.WHITE);
		panel3.add(time);

  


         String[] times={"10-11am","11-12am","12-1pm","1-2pm","3-4pm","4-5pm","5-6pm","6-7pm"};
         comboBox =new JComboBox(times);
         comboBox.setBounds(150,280,400,50);
         comboBox.setFont(myfont2);
         comboBox.setForeground(Color.BLACK);
       
        comboBox.addActionListener(this);
         panel3.add(comboBox);
        

        // comboBox.addActionListener(this);

        bookbtn = new JButton();
        bookbtn.setText("BOOK");
        // bookbtn.setContentAreaFilled(false);
        // bookbtn.setBorderPainted(false);
        bookbtn.setForeground(Color.BLACK);
        bookbtn.setFont(myfont1);
        bookbtn.setBounds(260, 350, 200, 50);
        // btn1.add(pic1);

        panel3.add(bookbtn);

        deletebtn = new JButton("DELETE");
        deletebtn .setBounds(520, 450, 170, 30);
        deletebtn .setFont(myfont1);
        deletebtn .setContentAreaFilled(false);
        deletebtn .setBorderPainted(false);
        deletebtn .setForeground(Color.WHITE);
        deletebtn .addActionListener(this);
        panel3.add(deletebtn );
        
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
     {
      /*  if (ae.getSource() == comboBox){
          comboBox.getSelectedItem();
      System.out.println(comboBox.getSelectedItem());
        
    }
	*/
    if(ae.getSource() == logOutbtn) {
        // 
        HomePage h1 = new HomePage();
        h1.setVisible(true);
        this.setVisible(false);



    }
    else if (ae.getSource() == homebtn) {
        // 
        UserDashboard ua = new UserDashboard(user);
        ua.setVisible(true);
        this.setVisible(false);
    }
    else if (ae.getSource() == deletebtn) {
			
        UserDashboard ua = new UserDashboard(user);
        ua.setVisible(true);
        this.setVisible(false);

			}
    else if (ae.getSource() == bookbtn) {
                
        JOptionPane.showMessageDialog(null ,"Booked Successfully"); 

                UserDashboard ua = new UserDashboard(user);
                ua.setVisible(true);
                this.setVisible(false);
            }
    }

 }


// public static void main(String[] args) 
// {
//     UserDashboard userDashboard = new UserDashboard();
//     new Appoinment(userDashboard);
       

//     // }
// }
