package Registation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Viewservlet")
public class Viewservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
     response.setContentType("text/html");  
     PrintWriter out=response.getWriter();  
     out.println("<a href='registration.html'>Add New Employee</a>");  
     out.println("<h1>User view all List</h1>");  
       
     List<reg> list=regsave.getAllreg();  
       
     out.print("<table border='1' width='100%'");  
     out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Contact</th><th>Regstration no</th><th>Delete</th></tr>");  
     for(reg e:list){  
      out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getContact()+"</td><td>"+e.getRegno()+"</td><td><a href='Deleteuser12?id="+e.getId()+"'>delete</a></td></tr>");  
     }  
     out.print("</table>");  
       
     out.close();  
 }  

}
