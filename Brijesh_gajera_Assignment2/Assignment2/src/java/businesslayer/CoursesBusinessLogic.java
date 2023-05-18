/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;
import dataaccesslayer.CoursesDao;
import dataaccesslayer.CoursesDaoImpl;
import java.util.List;
import transferobjects.CourseDTO;
import transferobjects.CredentialsDTO;

/**
 * this is Course Business logic class
 * @author Brijesh4205
 * @since 1/11/2022
 * @version 1.0
 */
public class CoursesBusinessLogic {
   private static final int COURSE_NAME_MAX_LENGTH = 30;
	private static final int COURSE_DESCRIPTION_MAX_LENGTH = 30;
        
	private CoursesDao coursesDao = null;
	private CredentialsDTO creds;
        
	public CoursesBusinessLogic(CredentialsDTO creds){
		coursesDao = new CoursesDaoImpl(creds);
	}
	
	public List<CourseDTO> getAllCourses(){
		return coursesDao.getAllCourses();
	}
	
	public CourseDTO getCourse(String courseCode){
		return coursesDao.getCourseByCourseCode(courseCode);
	}
	
	public void addCourse(CourseDTO course) throws ValidationException{
		cleanCourse(course);
		validateCourse(course);
		coursesDao.addCourse(course);
	}
	
	public void updateAuthor(CourseDTO course) throws ValidationException{
		cleanCourse(course);
		validateCourse(course);
		coursesDao.updateCourse(course);
	}
	
	public void deleteCourse(CourseDTO course){
		coursesDao.deleteCourse(course);
	}
	
	private void cleanCourse(CourseDTO course){
		if(course.getCourseName() != null){ 
			course.setCourseName(course.getCourseName().trim());
		}
		if(course.getCourseDescription() != null){ 
			course.setCourseDescription(course.getCourseDescription().trim());
		}
	}
	
	private void validateCourse(CourseDTO course) throws ValidationException{
		validateString(course.getCourseName(), "Course Name", COURSE_NAME_MAX_LENGTH, true);
		validateString(course.getCourseDescription(), "Course Description", COURSE_DESCRIPTION_MAX_LENGTH, true);
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
   

