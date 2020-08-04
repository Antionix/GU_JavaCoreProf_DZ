import java.util.Arrays;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        // TODO: 02.08.2020  заменить на логирование
        System.out.println("====== My Homework 06 ======");

        /***************************************
         * Задание 1
         ***************************************/
        System.out.println("*** Задание 1 ***");

        Integer[] arrayInteger1 = new Integer[new Random().nextInt(10) + 3];
        // TODO: 02.08.2020  заменить на логирование
        for (int i = 0; i < arrayInteger1.length; i++) {
            arrayInteger1[i] = new Integer(new Random().nextInt(10));
        }
        System.out.println("[" + arrayInteger1.length + "]:" + Arrays.toString(arrayInteger1));
        try {
            System.out.println(Arrays.toString(Tools.getArrayAfterLast4(arrayInteger1)));
        } catch (RuntimeException e) {
            System.out.println("Array not content number 4");
            e.printStackTrace();
        }


        /***************************************
         * Задание 2
         ***************************************/
        System.out.println("*** Задание 2 ***");

        Integer[] arrayInteger2 = new Integer[new Random().nextInt(10) + 4];
        // TODO: 02.08.2020  заменить на логирование
        for (int i = 0; i < arrayInteger2.length; i++) {
            boolean b = new Random().nextBoolean();
            if (b) {
                arrayInteger2[i] = 4;
            } else {
                arrayInteger2[i] = 1;
            }
        }
        System.out.println("[" + arrayInteger2.length + "]:" + Arrays.toString(arrayInteger2));
        System.out.println( Tools.isContentArray1and4(arrayInteger2));

        arrayInteger2[new Random().nextInt(arrayInteger2.length)] = 5;
        System.out.println("[" + arrayInteger2.length + "]:" + Arrays.toString(arrayInteger2));
        System.out.println( Tools.isContentArray1and4(arrayInteger2));


    }
}
