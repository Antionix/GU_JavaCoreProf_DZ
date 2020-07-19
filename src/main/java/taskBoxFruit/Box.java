package taskBoxFruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final Float MAX_WEIGHT = 50f;

    private Float currentWeight = 0f;
    private T fruit;
    private ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public Box(T fruit) {
        this.fruit = fruit;
        fruits = new ArrayList<>();
    }

    public void clearBox() {
        currentWeight = 0f;
    }

    public void addFruit(T addFruit) {
        if (currentWeight < MAX_WEIGHT - addFruit.getWeight()) {
            fruits.add(addFruit);
            currentWeight += addFruit.getWeight();
        } else {
            System.out.println("Box is full");
        }
    }

    public Float getWeight() {
        return fruit.getWeight() * fruits.size();
    }

    public boolean compare(Box<? extends Fruit> otherBox) {
//        return getWeight() == otherBox.getWeight();
        return getClass().equals(otherBox.getClass());
    }

    public void dropTo(Box<T> otherBox) {
        if (compare(otherBox)) {
            clearBox();
            for (T fr : fruits) {
                otherBox.addFruit(fr);
            }
            fruits.clear();
        } else {
            System.out.println("This Box with other fruit");
        }
    }

    public Float getMAX_WEIGHT() {
        return MAX_WEIGHT;
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruit=" + fruit.getName() +
                "; weight=" + fruit.getWeight() +
                "; size=" + fruits.size() +
                "} weight=" + getWeight();
    }
}
