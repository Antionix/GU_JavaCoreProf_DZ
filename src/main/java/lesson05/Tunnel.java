package lesson05;

import static lesson05.MainApp.*;

public class Tunnel extends Stage {

    public Tunnel(int lenght) {
        this.length = lenght;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c, int step) {
        try {
            try {
                smpTunnel.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.lock();
                System.out.println(c.getName() + " закончил этап: " + description);
                if (step == 1 && !victory) {
                    victory = true;
                    System.out.println(String.format("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> %s Победил !!!", c.getName()));
                }
                smpTunnel.release();
                rwl.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
