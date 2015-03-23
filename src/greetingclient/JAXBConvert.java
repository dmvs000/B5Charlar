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

 
public class JAXBConvert {
    
	public String MessageStanza(String To, String From, String Body) {
 
	  Message message = new Message();
	  message.setTo(To);
	  message.setFrom(From);
	  message.setLang("English");
          message.setBody(Body);
        
        java.io.StringWriter sw= new StringWriter();
 
	  try {
 
		File file = new File("C:\\Users\\SHANKAR\\Desktop\\Test\\xml.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(message, file);
		jaxbMarshaller.marshal(message, System.out);
                
                jaxbMarshaller.marshal(message, sw);
                
                
 
	      } 
          catch (JAXBException e) {
		e.printStackTrace();
                    }
          return sw.toString();
        
        }}
          
        
        
        


        

