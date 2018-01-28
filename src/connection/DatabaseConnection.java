package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private String url;
	private String userName;
	private String password;
	private Connection connection;
	private String tableName;
	
	public DatabaseConnection(String url,String userName,String password) {
		
		try {
			setUrl(url);
			setUserName(userName);
			setPassword(password);
			Class.forName("com.mysql.jdbc.Driver");
			setConnection();
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		
	}
	

	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public Connection getConnection() {
		return connection;
	}

	private void setConnection() {
		try {
			this.connection=DriverManager.getConnection(getUrl(), getUserName(), getPassword());
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void closeConnection() {
		try {
			getConnection().close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
