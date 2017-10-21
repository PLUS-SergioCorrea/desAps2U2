package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.LocationDOM;
import model.Location;



/**
 * Servlet implementation class LocationController
 */
@WebServlet("/LocationController")
public class LocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Location location;
	private List<Location> locations;
	private LocationDOM locationDOM;
	private List<String> ids = new ArrayList<String>();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationController() {
        super();
        // TODO Auto-generated constructor stub
        location = new Location();
        locations = new ArrayList<Location>();
        locationDOM = new LocationDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
			
			location.setCreDate(request.getParameter("creDate"));
			location.setModDate(request.getParameter("modDate"));
			location.setUsername(request.getParameter("username"));
		
			
			try {
				
				location.setIteration(Integer.parseInt(request.getParameter("iteration")));
			}catch(NumberFormatException e) {
				location.setIteration(0);
				
				
			}
			
			if(location.getId()=="") {
				int id = 1;
				String newId= "KOT"+String.format("%05d", 1);
				location.setId(newId);
				
				if (locations.size()>0) {
					ids.clear();
					for (Location p: locations) {
						ids.add(p.getId());
					}
					for (int i=0; i<= ids.size(); i++){
						newId= "KOT"+ String.format("%05d", i+1);
						
						if (! ids.contains(newId)) {
						location.setId(newId);
						break;
						}
					}
				}
				locationDOM.add(location);
			}else {
				locationDOM.update(location);
			}
			locations = locationDOM.getLocations();
			request.setAttribute("locations", locations);
			request.getRequestDispatcher("location_list.jsp").forward(request, response);
			
			
			
		}else if (request.getParameter("btn_new")!=null) {
			location = new Location();
			request.getRequestDispatcher("location_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				String id = request.getParameter("id");
				location = locationDOM.findById(id);
				System.out.println("edit");
				
			}catch (Exception e) {
				e.printStackTrace();
				location = new Location();
			}
			System.out.println(location);
			request.setAttribute("location", location);
			
			request.getRequestDispatcher("location_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			String id = request.getParameter("id");
			locationDOM.delete(id);
			locations = locationDOM.getLocations();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("locations", locations);
			request.getRequestDispatcher("location_list.jsp").forward(request, response);
		}else {
			locations = locationDOM.getLocations();
			request.setAttribute("locations", locations);
			request.getRequestDispatcher("location_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
