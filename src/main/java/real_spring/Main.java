package real_spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IRobotConfig.class);
        System.out.println();
        context.getBean(IRobot.class).cleanRoom();
        Map<String, Object> map = context.getBeansWithAnnotation(Service.class);
    }
}
