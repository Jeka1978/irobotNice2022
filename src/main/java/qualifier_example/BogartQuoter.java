package qualifier_example;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Film
@Book
public class BogartQuoter implements Quoter {
    @Override
    public void sayQuote() {
        System.out.println("I don't give a damn");
    }
}
