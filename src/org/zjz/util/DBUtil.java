package org.zjz.util;
/**
 * @author liyan
 * 创建数据库的连接
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final static String USERNAME = "hr";
	private final static String PSW = "123";
	private Connection conn = null;
	
	static    //只需要加载一次就好，而且执行的优先级高
	{
		try {
			Class.forName(DRIVER);
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection()
	{
		try {
			conn = DriverManager.getConnection(DB_URL,USERNAME,PSW);
			System.out.println("连接成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public void close()
	{
		if(conn!=null)
			try {
				conn.close();
			} 
		    catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		new DBUtil();
	}
}
