package Registation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Editdata")
public class Editdata extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	           throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Employee</h1>");  
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	          
	        reg e=regsave.getregById(id);  
	          
	        out.print("<form action='Editdataview' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
	        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
	        out.print("<tr><td>Contact:</td><td><input type='text' name='contact' value='"+e.getContact()+"'/></td></tr>");  
	        out.print("<tr><td>Registration no:</td><td><input type='text' name='regno' value='"+e.getRegno()+"'/></td></tr>");  
	        
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  
	    }  

}
