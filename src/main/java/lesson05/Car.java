package lesson05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

import static lesson05.MainApp.*;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cdlRaceReady.countDown(); //сообщаем готовы
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            cbRace.await(); // ждем Старта

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this, race.getStages().size() - i);
            }

            cdlRaceFinish.countDown();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }


    }
}