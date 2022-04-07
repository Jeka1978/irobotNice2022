package my_spring;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {

        NayaService nayaService = ObjectFactory.getInstance().createObject(NayaServiceImpl.class);
        nayaService.helpPeople();
        nayaService.killEnemy();
        System.out.println(nayaService.getClass());


     /*   NiceService niceService = ObjectFactory.getInstance().createObject(NiceService.class);

        niceService.doWork();
        niceService.drinkBeer();*/
   /*     IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
*/

     /*   Elf elf = ObjectFactory.getInstance().createObject(Elf.class);
        System.out.println(elf);*/
    }
}
