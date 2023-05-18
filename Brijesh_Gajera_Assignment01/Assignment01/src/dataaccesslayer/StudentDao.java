package dataaccesslayer;

import java.util.List;
import transferobjects.StudentDTO;

/**
 * this is Student Dao interface class
 * @author Brijesh4205
 * @since 1/11/2022
 * @version 1.0
 */
public interface StudentDao {
    List<StudentDTO> getAllStudents();
    
    StudentDTO getStudentByStudentID(Integer StudentID);
    void addStudent(StudentDTO student);
    void updateStudent(StudentDTO student);
    void deleteStudent(StudentDTO student);


    
}
