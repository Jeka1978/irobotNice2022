package my_spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.FileOutputStream;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;


    @SneakyThrows
    public void abc() {
        new FileOutputStream("");

    }
}







