package id.my.hendisantika.springbootcaffeinecacheexample.service;

import id.my.hendisantika.springbootcaffeinecacheexample.entity.Student;
import id.my.hendisantika.springbootcaffeinecacheexample.exception.RecordNotFoundException;
import id.my.hendisantika.springbootcaffeinecacheexample.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-caffeine-cache-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/10/24
 * Time: 16:49
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Cacheable("StudentCache")
    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record not wound with id: " + id));
    }

    @CacheEvict(value = "StudentCache", key = "#id")
    public void deleteById(Long id) {
        //TODO: REMOVE IT. Its for Demo Only.
        if (id == 1) {
            // Simulate a failure scenario where student id is 1 and cannot be deleted.
            throw new RuntimeException("Student cannot be deleted. It has magic ID");
        }
        studentRepository.deleteById(id);
    }

    @CacheEvict(value = "StudentCache", key = "#student.id")
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
