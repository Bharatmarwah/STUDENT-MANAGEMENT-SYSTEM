package in.bm.StudentManagementSystem.Service;

import in.bm.StudentManagementSystem.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServiceImp {

    // Insert a new student
    Student insert(Student student);

    // Fetch all students
    List<Student> fetchAll();

    // Remove a student by ID and confirm first & second name
    Student remove(long studentId, String firstName, String secondName);

    // Update a student by ID
    Student update(Long id, Student student);

    // Find a student by ID
    Optional<Student> findById(long id);
}
