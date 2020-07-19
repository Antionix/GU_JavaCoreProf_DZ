package taskBoxFruit;

public class Orange extends Fruit {

    public Orange() {
    }

    @Override
    public String getName() {
        return "Orange";
    }

    @Override
    public Float getWeight() {
        return 1f;
    }

    @Override
    public String toString() {
        return getName() + "{"+getWeight()+"}";
    }
}
