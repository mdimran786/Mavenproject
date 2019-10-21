package selenium_mavenProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Mysql {
  @Test
  public void database() throws ClassNotFoundException, SQLException {
	  String dburl = "jdbc:mysql://localhost:3306/student";
	  String username = "root";
	  String password = "Imr@n786";
	  Class.forName("com.mysql.cj.jdbc.Driver"); // mysql driver to connect to db
		Connection Conn = DriverManager.getConnection(dburl,username,password);// establishing connection
				System.out.println("\n\n******Hi! GUYZ.... MY SQL DATABASE CONNECTED SUCCESSFULLY****** \n");
				System.out.println("******The Requested Information Please find below******\n\n");
		Statement st = Conn.createStatement(); // statements to perform actions//connecting to the database
	    ResultSet  rs = st.executeQuery("select *from students order by sid asc"); // statement query
	    	   while(rs.next()){   // looping to print all students information
	    	   System.out.println("   ****************   ");   
	           System.out.println("Student id :"+rs.getString("sid")); // to print sid
	           System.out.println("Student name :"+rs.getString("sname")); // to print sname
	           System.out.println("Student Age :"+rs.getInt("sage")); // tp print sage
	           System.out.println("Student gender :"+rs.getString("sgender")); // to print sgender
	           System.out.println("Student marks :"+rs.getInt("smarks"));  // to print smarks
	       }
	     Conn.close();// to close the database automatically
	  
  }
}
