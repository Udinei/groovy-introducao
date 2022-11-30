package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        int dog = 11;
        int cat = 3;
        int partA = dog / cat;
        int partB = dog % cat;
        int newDog = partB + partA * cat;
        System.out.print(newDog);
    }



    public void openDrawbridge() throws Exception {  // p1
        try {
            throw new Exception("Circle");
        } catch (Exception e) {
            System.out.print("Opening!");
        } finally {
            System.out.print("Walls");  // p2
        }
    }

    private static void doSomeTihing(){
        doSomeTihingElse();
    }

    private static void doSomeTihingElse() {
         //   throw new Exception();
        float t = 10.0f + 10;

    }
}
