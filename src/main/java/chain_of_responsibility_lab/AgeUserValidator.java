package chain_of_responsibility_lab;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Order(3)
public class AgeUserValidator implements UserValidator {
    @Override
    public String validate(User user) {
        if (user.getAge() < 0) {
            return "age can't be negative";
        }
        if (user.getAge() > 120) {
            return "age > 120";
        }
        return "";
    }
}
