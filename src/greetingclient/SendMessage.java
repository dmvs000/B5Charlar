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
public class SendMessage {
    private Socket socket;
    JAXBConvert jaxb;
    JAXBUserAuth jaxbuserauth;
    private String username;
    private String sessionId;
    private String to;
    private String from;
    private String lang;
    private String message;
    public void SendMessageDetails(Socket sc, String username, String to, String from, String lang)
    {
        jaxb=new JAXBConvert();
        jaxbuserauth= new JAXBUserAuth();
        socket=sc;
        this.username=username;
        this.from=from;
        this.to=to;
        this.lang=lang;
        
    }
    public boolean SendMessage(String Message)
            {
                //System.out.println("Trying to authenticate");
                String ServerSays;
                String Id;
                String ToBeSent;
                jaxb=new JAXBConvert();
                jaxbuserauth= new JAXBUserAuth();
                try
                {
                    OutputStream outToServer = socket.getOutputStream();
                    DataOutputStream out = new DataOutputStream(outToServer);
                    InputStream inFromServer = socket.getInputStream();
                    DataInputStream in = new DataInputStream(inFromServer);
                    System.out.println("Trying to Send Message");
                    out.writeUTF("OutMessage");
                    ServerSays=in.readUTF();
                    if(ServerSays.equals("MsgSend-Ack"))
                                                {
                                                    //Id=in.readUTF();
                                                    ToBeSent=jaxb.MessageStanza(to, from, message, sessionId);
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
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
                return false;
            }
}
