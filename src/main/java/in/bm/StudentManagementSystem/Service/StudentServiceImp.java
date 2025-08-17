package in.bm.StudentManagementSystem.Service;

import in.bm.StudentManagementSystem.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServiceImp {


    Student insert(Student student);


    List<Student> fetchAll();


    Student remove(long studentId, String firstName, String secondName);


    Student update(Long id, Student student);


    Optional<Student> findById(long id);
}
