package DBconnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.* ;
import java.util.Properties;

public class DBConnection {
	private Properties properties; 	// file containing the connection properties
	private String jdbcDriver; 		// String containing the driver Class name
	private String url; 			// Address to the database
	private Connection conn;
		
	public DBConnection(String propertiesFilename) throws IOException,
	ClassNotFoundException, SQLException {
		File f = new File(propertiesFilename);
		properties = new Properties();
		properties.load(new FileInputStream(f));
		jdbcDriver = properties.getProperty("jdbcDriver");
		url = properties.getProperty("url");
	}
		
	public DBConnection(Properties properties) throws ClassNotFoundException,
	SQLException {
		this.properties = properties;
		jdbcDriver = properties.getProperty("jdbcDriver");
		url = properties.getProperty("url");
		
	}
		
	public void initialize() throws ClassNotFoundException, SQLException {
		Class.forName(jdbcDriver);
		Properties info = new Properties();
		
		/* info is a different Properties object from the "properties" one.
		 "info" is used by the Driver Manager while properties is used by our
		program*/
		info.setProperty("user", this.properties.getProperty("user"));
		info.setProperty("password", this.properties.getProperty("password"));
		conn = DriverManager.getConnection(url, info);
	}
		
	public ResultSet makeSingleQuery(String sql) throws SQLException {
		Statement st = conn.createStatement();
		return st.executeQuery(sql);
	}
		
	public void makeSingleUpdate(String sql) throws SQLException {
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
	}
	
	public ResultSet makeSingleUpdate(String sql, boolean dummy) throws SQLException {
		Statement st = conn.createStatement();
		st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = st.getGeneratedKeys(); 
		if(rs.next()){
			return rs;
		}
		return null;
	}
		
	public PreparedStatement preparedStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	}

	public void close() throws SQLException {
		conn.close();
	}
}
