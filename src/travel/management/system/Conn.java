package travel.management.system;


import java.sql.*;

/*public class Conn 
{
    Connection c;                                                  //creating connection Interface object
    Statement s;
        
    public Conn()
    { 
        
        try                                                        //using try-catch, we need to handle exceptions as we are using external data
        {
            Class.forName("com.mysql.jdbc.Driver");                //registering mysql driver
            
            c = DriverManager.getConnection("jdbc:mysql:///tms","root@localhost","1508");                  
            //providing the details of the database like api,database used,portnumber,database name,username and password.
            
            s = c.createStatement();                                //creating statement using objct of connection and statement class
            
        }catch(Exception e)
        {
            
        }
    }
}*/
import java.sql.*;  

import java.sql.Connection;

import java.sql.Statement;

import java.sql.Statement;

import java.sql.Statement;

public class Conn
{
    Connection c;
    Statement s;
    Object onn;
    public Conn()
    {  
        try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            System.out.println("Driver Loaded");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3307/tms", "username", "password"); 
            System.out.println("Connection Established");
            s = c.createStatement();  
            
           
        }catch(Exception e)
        { 
            System.out.println(e);
        }  
    }  

    class conn {

        public conn() {
        }
    }
}  
