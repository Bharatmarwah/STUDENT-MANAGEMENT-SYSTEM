package in.bm.StudentManagementSystem.Service;

import in.bm.StudentManagementSystem.Entity.Student;
import in.bm.StudentManagementSystem.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceImp {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student insert(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> fetchAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student remove(long studentId, String firstName, String secondName) {
        Student std = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (std.getFirstName().equals(firstName) && std.getSecondName().equals(secondName)) {
            studentRepo.delete(std);
            return std;
        } else {
            throw new RuntimeException("Student name mismatch. Cannot delete");
        }
    }

    @Override
    public Student update(Long id, Student student) {
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for update"));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setSecondName(student.getSecondName());
        existingStudent.setMotherName(student.getMotherName());
        existingStudent.setFatherName(student.getFatherName());
        existingStudent.setSex(student.getSex());

        if (student.getBirthdate() != null) existingStudent.setBirthdate(student.getBirthdate());
        if (student.getPhone() != null) existingStudent.setPhone(student.getPhone());
        if (student.getAddress() != null) existingStudent.setAddress(student.getAddress());

        return studentRepo.save(existingStudent);
    }

    @Override
    public Optional<Student> findById(long id) {
        return studentRepo.findById(id);
    }
}
