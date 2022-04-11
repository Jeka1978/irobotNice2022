package qualifier_example;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Book
public class ShakespearQuoter implements Quoter {
    @Override
    public void sayQuote() {
        System.out.println("2 b || ! 2 B");
    }
}
