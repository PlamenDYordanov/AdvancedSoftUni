package Advanced.DefiningClasses.Exercise.P03_SpeedRacing;

public class RacingCar {
    private String model;
    private  double fuelAmount;
    private  double fuelCost;
    private double distanceTravel;

    public RacingCar(String model, double fuelAmount, double fuelCost, double distanceTravel) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTravel = distanceTravel;
    }
    public boolean calculation(double travelDistance){
         boolean isEnough = travelDistance * this.fuelCost<= this.fuelAmount;
         return isEnough;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public double getDistanceTravel() {
        return distanceTravel;
    }

    public void setDistanceTravel(double distanceTravel) {
       this.distanceTravel = distanceTravel;
    }
}
