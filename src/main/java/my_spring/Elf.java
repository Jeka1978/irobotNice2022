package my_spring;

import lombok.Data;

/**
 * @author Evgeny Borisov
 */
@Data
public class Elf {
    @InjectRandomInt(min = 10, max = 15)
    private int power;

    @InjectRandomInt(min = 50,max =67)
    private int speed;


    @InjectRandomInt(min=200,max = 10000)
    private int age;


}
