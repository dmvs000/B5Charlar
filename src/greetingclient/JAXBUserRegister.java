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

 
public class JAXBUserRegister {
    
	public String RegisterStanza(String fullname, String lastname, String dob, String email, String password) {
 
	  UserRegister ur = new UserRegister();
	  ur.setFullName(fullname);
	  ur.setLastName(lastname);
	  ur.setDOB(dob);
          ur.setPassword(password);
          ur.setEmail(email);
        
        java.io.StringWriter sw= new StringWriter();
 
	  try {
 
		//File file = new File("C:\\Users\\SHANKAR\\Desktop\\Test\\xml.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(UserRegister.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		//jaxbMarshaller.marshal(message, file);
		jaxbMarshaller.marshal(ur, System.out);
                
                jaxbMarshaller.marshal(ur, sw);
                
                
 
	      } 
          catch (JAXBException e) {
		e.printStackTrace();
                System.out.println("Exception has been caused. Please check JAXBUserRegister Class.");
                    }
          return sw.toString();
        
        }}
          
        
        
        


        

