
package dataaccesslayer;

import java.util.List;
import transferobjects.StudentDTO;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * this is Student  Dao Implimation class
 * In this Class we can create methods for add update and delete
 * @author Brijesh4205
 * @since 1/11/2022
 * @version 1.0
 */
public class StudentDaoImpli implements StudentDao {

    @Override
    public List<StudentDTO> getAllStudents() {
      Connection connection = null;   
      PreparedStatement preste = null;
      ResultSet results = null;
      ArrayList<StudentDTO> students = null;
      try{
           DataSource ds = new DataSource();
           connection = ds.createConnection();
           preste = connection.prepareStatement("SELECT * FROM student ORDER BY StudentID");
           results = preste.executeQuery();
           students = new ArrayList<StudentDTO>();
           
           while(results.next()){
           StudentDTO student = new StudentDTO(); 
           student.setStudentID(results.getInt("StudentID"));
           student.setFirstName(results.getString("FirstName"));
           student.setLastName(results.getString("LastName"));
           student.setEmail(results.getString("Email"));
           student.setPhoneNumber(results.getString("PhoneNumber"));
           students.add(student);
           }
      }
      catch(SQLException e){
			e.printStackTrace();
    }
      	finally{
			try{ if(results != null){ results.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(preste != null){ preste.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(connection != null){ connection.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return students;
    }

    @Override
    public StudentDTO getStudentByStudentID(Integer StudentID) {
      Connection connection = null;   
      PreparedStatement preste = null;
      ResultSet results = null; 
      StudentDTO student = null;
      try{
            DataSource ds = new DataSource();
           connection = ds.createConnection();
           preste = connection.prepareStatement("SELECT * FROM student WHERE StudentID = ?");
			preste.setInt(1,StudentID );
			
           results = preste.executeQuery();
           
           while(results.next()){
           student = new StudentDTO(); 
           student.setStudentID(results.getInt("StudentID"));
           student.setFirstName(results.getString("FirstName"));
           student.setLastName(results.getString("LastName"));
           student.setEmail(results.getString("Email"));
           student.setPhoneNumber(results.getString("PhoneNumber"));
      }
      
      }catch(SQLException e){
			e.printStackTrace();
    }
      	finally{
			try{ if(results != null){ results.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(preste != null){ preste.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(connection != null){ connection.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return student;
    }

    @Override
    public void addStudent(StudentDTO student) {
           Connection connection = null;   
           PreparedStatement preste = null;
           try{
           DataSource ds = new DataSource();
           connection = ds.createConnection();
           preste = connection.prepareStatement("INSERT INTO STUDENT  (StudentID, FirstName, LastName, Email, PhoneNumber)" + "VALUES(?, ?, ?, ?, ?)");
                        preste.setInt(1, student.getStudentID());
			preste.setString(2, student.getFirstName());
			preste.setString(3, student.getLastName());
                        preste.setString(4, student.getEmail());
                        preste.setString(5, student.getPhoneNumber());
                
			preste.executeUpdate();
           }
           catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(preste != null){ preste.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(connection != null){ connection.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
    }

    @Override
    public void updateStudent(StudentDTO student) {
           Connection connection = null;   
           PreparedStatement preste = null;
           try{
           DataSource ds = new DataSource();
           connection = ds.createConnection();
           preste = connection.prepareStatement("UPDATE Student Set FirstName = ? ," + " LastName = ? , " + " Email = ? ," + " PhoneNumber = ?, WHERE StudentID = ? "  );
                        preste.setString(1, student.getFirstName());
			preste.setString(2, student.getLastName());
                        preste.setString(3, student.getEmail());
                        preste.setString(4, student.getPhoneNumber());
                        preste.setInt(5, student.getStudentID());
			
                        preste.executeUpdate();
           }
           catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(preste != null){ preste.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(connection != null){ connection.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
  
    }

    @Override
    public void deleteStudent(StudentDTO student) {
     Connection connection = null;   
           PreparedStatement preste = null;
           try{
           DataSource ds = new DataSource();
           connection = ds.createConnection();
           preste = connection.prepareStatement("DELETE FROM student WHERE StudentID = ? "  );
                       
                        preste.setInt(1, student.getStudentID());
			
                        preste.executeUpdate();
           }
           catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(preste != null){ preste.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(connection != null){ connection.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
   }
    
}
