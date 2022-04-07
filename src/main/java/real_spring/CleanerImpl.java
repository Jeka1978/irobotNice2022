package real_spring;

import my_spring.InjectRandomInt;
import my_spring.Profiling;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */


@Profiling
@Service
public class CleanerImpl implements Cleaner {


    @InjectRandomInt(min = 3,max = 7)
    private int repeat;

    @PostConstruct
    public void init() {
        System.out.println("repeat = " + repeat);
    }

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVVVVVvvvvvvvvvvvvvvvvv");
        }
    }





}
