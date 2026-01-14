package factory;

public class FactoryMethodPattern {

    /***
     * The Factory Method is a creational design pattern that
     * provides an interface for creating objects in a superclass
     * but allows subclasses to alter the type of objects that will be created.
     */
    interface Vehicle {
        String getType();
    }

    class Car implements Vehicle {
        @Override
        public String getType() {
            return "Car";
        }
    }

    class Bike implements Vehicle {
        @Override
        public String getType() {
            return "Bike";
        }
    }

    class Truck implements Vehicle {
        @Override
        public String getType() {
            return "Truck";
        }
    }

    abstract class VehicleFactory {
        abstract Vehicle createVehicle();
    }

    class CarFactory extends VehicleFactory {
       Vehicle createVehicle() {
           return new Car();
       }
    }

    class BikeFactory extends VehicleFactory {
        Vehicle createVehicle() {
            return new Bike();
        }
    }

    class TruckFactory extends VehicleFactory {
        Vehicle createVehicle() {
            return new Truck();
        }
    }
}
