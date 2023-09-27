import java.util.ArrayList;
import java.util.List;

public class Cabin{

    List<Passenger> passengers = new ArrayList<>(8);

    public void addPassenger(int pnr, int berthNo, String currentStatus, String berthType, String name, int age) {
        passengers.add(new Passenger(pnr, berthNo, currentStatus, berthType, name, age));
    }

    public void printPassengerDetails(){
        for(Passenger list : passengers){
            System.out.println(list.toString());
        }
    }
}