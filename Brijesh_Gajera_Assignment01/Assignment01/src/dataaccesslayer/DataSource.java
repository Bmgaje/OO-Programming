/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * this is DataSource class to connect java with database
 * @author Brijesh4205
 * @since 1/11/2022
 * @version 1.0
 */
public class DataSource {
	private Connection connection = null;
	
	public DataSource(){}
/*
 * Only use one connection for this application, prevent memory leaks.
 */
	public Connection createConnection(){
            // added use of Properties and try-with-resources
            Properties props = new Properties();

		try (InputStream in = Files.newInputStream(Paths.get("src/database.properties"));) {
			props.load(in);
		} catch (IOException e) {
			
			e.printStackTrace();
		}// catch()

	    String url = props.getProperty("jdbc.url");
	    String username = props.getProperty("jdbc.username");
	    String password = props.getProperty("jdbc.password");
		try {
			if(connection != null){
				System.out.println("Cannot create new connection, one exists already");
			}
			else{
				connection = DriverManager.getConnection(url, username, password);
			}
		}
		catch(SQLException ex){
                    ex.printStackTrace();
		}
		return connection;
	}
}
