package id.my.hendisantika.springbootcaffeinecacheexample.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-caffeine-cache-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/10/24
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(String message) {
        super(message);
    }
}
