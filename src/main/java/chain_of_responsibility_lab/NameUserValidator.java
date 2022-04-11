package chain_of_responsibility_lab;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Order(2)
public class NameUserValidator implements UserValidator {
    @Override
    public String validate(User user) {
        if (user.getName().length() < 5) {
            return "name too short";
        }

        return "";
    }
}
