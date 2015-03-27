/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;



/**
 *
 * @author SHANKAR
 */
public class Register {
    private String FullName;
    private String LastName;
    private String Email;
    private String Password;
    private String DOB;
    private Socket socket;
    JAXBUserRegister jaxbur;
    //JAXB jaxbuserauth;
    
    public void RegisterDetails(String FullName, String LastName, String DOB, String Email, String Password, Socket sc )
    {
        this.FullName=FullName;
        this.LastName=LastName;
        this.Email=Email;
        this.Password=Password;
        this.DOB=DOB;
        socket=sc;
    }
    public void RegisterMe()
    {
        String ServerSays;
        String ToBeSent;
        jaxbur=new JAXBUserRegister();
        //jaxbuserauth= new JAXBUserAuth();
        try
                {
                    OutputStream outToServer = socket.getOutputStream();
                    DataOutputStream out = new DataOutputStream(outToServer);
                    InputStream inFromServer = socket.getInputStream();
                    DataInputStream in = new DataInputStream(inFromServer);
                    System.out.println("Trying to Register");
                    out.writeUTF("register");
                    ServerSays=in.readUTF();
                    if(ServerSays.equals("reg-Ack"))
                                                {
                                                    //Id=in.readUTF();
                                                    ToBeSent=jaxbur.RegisterStanza(FullName, LastName, DOB, Email, Password);
                                                    out.writeUTF(ToBeSent);
                                                    System.out.println("User Reg-Credentials Sent. Waiting for the server to respond");
                                                }
                    if(ServerSays.equals("RegSuccess"))
                                                {
                                                    System.out.println("Registration Successful");
                                                    //return true;
                                                }
                    if(ServerSays.equals("RegFailed"))
                                                {
                                                    System.out.println("Registration Failed");
                                                    out.writeUTF("terminate");
                                                    //return false;
                                                }
                    System.out.println("Register Closed");
                }
                catch(Exception e)
                {
                    System.out.println("Exception has been caught at Register.java Class, Client Side");
                    System.out.println(e);
                }
        
    }
    
}
