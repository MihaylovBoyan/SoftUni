package Vehicles;

import java.text.DecimalFormat;

public class Vehicle {

    private double fuel;
    private double consumption;
    private double tankCapacity;

    protected Vehicle(double fuel, double consumption, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuel(fuel);
        this.consumption = consumption;
    }

    protected void addConsumption(double additionalConsumption){
        this.consumption += additionalConsumption;
    }

    protected void subtractConsumption(double subtraction){
        this.consumption -= subtraction;
    }

    public void setFuel(double fuel) {
        validateFuel(fuel);
        validateCapacity(fuel);
        this.fuel = fuel;
    }

    private void validateCapacity(double additionalFuel){
        if(additionalFuel > this.tankCapacity){
            throw new
                    IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    private void validateFuel(double fuel){
        if(fuel <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    String drive(double distance) {
        double fuelNeeded = distance * this.consumption;
        if (fuelNeeded > this.fuel) {
            return this.getClass().getSimpleName() + " needs refueling";
        }

        this.setFuel(this.fuel - fuelNeeded);

        DecimalFormat formatter = new DecimalFormat("##.##");

        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));

    }

    void refuel(double liters) {
        validateFuel(liters);
        validateCapacity(liters);
        this.setFuel(liters + this.fuel);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuel);
    }


}
