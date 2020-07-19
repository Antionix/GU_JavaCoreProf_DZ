package taskBoxFruit;

public class Apple extends Fruit {

    public Apple() {
    }

    @Override
    public String getName() {
        return "Apple";
    }

    @Override
    public Float getWeight() {
        return 1.5f;
    }

    @Override
    public String toString() {
        return getName() + "{"+getWeight()+"}";
    }

}
