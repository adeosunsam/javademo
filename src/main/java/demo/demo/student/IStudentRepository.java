package demo.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository <Student, Integer> {
    Optional<Student> findStudentByEmail(String email);
}
