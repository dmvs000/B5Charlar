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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Message {
 
	String body,lang,to,from;
	int age;
	int id;
 
	public String getBody() {
		return body;
	}
 
	@XmlElement
	public void setBody(String body) {
		this.body = body;
	}
 
	
 
	
 
	public String getTo() {
		return to;
	}
        public String getFrom() {
		return from;
	}
        public String getLang() {
		return lang;
	}
 
	@XmlAttribute
	public void setTo(String to) {
		this.to = to;
	}
        @XmlAttribute
	public void setFrom(String from) {
		this.from = from;
	}
        @XmlAttribute
	public void setLang(String lang) {
		this.lang = lang;
	}
 
}
