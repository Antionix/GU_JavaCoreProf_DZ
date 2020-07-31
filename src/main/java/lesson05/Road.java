package lesson05;

import static lesson05.MainApp.rwl;
import static lesson05.MainApp.victory;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c, int step) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);

            rwl.lock();
            System.out.println(c.getName() + " закончил этап: " + description);

            if (step == 1 && !victory) {
                victory = true;
                System.out.println(String.format("%s !!! Победил !!!", c.getName()));
            }
            rwl.unlock();
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}