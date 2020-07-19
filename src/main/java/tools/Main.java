package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static <T> T[] changeArrayElements(T[] array, int ind1, int ind2) {
        T obj;
        obj = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = obj;
        return array;
    }

    public static <T> ArrayList<T> convertArrayToArrayList(T[] array) {
        ArrayList<T> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            res.add(i, array[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        final int MAX = 6;
        System.out.println("=== Task 01 - 02 ===");
        System.out.println("===--- Task 01 ---===");

        Integer[] intArray = new Integer[MAX];
        Random rnd = new Random();
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rnd.nextInt(100);
        }
        System.out.println("before: "+Arrays.toString(intArray));

        int indx1 = rnd.nextInt(intArray.length);
        int indx2 = rnd.nextInt(intArray.length);
        if (indx1 == indx2) {
            indx2 = (indx1 + indx2 + rnd.nextInt(intArray.length % 4)) % intArray.length;
        }
        System.out.println(String.format("change %d to %d", indx1 + 1, indx2 + 1));

        intArray = changeArrayElements(intArray, indx1, indx2);
        System.out.println("after: " + Arrays.toString(intArray));

        String[] strArray = {"one", "two", "tree", "forth", "five"};
        System.out.println("before: "+Arrays.toString(strArray));

        indx1 = rnd.nextInt(strArray.length);
        indx2 = rnd.nextInt(strArray.length);
        if (indx1 == indx2) {
            indx2 = (indx1 + indx2 + rnd.nextInt(strArray.length % 4)) % strArray.length;
        }
        System.out.println(String.format("change %d to %d", indx1 + 1, indx2 + 1));

        strArray = changeArrayElements(strArray, indx1, indx2);
        System.out.println("after: "+Arrays.toString(strArray));

        System.out.println("===--- Task 02 ---===");

        ArrayList<Integer> intAL = convertArrayToArrayList(intArray);
        System.out.println("" + intArray.getClass() + ":" + Arrays.toString(intArray));
        System.out.println("" + intAL.getClass() + ":" + intAL);

        ArrayList<String> strAL = convertArrayToArrayList(strArray);
        System.out.println("" + strArray.getClass() + ":" + Arrays.toString(strArray));
        System.out.println("" + strAL.getClass() + ":" + strAL);
    }
}
