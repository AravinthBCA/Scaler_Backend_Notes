import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Coach{

    Scanner in = new Scanner(System.in);

    static int pnr = 0;

    int sideLower = 2, waitingList = 2, rca = 4;

    HashMap<Integer, String> berthType = new HashMap<>();

    public Coach(){
        berthType.put(1, "Lower");
        berthType.put(2, "Middle");
        berthType.put(3, "Upper");
        berthType.put(4, "Lower");
        berthType.put(5, "Middle");
        berthType.put(6, "Upper");
        berthType.put(7, "Side Lower"); 
        berthType.put(8, "Side Upper");
    }

    List<Cabin> cabins = new ArrayList<>(2);
    
    public void cabinInitialization() {
        int i = 1, seats = 8;
        if(cabins.size() != 0){
            i = cabins.size() * 8 + 1;
            seats = i + 8 - 1;    
        }
        Cabin obj = new Cabin();
        for(; i <= seats; i++){
            int temp = i > 8 ? i % 8 : i; 
            temp = temp == 0 ? i % 8 == 0 ? 8 : temp : temp;
            obj.addPassenger(pnr , i, "AVL", berthType.get(temp) , "", 0);
        }
        cabins.add(obj);
    }

    public void printCabinDetails(){
        for(Cabin list : cabins){
            list.printPassengerDetails();
        }
    }

    public void bookTicket(String name, int age, String berthPreference){
        boolean confirmed = false;
        boolean isLowerAvailable = false, isMiddleAvailable = false, isUpperAvailable = false, isSideLowerAvailable = false, isSideUpperAvailable = false;
        outerloop:
        for(Cabin list : cabins){
            for(Passenger passenger : list.passengers){
                if(passenger.currentStatus == "AVL" && berthPreference.equals(passenger.berthType)){
                    passenger.pnr = ++pnr;
                    passenger.currentStatus = "CNF";
                    passenger.name = name;
                    passenger.age = age;    
                    confirmed = true;  
                    break outerloop;              
                }
                if(passenger.currentStatus == "AVL"){
                    isLowerAvailable = isLowerAvailable == true ? isLowerAvailable : passenger.berthType.equals("Lower") ? true : false;
                    isMiddleAvailable = isMiddleAvailable == true ? isMiddleAvailable : passenger.berthType.equals("Middle") ? true : false;
                    isUpperAvailable = isUpperAvailable == true ? isUpperAvailable : passenger.berthType.equals("Upper") ? true : false;
                    isSideUpperAvailable = isSideUpperAvailable == true ? isSideUpperAvailable : passenger.berthType.equals("Side Upper") ? true : false;
                }
            }
        }
        if(!confirmed){
            System.out.println("Prefered Berth is not available, so could you please choose below available berth : ");
            System.out.println("Lower Berth is available: " + isLowerAvailable);
            System.out.println("Middle Berth is available: " + isMiddleAvailable);
            System.out.println("Upper Berth is available: " + isUpperAvailable);
            System.out.println("Side Upper Berth is available: " + isSideUpperAvailable);
            System.out.println("Are you able to enter preference : ");
            if(in.next().equals("yes")){
                System.out.println("Enter Berth Preference: ");
                bookTicket(name, age, in.next());
            }
            else{
                if(age > 60 && isLowerAvailable){
                    bookTicket(name, age, "Lower");
                }
                else{
                    if(isLowerAvailable){
                        bookTicket(name, age, "Lower");
                    }
                    else if(isMiddleAvailable){
                        bookTicket(name, age, "Middle");
                    }
                    else if(isUpperAvailable){
                        bookTicket(name, age, "Upper");
                    }
                    else if(isSideUpperAvailable){
                        bookTicket(name, age, "Side Upper");
                    }
                    else if(isSideLowerAvailable){
                        bookTicket(name, age, "Side Lower");
                    }
                    else{
                        System.out.println("Sorry, All Berth are Full");
                    }
                }
            }
        }
    } 
}