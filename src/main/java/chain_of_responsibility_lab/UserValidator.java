package chain_of_responsibility_lab;

/**
 * @author Evgeny Borisov
 */
public interface UserValidator {
    String validate(User user);
}
