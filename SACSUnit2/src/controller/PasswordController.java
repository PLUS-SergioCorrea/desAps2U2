package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.PasswordDOM;
import model.Password;



/**
 * Servlet implementation class PasswordController
 */
@WebServlet("/PasswordController")
public class PasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Password password;
	private List<Password> passwords;
	private PasswordDOM passwordDOM;
	private List<String> ids = new ArrayList<String>();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordController() {
        super();
        // TODO Auto-generated constructor stub
        password = new Password();
        passwords = new ArrayList<Password>();
        passwordDOM = new PasswordDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
			
			password.setPassword(request.getParameter("password"));
			password.setTimStamp(request.getParameter("timStamp"));
			password.setUsername(request.getParameter("username"));
			password.setUsermail(request.getParameter("usermail"));
		
			if(password.getId()=="") {
				int id = 1;
				String newId= "KOT"+String.format("%05d", 1);
				password.setId(newId);
				
				if (passwords.size()>0) {
					ids.clear();
					for (Password p: passwords) {
						ids.add(p.getId());
					}
					for (int i=0; i<= ids.size(); i++){
						newId= "KOT"+ String.format("%05d", i+1);
						
						if (! ids.contains(newId)) {
						password.setId(newId);
						break;
						}
					}
				}
				passwordDOM.add(password);
			}else {
				passwordDOM.update(password);
			}
			passwords = passwordDOM.getPasswords();
			request.setAttribute("passwords", passwords);
			request.getRequestDispatcher("password_list.jsp").forward(request, response);
			
			
			
		}else if (request.getParameter("btn_new")!=null) {
			password = new Password();
			request.getRequestDispatcher("password_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				String id = request.getParameter("id");
				password = passwordDOM.findById(id);
				System.out.println("edit");
				
			}catch (Exception e) {
				e.printStackTrace();
				password = new Password();
			}
			System.out.println(password);
			request.setAttribute("password", password);
			
			request.getRequestDispatcher("password_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			String id = request.getParameter("id");
			passwordDOM.delete(id);
			passwords = passwordDOM.getPasswords();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("passwords", passwords);
			request.getRequestDispatcher("password_list.jsp").forward(request, response);
		}else {
			passwords = passwordDOM.getPasswords();
			request.setAttribute("passwords", passwords);
			request.getRequestDispatcher("password_list.jsp").forward(request, response);
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

