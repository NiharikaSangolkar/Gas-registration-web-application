package Registation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Editdataview")
public class Editdataview extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        String name=request.getParameter("name");  
	        
	          
	        String email=request.getParameter("email"); 
	        String contact =request.getParameter("contact");
	        String regno=request.getParameter("regno");  
	          
	        reg e=new reg();  
	        e.setName(name);  
	        e.setEmail(email);
	        e.setContact(contact);
	        e.setRegno(regno); 
	          
	        int status=regsave.update(e);  
	        if(status>0){ 
	        	out.println("record updated successfully.");
	            response.sendRedirect("/Servlets/Registation/ViewServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	    }  
	  
}
