package DBs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBFunc {
//  change url dependently
   static String url ="jdbc:mysql://127.0.0.1:3306/groupassignment";
   static String user ="root";
   static String password ="Jokerstom123";

   static Connection conn = null;
   static Statement stmt = null;
	public static void execDB(String sql) {
    	try {
    	      Class.forName("com.mysql.cj.jdbc.Driver");
    	      conn = DriverManager.getConnection(url,user,password);
    	      stmt = conn.createStatement();
    	      stmt.execute(sql);
    	      

    	  } catch (SQLException e1) {
    	      e1.printStackTrace();
    	  }catch (ClassNotFoundException e) {
    	      e.printStackTrace();
    	  }
    }
    public static boolean verifyDB(String name) {
    	try {
    	      Class.forName("com.mysql.cj.jdbc.Driver");
    	      conn = DriverManager.getConnection(url,user,password);
    	      stmt = conn.createStatement();
    	      ResultSet rs = stmt.executeQuery("Select * from product");
    	      while (rs.next()) {
    	    	  if (rs.getString("productName").equals(name)){
    	    		  return false;
    	    	  }
    	      }  	  
    	  } catch (SQLException e1) {
    	      e1.printStackTrace();
    	  }catch (ClassNotFoundException e) {
    	      e.printStackTrace();
    	  }
		return true;
    }
}
