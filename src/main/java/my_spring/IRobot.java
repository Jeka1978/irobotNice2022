package my_spring;

import lombok.Setter;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */

// S - single responsibility
// O - open close principle
// L
// I
// D


public class IRobot {
    @InjectByType
    private Speaker speaker;

    @InjectByType
    private Cleaner cleaner;

    @PostConstruct
    public void print() {
        System.out.println(cleaner.getClass());
    }

    public void cleanRoom() {
        speaker.speak("I started");
        cleaner.clean();
        speaker.speak("I finished");
    }
}




