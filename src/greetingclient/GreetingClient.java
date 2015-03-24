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
	   String ServerSays,Id;
      String username="shankar";
      String password="redhat";
      JAXBConvert jaxb=new JAXBConvert();
      JAXBUserAuth jaxbuserauth= new JAXBUserAuth();
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
                                                InputStream inFromServer = clientSocket.getInputStream();
						DataInputStream in = new DataInputStream(inFromServer);
                                                System.out.println("Trying to authenticate");
                                                //ToBeSent=jaxb.MessageStanza("dmvs000@gmail.com", "vivek@gmail.com", "Sony Vaio");
                                                //ToBeSent=jaxbuserauth.UserAuthStanza(username, password, "shankar@B5Charlar.com", "B5Charlar.com");
                                                out.writeUTF("authenticate");
                                                ServerSays=in.readUTF();
                                                if(ServerSays.equals("Credentials - 063"))
                                                {
                                                    Id=in.readUTF();
                                                    ToBeSent=jaxbuserauth.UserAuthStanza(username, password, "shankar@B5Charlar.com", "B5Charlar.com", Id);
                                                    out.writeUTF(ToBeSent);
                                                }
						//Scanner inp = new Scanner(System.in);
						//System.out.println("Enter a message");
						//s = inp.nextLine();
                                                //out.writeUTF(ToBeSent);
                                                System.out.println("");
                                                //out.writeUTF("Message from " + client.getLocalSocketAddress() + s);
						
						//System.out.println("Server says " + in.readUTF());
                                                
                                                System.out.println(ServerSays);
                                                clientSocket.close();
                                            }
      }catch(IOException e)
      {
         System.out.println("Exception has been caused. Please check GreetingClient Class.");
         e.printStackTrace();
      }
   }
}