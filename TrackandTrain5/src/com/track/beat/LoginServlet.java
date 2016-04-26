package com.track.beat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.track.beat.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	String action = request.getParameter("action");
    	if(action == null)
    	{
    		action = "login";
    	}
    	switch(action)
    	{
    	case "login":
    		this.showLogin(request, response);
    		break;
    	}
 	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		
		if(action == null)
		{
			action = "login";
		}
		switch(action)
		{
			case "login":
			default:
				this.showLogin(request,response);
				break;			
		}
	}
	
	private void showLogin(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException
	{
		String userId, password;
		HttpSession session =  request.getSession();
		//this is how pull data from JSP
		userId = request.getParameter("userId");
		password = request.getParameter("password");
		
	
		
		LoginService loginservice = new LoginService();
		boolean result = loginservice.authenticate(userId, password);
		
		if (result)
		{
			session.setAttribute(userId, password);
			//absolute linking versus relative link ("/create" vs "create")
			response.sendRedirect("success");
			//request.setAttribute("products", );
			//request.getRequestDispatcher("/WEB-INF/jsp/browse.jsp").forward(request, response);
			return;
		}
		else
		{
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}
		
	}

}
