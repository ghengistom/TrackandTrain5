package com.track.beat;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.track.beat.service.SuccessService;
import com.track.beat.service.LoginService;
import com.track.beat.LoginServlet;

//@WebServlet("/create")
public class createExerciseServlet extends HttpServlet {
	
	private final Map<Integer, String> products = new Hashtable<>();       
    
    public createExerciseServlet() {
       this.products.put(1, "Sets");
       this.products.put(2, "Reps");
     
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		
		String action = request.getParameter("action");
		
		if(action == null)
		{
			action = "browse";
		}
		switch(action)
		{
		case "addToCart":
			this.addToCart(request, response);
			break;
		case "emptyCart":
			this.emptyCart(request, response);
			break;
		case "viewCart":
			this.viewCart(request, response);
		case "browse":
			this.browse(request, response);
			break;
			
		}
	}


	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException
	{
		int productId;
        try
        {
            productId = Integer.parseInt(request.getParameter("productId"));
        }
        catch(Exception e)
        {
            response.sendRedirect("create");
            return;
        }

        HttpSession session = request.getSession();
        if(session.getAttribute("cart") == null)
            session.setAttribute("cart", new Hashtable<Integer, Integer>());

        @SuppressWarnings("unchecked")
        Map<Integer, Integer> cart =
                (Map<Integer, Integer>)session.getAttribute("cart");
        if(!cart.containsKey(productId))
            cart.put(productId, 0);
        cart.put(productId, cart.get(productId) + 1);

        response.sendRedirect("create?action=viewCart");
	}
	
	private void emptyCart(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		request.getSession().removeAttribute("cart");
		response.sendRedirect("create?action=viewCart");
		
	}
	
	private void viewCart(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		request.setAttribute("products", this.products);
		request.getRequestDispatcher("/WEB-INF/jsp/viewCart.jsp").forward(request, response);
	}
	
	private void browse(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		request.setAttribute("products", this.products);
		request.getRequestDispatcher("/WEB-INF/jsp/browse.jsp").forward(request, response);
	}
	
	
}

