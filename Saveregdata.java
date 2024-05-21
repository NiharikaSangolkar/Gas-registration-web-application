package Registation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Saveregdata")
public class Saveregdata extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String name=request.getParameter("name");  
	          
	        String email=request.getParameter("email"); 
	        String contact =request.getParameter("contact");
	        String regno=request.getParameter("regno");  
	          
	        reg e=new reg();  
	        e.setName(name);  
	        e.setEmail(email);
	        e.setContact(contact);
	        e.setRegno(regno);  
	          
	        int status=regsave.save(e);  
	        if(status>0){  
	            out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("registration.html").include(request, response);  
	           
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
	    }  
	  
}

