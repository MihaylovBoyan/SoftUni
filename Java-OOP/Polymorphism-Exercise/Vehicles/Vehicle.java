package Vehicles;

import java.text.DecimalFormat;

public class Vehicle {

    protected double fuel;
    protected double consumption;

    protected Vehicle(double fuel, double consumption) {
        this.fuel = fuel;
        this.consumption = consumption;
    }

    String drive(double distance) {
        double fuelNeeded = distance * this.consumption;
        if (fuelNeeded > this.fuel) {
            return this.getClass().getSimpleName() + " needs refueling";
        }

        this.fuel -= fuelNeeded;

        DecimalFormat formatter = new DecimalFormat("##.##");

        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));

    }

    void refuel(double liters) {
        this.fuel += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuel);
    }


}
