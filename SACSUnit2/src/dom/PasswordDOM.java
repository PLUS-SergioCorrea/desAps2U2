package dom;



import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Password;


public class PasswordDOM {
	private String pathFile = "C:\\Users\\Sergio\\eclipse-workspace\\SACSUnit2\\src\\data\\passwords.xml";
	public void add(Password data) {
		
		try {
			
				Document document = DOMHelper.getDocument(pathFile);
				Element passwords = document.getDocumentElement();
				
				//CREATE player TAG
				
				Element password = document.createElement("password");
				//CREAR ID TAGG
				
				Element id = document.createElement("id");
				id.appendChild(document.createTextNode(data.getId()));
				password.appendChild(id);
				//
				
				Element password1 = document.createElement("password1");
				password1.appendChild(document.createTextNode(data.getPassword()));
				
				password.appendChild(password1);
				
					//
				
				Element timStamp = document.createElement("timStamp");
				timStamp.appendChild(document.createTextNode(data.getTimStamp()));
				password.appendChild(timStamp);
				
				//
				Element username = document.createElement("username");
				username.appendChild(document.createTextNode(data.getUsername()));
				password.appendChild(username);
				
				Element usermail = document.createElement("usermail");
				usermail.appendChild(document.createTextNode(data.getUsermail()));
				password.appendChild(usermail);
				
				
				
				passwords.appendChild(password);
				
				// Write to file
				DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			
				System.out.println(e.getMessage());
			
		}
	}
	
	public void delete (String id ) {
		
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("password");
			for (int i =0; i< nodelist.getLength(); i++) {
				
				Element password = (Element)nodelist.item(i);
				if (password.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					password.getParentNode().removeChild(password);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update (Password data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("password");
			for (int i =0; i< nodelist.getLength(); i++) {
				Element password = (Element)nodelist.item(i);
				if (password.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					password.getElementsByTagName("password1").item(0).setTextContent(data.getPassword());
					password.getElementsByTagName("timStamp").item(0).setTextContent(data.getTimStamp());
					password.getElementsByTagName("username").item(0).setTextContent(data.getUsername());
					password.getElementsByTagName("usermail").item(0).setTextContent(data.getUsermail());
					
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Password findById(String id) {
		Password password = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("password");
			for(int i=0; i<nodelist.getLength(); i++) {
				Element s = (Element)nodelist.item(i);
				if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					password = new Password();
					password.setId(id);
					password.setPassword(s.getElementsByTagName("password1").item(0).getTextContent());
					password.setTimStamp(s.getElementsByTagName("timStamp").item(0).getTextContent());
					password.setUsermail(s.getElementsByTagName("usermail").item(0).getTextContent());
					password.setUsername(s.getElementsByTagName("username").item(0).getTextContent());
					
				}
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
	
	public  List<Password> getPasswords(){
		
		List<Password> passwords = new ArrayList<Password>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("password");
		for (int i =0; i<nodelist.getLength(); i++) {
			
			Element s = (Element)nodelist.item(i);
			Password password = new Password();
			password.setId(s.getElementsByTagName("id").item(0).getTextContent());
			password.setPassword(s.getElementsByTagName("password1").item(0).getTextContent());
			password.setTimStamp(s.getElementsByTagName("timStamp").item(0).getTextContent());
			password.setUsermail(s.getElementsByTagName("usermail").item(0).getTextContent());
			password.setUsername(s.getElementsByTagName("username").item(0).getTextContent());
			
			passwords.add(password);
			
		}
		return passwords;
	}
}
