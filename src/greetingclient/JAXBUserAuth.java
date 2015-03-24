/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetingclient;

/**
 *
 * @author SHANKAR
 */
import java.io.File;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

 
public class JAXBUserAuth {
    
	public String UserAuthStanza(String username, String password, String from, String to, String Id) {
 
	  UserAuth ua = new UserAuth();
	  ua.setTo(to);
	  ua.setFrom(from);
	  ua.setUsername(username);
          ua.setPassword(password);
          ua.setId(Id);
        
        java.io.StringWriter sw= new StringWriter();
 
	  try {
 
		//File file = new File("C:\\Users\\SHANKAR\\Desktop\\Test\\xml.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(UserAuth.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		//jaxbMarshaller.marshal(message, file);
		jaxbMarshaller.marshal(ua, System.out);
                
                jaxbMarshaller.marshal(ua, sw);
                
                
 
	      } 
          catch (JAXBException e) {
		e.printStackTrace();
                    }
          return sw.toString();
        
        }}
          
        
        
        


        

