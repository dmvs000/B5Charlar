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
public class RequestRoster {
    public void getRoster(String username,Socket sc)
    {
        
        try
        {
           OutputStream outToServer = sc.getOutputStream();
           DataOutputStream out = new DataOutputStream(outToServer);
           InputStream inFromServer = sc.getInputStream();
           DataInputStream in = new DataInputStream(inFromServer);
           out.writeUTF("requestRoster");
           out.writeUTF(username);
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Error in RequestRoster Class");
        }
        System.out.println("initial roster request done");
    }
    
}
