package businesslayer;

import dataaccesslayer.StudentDao;
import dataaccesslayer.StudentDaoImpli;
import java.util.List;
import transferobjects.StudentDTO;

/**
 * this is Student Business logic class
 * @author Brijesh4205
 * @since 1/11/2022
 * @version 1.0
 */
public class StudentBusinessLogic {
    private static final int FIRST_NAME_MAX_LENGTH = 45;
    private static final int LAST_NAME_MAX_LENGTH = 45;
    private static final int EMAIL_MAX_LENGTH = 45;
    private static final int PHONE_NUMBER_MAX_LENGTH = 45;
    
   private StudentDao stuDao = null; 
   
   public StudentBusinessLogic(){
      stuDao = new StudentDaoImpli(); 
   }
   
   public List<StudentDTO> getAllStudent(){
       return stuDao.getAllStudents();
   }
   
   public StudentDTO getStudent(Integer StudentID){
    return stuDao.getStudentByStudentID(StudentID);
   }
   
   
   public void addStudent(StudentDTO student) throws ValidationException{
		cleanStudent(student);
		validatStudent(student);
		stuDao.addStudent(student);
	}
	
	public void updateStudent(StudentDTO student) throws ValidationException{
		cleanStudent(student);
		validatStudent(student);
		stuDao.updateStudent(student);
	}
	
	public void deleteStudent(StudentDTO student){
		stuDao.deleteStudent(student);
	}
	
	private void cleanStudent(StudentDTO student){
		if(student.getFirstName() != null){ 
			student.setFirstName(student.getFirstName().trim());
		}
		if(student.getLastName() != null){ 
			student.setLastName(student.getLastName().trim());
		}
                if(student.getEmail() != null){ 
			student.setEmail(student.getEmail().trim());
		}
                if(student.getPhoneNumber() != null){ 
			student.setPhoneNumber(student.getPhoneNumber().trim());
		}
	}
	
	private void validatStudent(StudentDTO student) throws ValidationException{
		validateString(student.getFirstName(), "First Name", FIRST_NAME_MAX_LENGTH, true);
	        validateString(student.getLastName(), "Last Name", LAST_NAME_MAX_LENGTH, true);
	        validateString(student.getEmail(), "Email", EMAIL_MAX_LENGTH, true);
	        validateString(student.getPhoneNumber(), "Phone Number", PHONE_NUMBER_MAX_LENGTH, true);
	
        
        }
	
	private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
	    throws ValidationException{
		if(value == null && isNullAllowed){
			// return; // null permitted, nothing to validate
		}
		else if(value == null && ! isNullAllowed){
		    throw new ValidationException(String.format("%s cannot be null", 
		    		fieldName));
		}
		else if(value.length() == 0){
			throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
					fieldName));
		}
		else if(value.length() > maxLength){
			throw new ValidationException(String.format("%s cannot exceed %d characters", 
					fieldName, maxLength));
		}
	}
           
}
