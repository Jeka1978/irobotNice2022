package chain_of_responsibility_lab;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
//@PropertySource("classpath:user.properties")
@EnableScheduling
public class UserConfig {






    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

        User user = new User("Jo", 130);
        MainUserValidator mainUserValidator = context.getBean(MainUserValidator.class);


        List<String> errors = mainUserValidator.validate(user);
        System.out.println(errors);
    }
}
