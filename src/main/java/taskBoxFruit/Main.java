package taskBoxFruit;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Task 03 =====");
        Random rnd = new Random();

        Orange orange = new Orange();
        System.out.println(orange);

        Apple apple = new Apple();
        System.out.println(apple);

        System.out.println("---------------------------------------");

        Box<Apple> appleBox1 = new Box<>(new Apple());
        Box<Apple> appleBox2 = new Box<>(new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange());

        for (int i = 0; i < rnd.nextInt(500) % appleBox1.getMAX_WEIGHT(); i++) {
            appleBox1.addFruit(new Apple());
        }

        for (int i = 0; i < rnd.nextInt(500) % orangeBox.getMAX_WEIGHT(); i++) {
            orangeBox.addFruit(new Orange());
        }

        System.out.println("appleBox1:"+ appleBox1);
        System.out.println("orangeBox"+orangeBox);

        System.out.println("---------------------------------------");
        appleBox1.dropTo(appleBox2);
        System.out.println("appleBox1:"+ appleBox1);
        System.out.println("appleBox2:"+ appleBox2);


    }
}
