package com.track.beat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.track.beat.service.SuccessService;
import com.track.beat.service.LoginService;
import com.track.beat.LoginServlet;

public class successServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public successServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	String action = request.getParameter("action");
    	
    	if(action == null)
    	{
    		action = "create";
    	}
    	switch (action)
    	{
    	case "create":
    		this.showCreate(request, response);
    		default:
    			this.showCreate(request,response);
    		
    	}
    	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String action = request.getParameter("action");
    	
		
    	if(action == null)
    	{
    		action = "create";
    	}
    	switch (action)
    	{
    	case "create":
    		this.showCreate(request, response);
    		default:
    			this.showCreate(request,response);
    		
    	}
	
		
	}
	
	private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		request.getRequestDispatcher("/WEB-INF/jsp/loginsuccess.jsp").forward(request, response);
	}

}
