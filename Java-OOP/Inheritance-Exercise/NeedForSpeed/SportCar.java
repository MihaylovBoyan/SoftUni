package NeedForSpeed;

public class SportCar extends Car {

    private static final double DEFAULT_FUEL_CONSUMPTION = 10;


    public SportCar(double fuel, int housePower) {
        super(fuel, housePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
