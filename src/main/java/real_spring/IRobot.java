package real_spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
@Component
public class IRobot {

    @Autowired
    private Speaker speaker;

    @Autowired
    private Cleaner cleaner;

    @PostConstruct
    public void print() {
        System.out.println(cleaner.getClass());
        System.out.println(speaker.getClass());
    }

    public void cleanRoom() {
        speaker.speak("I started");
        cleaner.clean();
        speaker.speak("I finished");
    }
}
