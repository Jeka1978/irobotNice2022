package my_spring;

import lombok.Setter;

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


    public IRobot(Speaker speaker, Cleaner cleaner) {
        this.speaker = speaker;
        this.cleaner = cleaner;
    }

    public void cleanRoom() {
        speaker.speak("I started");

        cleaner.clean();

        speaker.speak("I finished");
    }
}




