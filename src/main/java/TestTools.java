import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestTools {
    private static ArrayList<Object> listTest;

    public static void start(Class testClass) {
/*
1. Определить какие тесты будут применяться для данного класса
2. Проверить корректность аннотированных методов
3. выполнить запуск методов согласно порядку и приоритетам
4. выдать отчет о тестах
 */
        List<Method> runMethods = new ArrayList<>();
        Method[] testMethods = testClass.getDeclaredMethods();
        int beforeCount = 0;
        int afterCount = 0;

        System.out.println("----------- Start Test -------------");
        System.out.println("----------- " + testClass + " -------------");
//        System.out.println(Arrays.toString(testMethods));


        for (Method m : testMethods) {
//            System.out.println("--------------------------------");
//            System.out.println(m);
//            System.out.println(Arrays.toString(m.getDeclaredAnnotations()));

            if (m.isAnnotationPresent(BeforeSuite.class)) {
                beforeCount++;
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                afterCount++;
            }
            if (m.isAnnotationPresent(Test.class)) {
                runMethods.add(m);
            }
        }

        if (beforeCount > 1) {
            throw new RuntimeException("Methods with annotation BeforeSuite more one");
        }

        if (afterCount > 1) {
            throw new RuntimeException("Methods with annotation AfterSuite more one");
        }

        runMethods.sort(Comparator
                .comparingInt((Method i) -> i.getAnnotation(Test.class).priority())
                .reversed());

        for (Method m : testMethods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                runMethods.add(0, m);
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                afterCount++;
                runMethods.add(runMethods.size(), m);
            }
        }
//        System.out.println(runMethods);
//        System.out.println("--------------------------------");

        for (Method m : runMethods) {
            try {
//                System.out.println(m);
                m.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        System.out.println("-----------  End Test  -------------");

    }

    public TestTools() {
/*
1. Определить какие классы будут тестироваться (для которых написаны тесты)
3. Запустить метод start() по каждому классу который должент быть протестирован
 */

        listTest = new ArrayList<>();
        listTest.add((new MyTest01()).getClass());
        listTest.add((new MyTest02()).getClass());
        System.out.println(listTest);

        for (Object o : listTest) {
            start((Class) o);
        }
    }
}
