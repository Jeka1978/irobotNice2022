package my_spring;

/**
 * @author Evgeny Borisov
 */

public class NiceServiceImpl implements NiceService {
    @Override
    @Profiling
    public void doWork() {
        System.out.println("Working....");
    }

    @Override

    public void drinkBeer() {
        System.out.println("Leff is the best");
    }
}
