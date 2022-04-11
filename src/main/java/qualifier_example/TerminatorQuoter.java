package qualifier_example;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Film
public class TerminatorQuoter implements Quoter {
    @Override
    public void sayQuote() {
        System.out.println("I'll not be back");
    }
}
