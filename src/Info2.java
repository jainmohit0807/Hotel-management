
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;


public class Info2 
{
	static Connection con() throws SQLException
	{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","rat");
	}
	static String math1()
	{
		String id="";
		for(int i=1;i<=6;i++)
		{
			id+=(int)(Math.random()*9)+1;
			//System.out.println(id);
		}
		return id;
	}
	
}
