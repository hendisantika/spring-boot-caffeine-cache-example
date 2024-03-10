package id.my.hendisantika.springbootcaffeinecacheexample.repository;

import id.my.hendisantika.springbootcaffeinecacheexample.entity.Student;
import org.springframework.data.repository.ListCrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-caffeine-cache-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/10/24
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public interface StudentRepository extends ListCrudRepository<Student, Long> {
}
