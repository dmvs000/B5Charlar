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
public class Authenticate {
    private Socket socket;
    JAXBConvert jaxb;
    JAXBUserAuth jaxbuserauth;
    public void Authenticate(Socket sc)
    {
        socket=sc;
    }
    public boolean AuthenticateCredentials(String username,String password, Socket sc)
            {
                //System.out.println("Trying to authenticate");
                String ServerSays;
                String Id;
                String ToBeSent;
                jaxb=new JAXBConvert();
                jaxbuserauth= new JAXBUserAuth();
                socket=sc;
                try
                {
                    OutputStream outToServer = socket.getOutputStream();
                    DataOutputStream out = new DataOutputStream(outToServer);
                    InputStream inFromServer = socket.getInputStream();
                    DataInputStream in = new DataInputStream(inFromServer);
                    System.out.println("Trying to authenticate");
                    out.writeUTF("authenticate");
                    while(true)
                    {
                    ServerSays=in.readUTF();
                    if(ServerSays.equals("Credentials - 063"))
                                                {
                                                    Id=in.readUTF();
                                                    ToBeSent=jaxbuserauth.UserAuthStanza(username, password, "shankar@B5Charlar.com/PC", "B5Charlar.com", Id);
                                                    out.writeUTF(ToBeSent);
                                                    System.out.println("User Credentials Sent. Waiting for the server to respond");
                                                }
                    if(ServerSays.equals("AuthSuccess"))
                                                {
                                                    System.out.println("UserName and Password are Valid.");
                                                    return true;
                                                }
                    if(ServerSays.equals("FA"))
                                                {
                                                    System.out.println("Username and Password are Not Valid");
                                                    out.writeUTF("terminate");
                                                    return false;
                                                }
                    System.out.println("Authenticate Closed");
                }
                }
                catch(Exception e)
                {
                    System.out.println("Exception has been caught at Authenticate.java Class, Client Side");
                    System.out.println(e);
                }
                
                return false;
            }
}
