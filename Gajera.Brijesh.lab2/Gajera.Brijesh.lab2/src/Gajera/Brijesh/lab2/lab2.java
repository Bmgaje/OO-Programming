package Gajera.Brijesh.lab2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/** In this java class we are conecting database with java.
 *
 * @author Brijesh4205
 * @version 1.0
 * @since 15/10/2022
 */
public class lab2 {
     public static void main(String[] args) throws SQLException {
       
        Properties prop = new Properties();
        try( InputStream in = Files.newInputStream(Paths.get("src/lab2.properties"));
        ){
            prop.load(in);
        }// try end
        catch(IOException e){
        e.printStackTrace();
        } //end catch 
         
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        
         
        
        String url= prop.getProperty("jdbc.url");
        String Username = prop.getProperty("jdbc.username");
        String Passwd = prop.getProperty("jdbc.password");
        
        try{
          connection = DriverManager.getConnection(url,Username,Passwd);
          
          statement = connection.createStatement();
          
          results = statement.executeQuery("SELECT AwardID,Name,City FROM recipients ");
          
          ResultSetMetaData metaData = results.getMetaData();
          int numberOfColum = metaData.getColumnCount();
          
            System.out.println("recipients Table from ontario : ");
            
            //for loop for the colume name
            
            for (int i=1; i<=numberOfColum; i++)        
                System.out.printf("%-8s\t",metaData.getColumnClassName(i) );
                
            System.out.println();
            
            while(results.next()){
           for(int i=1; i<=numberOfColum; i++){
                System.out.printf("%-8s\t",results.getObject(i) );
           }   System.out.println();
           }
            System.out.println("\n Recipients Table - Column Attributes:");
             
            for (int i = 1; i <= numberOfColum; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.printf("%-8s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-8s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }
            System.out.println();
            

        } // try end    
      catch ( SQLException sqlException )                                
      {                                                                  
         sqlException.printStackTrace();
      } //end catch                                                    

     }
}
