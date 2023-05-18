/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccesslayer;
import java.util.List;
import transferobjects.CourseDTO;

/**
 * this is Course Dao interface class
 * @author Brijesh4205
 * @since 19/11/2022
 * @version 1.0
 */
public interface CoursesDao {
    
    List<CourseDTO> getAllCourses();
    
    CourseDTO getCourseByCourseCode(String courseCode);
    void addCourse(CourseDTO course);
    void updateCourse(CourseDTO course);
    void deleteCourse(CourseDTO course);
}



