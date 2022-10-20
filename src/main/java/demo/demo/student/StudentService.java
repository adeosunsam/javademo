package demo.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final IStudentRepository _studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        _studentRepository = studentRepository;
    }

    public List<Student> GetStudent() {
        return _studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = _studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        _studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        boolean exist =_studentRepository.existsById(studentId);
        if (!exist){
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        }
        _studentRepository.deleteById(studentId);
    }
}
