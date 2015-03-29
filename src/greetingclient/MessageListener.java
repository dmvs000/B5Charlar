/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author SHANKAR
 */
public class MessageListener implements Runnable {
    //Constructor Implementation
    Socket ListeningSocket;
    public void MessageListener(Socket sc)
    {
        ListeningSocket=sc;
    }
    public void run()
    {
        System.out.println("Message listener Started");
        try
        {
        while(true)
        {
            OutputStream outToServer = ListeningSocket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            InputStream inFromServer = ListeningSocket.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            String Msg;
            Msg=in.readUTF();
            if(Msg.equals("ReceiveMsg"))
            {
                {
                    System.out.println("Got a message from server");
                    out.writeUTF("ReceiveMsg-Ack");
                    Msg=in.readUTF();
                    JAXBUnmarshall ju=new JAXBUnmarshall();
                    ju.UnMarshall(Msg);
                    System.out.println(ju.getBody());
                }
            }
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
