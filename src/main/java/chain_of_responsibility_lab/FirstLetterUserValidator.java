package chain_of_responsibility_lab;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Order(1)
public class FirstLetterUserValidator implements UserValidator {
    @Override
    public String validate(User user) {
        if (user.getName().startsWith("J")) {
            return "J can't be the first letter";
        }
        return "";
    }
}
