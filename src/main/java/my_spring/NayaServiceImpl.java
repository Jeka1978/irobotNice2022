package my_spring;

/**
 * @author Evgeny Borisov
 */
@Profiling
public final class NayaServiceImpl implements NayaService {

    @Override
    public void helpPeople() {
        System.out.println("Helping...");
    }

    @Override
    public void killEnemy() {
        System.out.println("killed");
    }
}
