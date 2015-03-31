/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingclient;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author SHANKAR
 */
public class ReceiveInboundMessages implements Runnable
{
    private String Message;
    private Socket socket;
    private sampleinterface si;
    public void ReceiveInboundMessagesSocket(Socket sc,sampleinterface si)
    {
        this.si=si;
        socket=sc;
        System.out.println("Listening Socket Successfulyy Received RIM");
    }
    public void run()
    {
        String ServerSays;
        String ClientSays;
        System.out.println("Thread Successfully Started.");
        try
        {
            OutputStream outMsg = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outMsg);
            InputStream inFrom = socket.getInputStream();
            DataInputStream in = new DataInputStream(inFrom);
            String Body,From;
            JAXBUnmarshall jum=new JAXBUnmarshall();
            while(true)
            {
                System.out.println("Inside RIM");
                ServerSays=in.readUTF();
                System.out.println("RIM "+ServerSays);
                if(ServerSays.equals("ReceiveMsg"))
                {
                    ServerSays=in.readUTF();
                    System.out.println("Received Msg : "+ServerSays);
                    jum.UnMarshall(ServerSays);
                    Body=jum.getBody();
                    From=jum.getFrom();
                    System.out.println("Body is :"+Body);
                    System.out.println("From is :"+From);
                    si.popitup(Body, From);
                    System.out.println("Message Shown Successfully");
                }
            }
            
        }
        catch(Exception e)
                {
                    System.out.println("Exception caught at SendOutBoundMessage.java Client Side");
                    System.out.println(e);
                }
        System.out.println("ReceiveInboundMessages Closed");
    }
}
