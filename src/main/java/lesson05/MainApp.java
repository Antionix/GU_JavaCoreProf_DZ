package lesson05;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainApp {
    public static final int CARS_COUNT = 4;
    public static final CountDownLatch cdlRaceReady = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch cdlRaceFinish = new CountDownLatch(CARS_COUNT);
    public static final CyclicBarrier cbRace = new CyclicBarrier(CARS_COUNT);
    public static final Semaphore smpTunnel = new Semaphore(CARS_COUNT / 2);

    public static final CountDownLatch cdlRaceVictory = new CountDownLatch(1);
    public static ReentrantLock rwl = new ReentrantLock();
    public static boolean victory = false;

    static void CarRace() {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(80), new Road(40));
//        Race race = new Race(new Road(60), new Tunnel(80), new Road(40), new Tunnel(50));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            new Thread(car).start();
        }

        try {
            cdlRaceReady.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка завершена!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

//        try {
//            cdlRaceVictory.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            cdlRaceFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        System.out.println("======= My homework 05 =======");
        CarRace();
    }
}
