package in.bm.StudentManagementSystem.Repository;

import in.bm.StudentManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
