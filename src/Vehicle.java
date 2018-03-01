import java.util.ArrayList;

public class Vehicle {

    private int currentPosX;
    private int currentPosY;
    private ArrayList<Ride> customers;
    private int[] currentRideData;
    private int rideCounter;

    public Vehicle(int currentPosX, int currentPosY,
                   ArrayList<Ride> customers) {

        this.currentPosX = currentPosX;
        this.currentPosY = currentPosY;
        this.customers = customers;
        this.currentRideData = null;
        this.rideCounter = 0;

    }

    public int getCurrentPosX() {
        return currentPosX;
    }

    public void setCurrentPosX(int currentPosX) {
        this.currentPosX = currentPosX;
    }

    public int getCurrentPosY() {
        return currentPosY;
    }

    public void setCurrentPosY(int currentPosY) {
        this.currentPosY = currentPosY;
    }

    public int[] getCurrentRideData() {
        return currentRideData;
    }

    public void setCurrentRideData(int[] currentRideData) {
        this.currentRideData = currentRideData;
    }

    public ArrayList<Ride> getCustomers() {

        return customers;
    }

    public void setCustomers(ArrayList<Ride> customers) {
        this.customers = customers;
    }

    public void addRide(Ride ride){
        this.customers.add(ride);
        this.rideCounter++;
    }

    public Ride getLatestRide(){
        return customers.get(customers.size()-1);
    }

    public int getRideCounter() {
        return rideCounter;
    }

    public String print() {
        StringBuffer tmp = new StringBuffer();
        tmp.append(rideCounter);
        for(Ride ride : customers){
            tmp.append(" ");
            tmp.append(ride.rideID);
        }

        return tmp.toString();
    }
}