package qualifier_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Component
public class TalkingRobot {


    @Autowired
    @Book
    private List<Quoter> quoters;


    @PostConstruct
    public void talk(){
        quoters.forEach(Quoter::sayQuote);
    }
}
