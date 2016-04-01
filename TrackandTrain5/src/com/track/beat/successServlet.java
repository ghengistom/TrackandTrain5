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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userId = null;
				
		SuccessService success_service = new SuccessService();
		userId = (String)success_service.getUserId(userId);
		
		
		userId = (String)success_service.getUserId(userId);
		System.out.println("userId + "+userId);
		
		
		response.sendRedirect("loginsuccess.jsp");
		
	
		
	}

}
