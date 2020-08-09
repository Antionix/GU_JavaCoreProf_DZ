public class MyTest01 {

    @BeforeSuite
    public static void methodBefore() {
        System.out.println("Method methodBefore / annotation BeforeSuite = run");
    }

    @Test
    public static void methodStep01() {
        System.out.println("Method methodStep01 / annotation Test / priority default = run");
    }

    @Test(priority = 7)
    public static void methodStep02() {
        System.out.println("Method methodStep02 / annotation Test / priority 7 = run");
    }

    @Test(priority = 2)
    public static void methodStep03() {
        System.out.println("Method methodStep03 / annotation Test / priority 2 = run");
    }

    @Test(priority = 2)
    public static void methodStep04() {
        System.out.println("Method methodStep04 / annotation Test / priority 2 = run");
    }

    @AfterSuite
    public static void methodAfter() {
        System.out.println("Method methodAfter / annotation AfterSuite = run");
    }
}
