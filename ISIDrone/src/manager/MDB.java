package manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import util.Const;

public class MDB {
	private static Connection connection = null;
	private static String driver="com.mysql.cj.jdbc.Driver", url="jdbc:mysql://127.0.0.1:3306/isidrone?serverTimezone=UTC", username="root", password="abc123..." ;
	public static void connect() throws SQLException {
		try {

			if(Const.isEnvType_production.equals("true")) {
				getDBProperty();
			}
			

			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);



	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void getDBProperty() {
		
		Properties props = new Properties();
		FileInputStream in = null;
		try {
		
			
				in = new FileInputStream(Const.PATH_EnvType_production_dbPropery);
		
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			props.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		 driver = props.getProperty("jdbc.driver");
		 url = props.getProperty("jdbc.url");
		 username = props.getProperty("jdbc.username");
		 password = props.getProperty("jdbc.password");
	}
	
	public static ResultSet execQuery(String query) {
		PreparedStatement ps = getPS(query);
		ResultSet rs = null;
		try {
			if(ps != null) {
				ps.execute();
				rs = ps.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rs;
	}
	
	public static PreparedStatement getPS(String query) {
		PreparedStatement ps = null;
		try { 
			if(connection == null || connection.isClosed())
				connect();
			ps = connection.prepareStatement(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
	public static PreparedStatement getPS(String query, int id) {
		PreparedStatement ps = null;
		try { 
			if(connection == null || connection.isClosed())
				connect();
			if (id == 1)
				ps = connection.prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
	public static PreparedStatement getPS(String query, String column) {
		return getPS(query, new String[]{column});
	}
	
	public static PreparedStatement getPS(String query, String[] columns) {
		PreparedStatement ps = null;
		try { 
			if(connection == null || connection.isClosed())
				connect();
				ps = connection.prepareStatement(query,columns);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
	public static void disconnect() {
		try {
			if(connection != null && !connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connection = null;
		}
	}
}
