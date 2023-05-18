
package transferobjects;
/**
 * This is Student DTO class
 * In this class we can declare variables
 * @author Brijesh4205
 * @since 1/11/2022
 * @version 1.0
 */
public class StudentDTO {
    private Integer studentID;
    private String firstName;
    private String lastName;
    private String Email;
    private String phoneNumber;

    public StudentDTO() {
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
     public Integer getStudentID(){
    	return studentID;
    }
    public void setStudentID(Integer studentID){
    	this.studentID = studentID;
    }
    
    public String getFirstName(){
    	return firstName;
    }
    public void setFirstName(String firstName){
    	this.firstName = firstName;
    }
    
    public String getLastName(){
    	return lastName;
    }
    public void setLastName(String lastName){
    	this.lastName = lastName;
    }
}
