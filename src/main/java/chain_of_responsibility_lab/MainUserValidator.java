package chain_of_responsibility_lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
@Component
public class MainUserValidator {





    @Autowired
    private List<UserValidator> validators;



    @Scheduled(fixedDelay = 1000)
    public void doWork(){
        System.out.println("I' love spring...");
    }


    public List<String> validate(User user) {

       return validators.stream().map(userValidator -> userValidator.validate(user)).collect(Collectors.toList());

    }
}

















