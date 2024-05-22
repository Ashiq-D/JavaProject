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

// import javax.xml.crypto.Data;

public class Doctor extends Admin
{
    //private int totalAppoinment;
    private File file;
    private BufferedWriter writer;
    private Scanner sc;
    private String doctor;
    private String date;
    private String time;
    private String[][] appointments;
    private int appointmentCount;


    public Doctor(){}
    public Doctor(String userpass,String userphn)
    {
        super(userpass,userphn);

    }


    public boolean DoctorLogIn(String userphn, String userpass) {
        FileReader fr = null;
        BufferedReader br = null;
        boolean flag = false;
        try {
            file = new File("Doctor.txt");
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
}