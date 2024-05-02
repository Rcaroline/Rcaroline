package samplePackage;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class OneServer
{
	
  public static void main(String[] args) throws Exception
  {
	  
	  boolean flag=false;
	  OneServer oneServer=new OneServer();
	  do {
	  // Hard coded Login Details
	  String accUserName="admin";
	  String accPassword="1234";
      
      Scanner myObj = new Scanner(System.in);  // Create a Scanner object
      
      System.out.println("Enter username");
      String userName = myObj.nextLine(); 
      
      System.out.println("Enter Password");
      String password = myObj.nextLine();
      
      if(accUserName.equalsIgnoreCase(userName)&& accPassword.equalsIgnoreCase(password)) {
    	  oneServer.chatServer();
    	  flag=true;
    } else {
    	System.out.println("Username/Password is invalid:");
    }   
	  }while(flag=true);
      
  }
  
  
		
  public void chatServer() throws IOException{

	  ServerSocket sersock = new ServerSocket(3000);
  	  System.out.println("Login Success");
  	  System.out.println("************Server Chat************************");
        Socket sock = sersock.accept( );                          
                                // reading from keyboard (keyRead object)
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
  	                      // sending to client (pwrite object)
        OutputStream ostream = sock.getOutputStream(); 
        PrintWriter pwrite = new PrintWriter(ostream, true);

                                // receiving from server ( receiveRead  object)
        InputStream istream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

        
        int i=0;
        String receiveMessage, sendMessage;               
        while(true)
        {
          if((receiveMessage = receiveRead.readLine()) != null)  
          {
             System.out.println(receiveMessage);  
             
          }         
          sendMessage = keyRead.readLine();
          pwrite.println(sendMessage);             
          pwrite.flush();
          
        } 
       
    }
  
}                   