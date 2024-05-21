package Registation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class regsave{

public static Connection getConnection(){  
    Connection con=null;  
    try{  
        Class.forName("com.mysql.cj.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdata","root","Niharika2001");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  
public static int save(reg e){  
    int status=0;  
    try{  
        Connection con=regsave.getConnection();  
        PreparedStatement ps=con.prepareStatement(  
                     "insert into user12(name,email,contact,regno) values (?,?,?,?)");  
        ps.setString(1,e.getName());  
        ps.setString(2,e.getEmail());  
        ps.setString(3,e.getContact());  
        ps.setString(4,e.getRegno());  
          
        status=ps.executeUpdate();  
          
        con.close();  
    }catch(Exception ex){ex.printStackTrace();}  
      
    return status;  
}  
public static int update(reg e){  
    int status=0;  
    try{  
        Connection con=regsave.getConnection();  
        PreparedStatement ps=con.prepareStatement(  
                     "update user12 set name=?,email=?,contact=?,regno=? where id=?");  
        ps.setString(1,e.getName());  
        ps.setString(2,e.getEmail());  
        ps.setString(3,e.getContact());  
        ps.setString(4,e.getRegno());  
        ps.setInt(5,e.getId());  
          
        status=ps.executeUpdate();  
          
        con.close();  
    }catch(Exception ex){ex.printStackTrace();}  
      
    return status;  
}  
public static int delete(int id){  
    int status=0;  
    try{  
        Connection con=regsave.getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from  user12 where id=?");  
        ps.setInt(1,id);  
        status=ps.executeUpdate();  
          
        con.close();  
    }catch(Exception e){e.printStackTrace();}  
      
    return status;  
}  
public static reg getregById(int id){  
    reg e=new reg();  
      
    try{  
        Connection con=regsave.getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from  user12 where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        if(rs.next()){  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            e.setEmail(rs.getString(3));  
            e.setContact(rs.getString(4));  
            e.setRegno(rs.getString(5));  
        }  
        con.close();  
    }catch(Exception ex){ex.printStackTrace();}  
      
    return e;  
}  
public static List<reg> getAllreg(){  
    List<reg> list=new ArrayList<reg>();  
      
    try{  
        Connection con=regsave.getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from user12");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            reg e=new reg();  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            e.setEmail(rs.getString(3));
            e.setContact(rs.getString(4));  
            e.setRegno(rs.getString(5));
              
            list.add(e);  
        }  
        con.close();  
    }catch(Exception e){e.printStackTrace();}  
      
    return list;  
}  
}