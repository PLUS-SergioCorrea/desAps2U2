package dom;



import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Location;


public class LocationDOM {
	private String pathFile = "C:\\Users\\Sergio\\eclipse-workspace\\SACSUnit22\\src\\data\\locations.xml";
	public void add(Location data) {
		
		try {
			
				Document document = DOMHelper.getDocument(pathFile);
				Element locations = document.getDocumentElement();
				
				//CREATE player TAG
				
				Element location = document.createElement("location");
				//CREAR ID TAGG
				
				Element id = document.createElement("id");
				id.appendChild(document.createTextNode(data.getId()));
				location.appendChild(id);
				// create type tag
				
				Element iteration = document.createElement("iteration");
				iteration.appendChild(document.createTextNode(String.valueOf(data.getIteration())));
				
				location.appendChild(iteration);
				
					// create category tag
				
				Element creDate = document.createElement("creDate");
				creDate.appendChild(document.createTextNode(data.getCreDate()));
				location.appendChild(creDate);
				
				//create height tag
				
				Element modDate = document.createElement("modDate");
				modDate.appendChild(document.createTextNode(data.getModDate()));
				location.appendChild(modDate);
				
				Element username = document.createElement("username");
				username.appendChild(document.createTextNode(data.getUsername()));
				location.appendChild(username);
				
				locations.appendChild(location);
				
				// Write to file
				DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			
				System.out.println(e.getMessage());
			
		}
	}
	
	public void delete (String id ) {
		
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("location");
			for (int i =0; i< nodelist.getLength(); i++) {
				
				Element location = (Element)nodelist.item(i);
				if (location.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					location.getParentNode().removeChild(location);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update (Location data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("location");
			for (int i =0; i< nodelist.getLength(); i++) {
				Element location = (Element)nodelist.item(i);
				if (location.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					location.getElementsByTagName("iteration").item(0).setTextContent(String.valueOf(data.getIteration()));
					location.getElementsByTagName("creDate").item(0).setTextContent(data.getCreDate());
					location.getElementsByTagName("modDate").item(0).setTextContent(String.valueOf(data.getModDate()));
					location.getElementsByTagName("username").item(0).setTextContent(String.valueOf(data.getUsername()));
					
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Location findById(String id) {
		Location location = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("location");
			for(int i=0; i<nodelist.getLength(); i++) {
				Element s = (Element)nodelist.item(i);
				if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					location = new Location();
					location.setId(id);
					location.setIteration(Integer.parseInt(s.getElementsByTagName("iteration").item(0).getTextContent()));
					location.setCreDate(s.getElementsByTagName("creDate").item(0).getTextContent());
					location.setModDate(s.getElementsByTagName("modDate").item(0).getTextContent());
					location.setUsername(s.getElementsByTagName("username").item(0).getTextContent());
					
				}
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}
	
	public  List<Location> getLocations(){
		
		List<Location> locations = new ArrayList<Location>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("location");
		for (int i =0; i<nodelist.getLength(); i++) {
			
			Element s = (Element)nodelist.item(i);
			Location location = new Location();
			location.setId(s.getElementsByTagName("id").item(0).getTextContent());
			location.setIteration(Integer.parseInt(s.getElementsByTagName("iteration").item(0).getTextContent()));
			location.setCreDate(s.getElementsByTagName("creDate").item(0).getTextContent());
			location.setModDate(s.getElementsByTagName("modDate").item(0).getTextContent());
			location.setUsername(s.getElementsByTagName("username").item(0).getTextContent());
			
			locations.add(location);
			
		}
		return locations;
	}
}
