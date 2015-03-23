// File Name GreetingClient.java
package greetingclient;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class GreetingClient
{
   public static void main(String [] args)
   {
      String serverName = "localhost";
	   String s;
      String username="dmvs000@b5charlar.com";
      JAXBConvert jaxb=new JAXBConvert();
      int port = 5000;
      String ToBeSent;
      try
      {
         System.out.println("Connecting to... " + serverName + " on port... " + port);
         Socket clientSocket = new Socket(serverName, port);
         System.out.println("Just connected to " + clientSocket.getRemoteSocketAddress() + "on port :" + clientSocket.getPort() );
					  while(true)
					    {
						OutputStream outToServer = clientSocket.getOutputStream();
						DataOutputStream out = new DataOutputStream(outToServer);
                                                ToBeSent=jaxb.MessageStanza("dmvs000@gmail.com", "vivek@gmail.com", "Sony Vaio");
                                                System.out.println(ToBeSent);
						//Scanner inp = new Scanner(System.in);
						//System.out.println("Enter a message");
						//s = inp.nextLine();
                  out.writeUTF(ToBeSent);
                  System.out.println("");
                  //out.writeUTF("Message from " + client.getLocalSocketAddress() + s);
						InputStream inFromServer = clientSocket.getInputStream();
						DataInputStream in = new DataInputStream(inFromServer);
						//System.out.println("Server says " + in.readUTF());
                  String ServerSays=in.readUTF();
                  System.out.println(ServerSays);
                  if(ServerSays.equals("<stream>"))
                  {
                     System.out.println("Received <stream> from server.");
                     System.out.println("Sending the initiating entity header to the server.");
                     System.out.println("Initiating Header Sent. Waiting for the server to respond");

                  }
                  else
                  {
                     System.out.println("The connection has been terminated by the server");
                     break;
                  }

						}
         //client.close();
      }catch(IOException e)
      {
         System.out.println("Exception has been caused. Please check GreetingClient Class.");
         e.printStackTrace();
      }
   }
}