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
    private Speaker speaker = ObjectFactory.getInstance().createObject(Speaker.class);
    private Cleaner cleaner = ObjectFactory.getInstance().createObject(Cleaner.class);



    public void cleanRoom() {
        speaker.speak("I started");

        cleaner.clean();

        speaker.speak("I finished");
    }
}




