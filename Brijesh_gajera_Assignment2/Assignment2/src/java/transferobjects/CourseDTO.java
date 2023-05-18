/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transferobjects;
/**
 * This is Course DTO class
 * In this class we can declare variables
 * @author Brijesh4205
 * @since 19/11/2022
 * @version 1.0
 */
public class CourseDTO {
    
    private String courseCode;
    private String courseName;
    private String courseDescription;
    
    public String getCourseCode(){
        return courseCode;
    }
    
    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }
    
    public String getCourseName(){
        return courseName;
    }
    
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    
    public String getCourseDescription(){
        return courseDescription;
    }
    
    public void setCourseDescription(String courseDescription){
        this.courseDescription = courseDescription;
    }
            
    
}
