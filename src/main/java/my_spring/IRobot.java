package my_spring;

/**
 * @author Evgeny Borisov
 */

// S - single responsibility
// O
// L
// I
// D


public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void cleanRoom() {
        speaker.speak("I started");

        cleaner.clean();

        speaker.speak("I finished");
    }
}




