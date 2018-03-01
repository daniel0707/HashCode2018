import java.util.ArrayList;

public class Ride implements Comparable<Ride> {

    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public int startStep;
    public int endStep;
    public int rideID;

    public Ride(ArrayList<Integer> rideData) {

        this.rideID = rideData.get(0);
        this.startX = rideData.get(1);
        this.startY = rideData.get(2);
        this.endX = rideData.get(3);
        this.endY = rideData.get(4);
        this.startStep = rideData.get(5);
        this.endStep = rideData.get(6);

    }
    @Override
    public int compareTo(Ride other) {
        int tmp = Tools.distToStart(this.startX, this.startY) - Tools.distToStart(other.startX, other.startY);
        if(tmp == 0){
            return (this.endStep - this.startStep)-(other.endStep - other.startStep);
        }
        return tmp;
    }

    public int dist(){
        return Tools.distance(startX, startY, endX, endY);
    }

}