package Entity;

import GUI.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.crypto.Data;

public abstract class Admin

{
    private String username;
private String userpass;
private String userage;
private String userarea;
private String userphn;
private String reuserpass;
private String doctor;
private String date;
private String time;


    public Admin()
    {

    }
public Admin(String userphn,String userpass)
    {
this.userphn=userphn;
this.userpass=userpass;

    }

    public Admin(String username,String userpass,String userage,String userarea,String userphn)
    {
        this.username=username;
this.userpass=userpass;
this.userage=userage;
this.userarea=userarea;
this.userphn=userphn;
    }

    public Admin(String userphn,String userpass,String reuserpass){
        this.userpass=userpass;
        this.userphn=userphn;
        this.reuserpass=reuserpass;
        
    

    }
    public Admin(String username,String userpass,String userage,String userarea,String userphn,String reuserpass){
		this.username=username;
		this.userpass=userpass;
		this.userage=userage;
		this.userarea=userarea;
		this.userphn=userphn;
		this.reuserpass=reuserpass;
	}

    // public appoinmentTime(String doctor, String date, String time )
    // {
    //     this.doctor = doctor;
    //     this.date = date;
    //     this.time = time;

    // }



    public void setusername(String username)
{
this.username=username;
}
public void setuserpass(String userpass)
{
this.userpass=userpass;
}
public void setuserage(String userage)
{
this.userage=userage;
}
public void setuserarea(String userarea)
{
this.userarea=userarea;
}
public void setuserphn(String userphn)
{
this.userphn=userphn;
}
public void setreuserpass(String reuserpass)
	{
		this.reuserpass=reuserpass;
	}
    // public void setDoctor(String doctor)
    // {
    // this.doctor=doctor;
    // }
    // public void setDate(String date)
    // {
    // this.date=date;
    // }
    // public void setTime(String time)
    // {
    // this.time=time;
    // }



public String getusername()
{
return username;
}
public String getuserpass()
{
return userpass;
}
public String getuserage()
{
return userage;
}
public String getuserarea()
{
return userarea;
}
public String getuserphn()
{
return userphn;
}
public String getreuserpass()
{
    return reuserpass;
}
// public String getDoctor()
// {
//     return doctor;
// }
// public String getDate()
// {
//     return date;
// }
// public String getTime()
// {
//     return time;
// }




   
}