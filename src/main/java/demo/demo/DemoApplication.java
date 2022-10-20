package demo.demo;

import demo.demo.student.IStudentRepository;
import demo.demo.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

import static java.time.Month.DECEMBER;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(IStudentRepository studentRepository) {
        return args -> {
            studentRepository.save(new Student(null,"Samuel","adeosunsamsamuel@gmail.com",LocalDate.of(1992,DECEMBER,1),null));
            studentRepository.save(new Student(null,"Taiwo","primeart@gmail.com",LocalDate.of(1987, DECEMBER,5),null));

        };
    }
}
