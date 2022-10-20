package demo.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService _studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        _studentService = studentService;
    }

    @GetMapping
    public List<Student> GetStudent() {
        return _studentService.GetStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        try{
            _studentService.addNewStudent(student);
        }catch (IllegalStateException e){
            throw new IllegalStateException(e.getMessage());
        }
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        _studentService.deleteStudent(studentId);
    }
}
