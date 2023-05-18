
import java.util.List;

import businesslayer.StudentBusinessLogic;
import businesslayer.ValidationException;
import transferobjects.StudentDTO;

/**
 * this is Student Simple class which has Main void method 
 * Main void method contain All method data for adding updating deleting 
 * In this Class we can create methods for add update and delete
 * @author Brijesh4205
 * @since 1/11/2022
 * @version 1.0
 */
public class Simple {
public void Main(){
		try{
			StudentBusinessLogic logic = new StudentBusinessLogic();
			List<StudentDTO> list = null;
			StudentDTO student = null;
			
			System.out.println("Printing Authors");
			list = logic.getAllStudent();
			printStudent(list);
			
			System.out.println("Printing One Author");
			student = logic.getStudent(9016001);
			printStudent(student);
			System.out.println();
			
			System.out.println("Inserting One Author");
			student = new StudentDTO();
                        student.setStudentID(9016200);
			student.setFirstName("FirstTestAdd");
			student.setLastName("LastTestAdd");
                        student.setEmail("EmailTestAdd");
                        student.setPhoneNumber("PhoneNumberTestAdd");
			logic.addStudent(student);
			list = logic.getAllStudent();
			printStudent(list);
			
			System.out.println("Updating last author");
			Integer updatePrimaryKey = list.get(list.size() - 1).getStudentID();
			student = new StudentDTO();
                        student.setStudentID(9016001);
			student.setStudentID(updatePrimaryKey);
			student.setFirstName("FirstTestUpdate");
			student.setLastName("LastTestUpdate");
                        student.setEmail("EmailTestUpdate");
                        student.setPhoneNumber("PhoneNumberTestupdate");
			logic.updateStudent(student);
			list = logic.getAllStudent();
			printStudent(list);
			
			System.out.println("Deleting last author");
			student = list.get(list.size() - 1);
                        student.setStudentID(9016200);
			logic.deleteStudent(student);
			list = logic.getAllStudent();
			printStudent(list);	
		}
		catch(ValidationException e){
			System.err.println(e.getMessage());
		}

	}
	
	private static void printStudent(StudentDTO student){
	    	String output = String.format("%s, %s, %s, %s, %s",
	    			student.getStudentID().toString(),
	    			student.getFirstName(),
	    			student.getLastName(),
                                student.getEmail(),
                                student.getPhoneNumber());
	    	System.out.println(output);
	}
	
	private static void printStudent(List<StudentDTO> students){
	    for(StudentDTO student : students){
	    	printStudent(student);
	    }
	    System.out.println();
	}
	
    

}
