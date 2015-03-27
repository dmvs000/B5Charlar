// File Name GreetingClient.java
package greetingclient;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class GreetingClient implements Runnable
{
   private String Action="";
   private String guname="";
   private String gpass="";
   private Socket socketJustCreated;
   public void GreetingClientAction(String action)
   {
       Action=action;
   }
   public void GreetingClientAction(String action, String username, String password)
   {
       System.out.println("In GreetingClientAction");
       Action=action;
       guname=username;
       gpass=password;
       System.out.println(Action+guname+gpass);
   }
   public Socket getMySocket()
   {
       return socketJustCreated;
   }
   public void run()
   {
      
      String serverName = "localhost";
	   String ServerSays;
           String Id="";
      
      JAXBConvert jaxb=new JAXBConvert();
      JAXBUserAuth jaxbuserauth= new JAXBUserAuth();
      int port = 5000;
      String ToBeSent;
      try
      {
         System.out.println("Connecting to... " + serverName + " on port... " + port);
         Socket clientSocket = new Socket(serverName, port);
         System.out.println("Just connected to " + clientSocket.getRemoteSocketAddress() + "on port :" + clientSocket.getPort() );
         System.out.println("Don't terminate this thread. Thread with high priority");
         System.out.println("Storing the Sockets.");
         socketJustCreated=clientSocket;
					//  while(true)
					//    {
					//	OutputStream outToServer = clientSocket.getOutputStream();
					//	DataOutputStream out = new DataOutputStream(outToServer);
                                        //       InputStream inFromServer = clientSocket.getInputStream();
					//	DataInputStream in = new DataInputStream(inFromServer);
                                                //System.out.println("Trying to authenticate");
                                               /* if(Action.equals("Login"))
                                                {
                                                    System.out.println("Trying to authenticate");
                                                //ToBeSent=jaxb.MessageStanza("dmvs000@gmail.com", "vivek@gmail.com", "Sony Vaio");
                                                //ToBeSent=jaxbuserauth.UserAuthStanza(username, password, "shankar@B5Charlar.com", "B5Charlar.com");
                                                out.writeUTF("authenticate");
                                                //ServerSays=in.readUTF();
                                                Action="";
                                                }
                                                ServerSays=in.readUTF();
                                                if(ServerSays.equals("Credentials - 063"))
                                                {
                                                    Id=in.readUTF();
                                                    ToBeSent=jaxbuserauth.UserAuthStanza(guname, gpass, "shankar@B5Charlar.com", "B5Charlar.com", Id);
                                                    out.writeUTF(ToBeSent);
                                                    System.out.println("User Credentials Sent. Waiting for the server to respond");
                                                }
                                                if(ServerSays.equals("AuthSuccess"))
                                                {
                                                    System.out.println("UserName and Password are Valid.");
                                                    clientSocket.close();
                                                }
                                                if(ServerSays.equals("FA"))
                                                {
                                                    System.out.println("Username and Password are Not Valid");
                                                    out.writeUTF("terminate");
                                                    clientSocket.close();
                                                }
                                                if(ServerSays.equals("MsgSend-Ack"))
                                                {
                                                    System.out.println("Message Sending Acknowledgement");
                                                    ToBeSent=jaxb.MessageStanza("dmvs000@gmail.com", "vivek@gmail.com", "Sony Vaio", Id);
                                                }
                                                if(Action.equals("Login"))
                                                {
                                                    System.out.println("Trying to authenticate");
                                                //ToBeSent=jaxb.MessageStanza("dmvs000@gmail.com", "vivek@gmail.com", "Sony Vaio");
                                                //ToBeSent=jaxbuserauth.UserAuthStanza(username, password, "shankar@B5Charlar.com", "B5Charlar.com");
                                                out.writeUTF("authenticate");
                                                //ServerSays=in.readUTF();
                                                Action="";
                                                }
                                                System.out.println(Action);
						//Scanner inp = new Scanner(System.in);
						//System.out.println("Enter a message");
						//s = inp.nextLine();
                                                //out.writeUTF(ToBeSent);
                                                //System.out.println("");
                                                //out.writeUTF("Message from " + client.getLocalSocketAddress() + s);
						
						//System.out.println("Server says " + in.readUTF());
                                                
                                                //System.out.println(ServerSays);
                                                //clientSocket.close();*/
                                           // 
         System.out.println("Socket Created and withheld. Greeting Client Closed");
      }catch(IOException e)
      {
         System.out.println("Exception has been caused. Please check GreetingClient Class.");
         e.printStackTrace();
      }
   }
}