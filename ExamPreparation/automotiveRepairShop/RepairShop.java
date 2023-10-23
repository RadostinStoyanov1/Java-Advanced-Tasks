package automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {
    private List<Vehicle> vehicles;
    private int capacity;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.vehicles.size() < capacity) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVIN().equals(vin)) {
                this.vehicles.remove(vehicle);
                return true;
            }
        }
        return false;
    }

    public int getCount() {
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage() {
        return this.vehicles.stream().min((v1, v2) -> Integer.compare(v1.getMileage(), v2.getMileage())).get();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:");
        for (Vehicle vehicle : this.vehicles) {
            sb.append(System.lineSeparator());
            sb.append(vehicle.toString());
        }
        return sb.toString();
    }
}
