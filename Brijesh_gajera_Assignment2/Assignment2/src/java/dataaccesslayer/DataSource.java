/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import transferobjects.CredentialsDTO;

/**
 * this is DataSource class to connect java with database
 * @author Brijesh4205
 * @since 19/11/2022
 * @version 1.0
 */
public class DataSource {
    
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/tutoring?useSSL=false&allowPublicKeyRetrieval=true";
    private String username;
    private String password;
    
    public DataSource(CredentialsDTO creds){
        username = creds.getUsername();
        password = creds.getPassword();
    }
    
    public Connection createConnection(){
        try{
            if(connection != null){
                System.err.println("Cannot create new connection, one exists already");
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

