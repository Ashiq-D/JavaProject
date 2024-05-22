package Entity;

import GUI.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;  
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class User extends Admin
{
	private File file;
	private BufferedWriter writer;
	private Scanner sc;
    private String doctor;
    private String date;
    private String time;
    private String[][] appointments;
    private int appointmentCount;

	public boolean hasRequest;
	private String reqbloodgroup;
    private String reqcondition;
    private String reqlocation;
    private String reqnumber;


	public User(){}
    public User(String username,String userpass,String userage,String userarea,String userphn)
    {
        super(username,userpass,userage,userarea,userphn);

    }
	public User(String username,String userpass,String userage,String userarea,String userphn,String reuserpass)
    {
        super(username,userpass,userage,userarea,userphn,reuserpass);
    }




    public void addUserAccount() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data/Data.txt", true))) {
            writer.write(getusername() + " " + getuserpass() + " " + getuserage() + " " + getuserarea() + " " + getuserphn() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean UserLogIn(String userphn, String userpass) {
        FileReader fr = null;
        BufferedReader br = null;
        boolean flag = false;
        try {
            file = new File("Data/Data.txt");
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                if (values[4].equals(userphn) && values[1].equals(userpass)) {
                    flag = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
         } 

        return flag;
    }


    // public void showUser(String user)
    // {
    //     FileReader fr = null;
    //     BufferedReader br = null;
    //     boolean flag = false;
    //     try {
    //         file = new File("Data.txt");
    //         fr = new FileReader(file);
    //         br = new BufferedReader(fr);
    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             String[] values = line.split(" ");
    //             if (values[4].equals(user) ) {
    //                 flag = true;
    //                 break;
    //             }
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //      } 


    // }



    public boolean getUser(String userphn,String userpass,String reuserpass)
	{
		boolean flag=false;
		file=new File("Data/Data.txt");
		
		try
		{
		  sc=new Scanner(file);
		  
		  while(sc.hasNextLine())
		  {
			  String line=sc.nextLine();
			  String[] value=line.split("\t");
			  if(value[4].equals(userphn)&&value[1].equals(userpass)&&value[1].equals(reuserpass))
			  {
				  flag=true;
				  break;
			  }
		  }
		  sc.close();
		  
		}
		catch (IOException e) {
            e.printStackTrace();
		}
		return flag;
	}


    public void makeAppointmnet(String doctor, String date, String time)
	{
		this.doctor = doctor;
        this.date =date;
        this.time = time;
        // this.hasRequest = true;
	}


    public String getDoctor()
	{
        return doctor;
    }

    public String getDate()
	{
        return date;
    }

    public String getTime()
	{
        return time;
    }


    

    // private void loadUserData() {
    //     // Load user data from signup.txt and populate the table
    //     try (BufferedReader reader = new BufferedReader(new FileReader("signup.txt"))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             String[] userData = line.split(",");
    //             tableModel.addRow(userData);
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //         JOptionPane.showMessageDialog( "Error reading user data", "Error", JOptionPane.ERROR_MESSAGE);
    //     }
    // }

    // private void saveUserData() {
    //     // Save user data to signup.txt
    //     try (FileWriter writer = new FileWriter("Data/signup.txt")) {
    //         for (int i = 0; i < tableModel.getRowCount(); i++) {
    //             for (int j = 0; j < tableModel.getColumnCount(); j++) {
    //                 writer.write(tableModel.getValueAt(i, j).toString());
    //                 if (j < tableModel.getColumnCount() - 1) {
    //                     writer.write(",");
    //                 }
    //             }
    //             writer.write("\n");
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //         JOptionPane.showMessageDialog(this, "Error saving user data", "Error", JOptionPane.ERROR_MESSAGE);
    //     }
    // // }

    // public void UserDashboard(User u)
    // {


    // }







}