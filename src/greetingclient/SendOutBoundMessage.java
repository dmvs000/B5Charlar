/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingclient;

import java.net.Socket;

/**
 *
 * @author SHANKAR
 */
public class SendOutBoundMessage implements Runnable
{
    private String Message;
    private Socket socket;
    public void SendOutBoundMessge(Socket sc,Message msg)
    {
        socket=sc;
        System.out.println("Scoket Passed to Inbound Message Receive Client");
        
    }
    public void run()
    {
        System.out.println("Successfully Started the Inbound Messages Receiving Thread");
        try
        {
            
        }
        catch(Exception e)
                {
                    System.out.println("Exception caught at SendOutBoundMessage.java Client Side");
                    System.out.println(e);
                }
    }
}
