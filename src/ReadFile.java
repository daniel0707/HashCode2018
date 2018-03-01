import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    File file = new File("C:\\Users\\danie\\IdeaProjects\\hashcode\\input.in");
    Scanner scanner = new Scanner(new FileInputStream(file));

    public ReadFile() throws FileNotFoundException {
        this.read();
    }

    ArrayList<Integer> mapData = new ArrayList<>();
    ArrayList<ArrayList<Integer>> rideArrays = new ArrayList<>();

    void read(){
        String tmp = scanner.nextLine();
        for(String str : tmp.split(" ")){
            mapData.add(Integer.parseInt(str));
        }
        int i = 0;
        while(scanner.hasNextLine()){
            String temp = scanner.nextLine();
            ArrayList<Integer> tmpArray = new ArrayList<>();
            tmpArray.add(i);
            i++;
            for(String split : temp.split(" ")){
                tmpArray.add(Integer.parseInt(split));
            }
            rideArrays.add(tmpArray);
        }
        scanner.close();
    }

}
