package NeedForSpeed;

public class Car extends Vehicle {

    private static final double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int housePower) {
        super(fuel, housePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

}
