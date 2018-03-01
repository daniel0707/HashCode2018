import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        //0. filter list                                                                                                        DONE
        //1. Sort list of rides by distance from start and then by starting step                                                DONE
        //2. for each car give out 1st ride                                                                                     DONE
        //3. for each step check if car is free and then make it check for ride that is closest and earliest starting time
        // NOTE each car has a counter of rides it took and what was the ID number of the ride77
        ArrayList<Ride> rideArrayList = new ArrayList<>();
        ArrayList<Vehicle> cars = new ArrayList<>();
        ReadFile RF = new ReadFile();

        ArrayList<String> answer = new ArrayList<>();

        for(ArrayList<Integer> array : RF.rideArrays){
            if(Tools.canWeReachInTime(array.get(1),array.get(2),array.get(3),array.get(4),array.get(5),array.get(6))) {
                rideArrayList.add(new Ride(array));
            }
        }

        Collections.sort(rideArrayList);

        for(int i = RF.mapData.get(2); i>0; i--){
            cars.add(new Vehicle(0,0, new ArrayList<Ride>()));
        }

        for(Vehicle car: cars){
            car.addRide(rideArrayList.get(0));
            rideArrayList.remove(0);
        }

        int steps = RF.mapData.get(5);
        
        for (int i = steps; i>0; i--){
            if(!rideArrayList.isEmpty()) {
                for (Vehicle car : cars) {
                    if(!rideArrayList.isEmpty()) {
                        if (car.getLatestRide().dist() + car.getLatestRide().startStep <= steps) {
                            Collections.sort(rideArrayList, new Comparator<Ride>() {
                                @Override
                                public int compare(Ride o1, Ride o2) {
                                    int tmp = Tools.distance(car.getLatestRide().startX, car.getLatestRide().startY, o1.startX, o1.startY) -
                                            Tools.distance(car.getLatestRide().startX, car.getLatestRide().startY, o2.startX, o2.startY);
                                    if (tmp == 0) {
                                        return (o1.endStep - o1.startStep) - (o2.endStep - o2.startStep);
                                    }
                                    return tmp;
                                }
                            });

                            car.addRide(rideArrayList.get(0));
                            rideArrayList.remove(0);
                        }
                    }
                }
            }
        }

        for(Vehicle car: cars){
            answer.add(car.print());
        }

        FileWriter writer = new FileWriter("output.txt");
        for(String str : answer){
            writer.write(str + System.getProperty("line.separator"));
        }

        writer.close();
    }
}
