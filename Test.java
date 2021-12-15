package day20211108;

class Vehicle {
    int wheels;
    double weight;

    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Vehicle[wheels="+wheels+",weight="+weight+"]";
    }
}

class Car extends Vehicle{
    int seats;

    public Car(int wheels, double weight, int seats) {
        super(wheels, weight);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Car[seats="+seats+",wheels="+wheels+",weight="+weight+"]";
    }
}

public class Test{
    public static void main(String[] args) {
        Car car=new Car(4,200,5);
        System.out.println(car);
        Vehicle vehicle=new Vehicle(3,300);
        System.out.println(vehicle);
    }
}


