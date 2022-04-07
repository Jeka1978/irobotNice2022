package real_spring;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class SpeakerImpl2 implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println("kdgasjkhdgs "+message);
    }
}
