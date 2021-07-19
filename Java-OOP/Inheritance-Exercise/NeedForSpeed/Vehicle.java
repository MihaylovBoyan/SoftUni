package NeedForSpeed;

public class Vehicle {

    private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int housePower;

    public Vehicle(double fuel, int housePower) {
        this.fuel = fuel;
        this.housePower = housePower;
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHousePower() {
        return housePower;
    }

    public void setHousePower(int housePower) {
        this.housePower = housePower;
    }

    public void drive(double kilometers) {

        double consumedFuel = kilometers * this.getFuelConsumption();
        if (this.getFuel() >= consumedFuel) {
            double leftFuel = this.getFuel() - consumedFuel;
            this.setFuel(leftFuel);
        }

    }

}
