package aquarium.entities.decorations;

public abstract class BaseDecoration implements Decoration {

    private int comfort;
    private double price;

    protected BaseDecoration(int comfort, double price) {
        this.comfort = comfort;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getComfort() {
        return comfort;
    }
}
