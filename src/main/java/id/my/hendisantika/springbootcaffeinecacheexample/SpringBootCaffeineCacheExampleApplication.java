package id.my.hendisantika.springbootcaffeinecacheexample;

import id.my.hendisantika.springbootcaffeinecacheexample.entity.Student;
import id.my.hendisantika.springbootcaffeinecacheexample.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootCaffeineCacheExampleApplication implements CommandLineRunner {
    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCaffeineCacheExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = studentService.save(new Student("Itadori Yuji"));

        student = studentService.getById(student.getId()); //Hits the database
        log.info(" " + student);
        student = studentService.getById(student.getId()); //Fetched from cache
        log.info(" " + student);

        try {
            studentService.deleteById(1L);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        student = studentService.getById(student.getId()); //Fetched from cache
        log.info(" " + student);
    }

}
