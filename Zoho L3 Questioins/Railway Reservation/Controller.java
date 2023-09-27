import java.util.Scanner;

public class Controller {

    Scanner in = new Scanner(System.in);

    Coach coach = new Coach();

    Cabin cabin = new Cabin();

    public void initialization() {
        coach.cabinInitialization();
        coach.cabinInitialization();
        coach.printCabinDetails();
    }

    public void bookTicket() {
        System.out.println("Enter the passenger name: ");
        String name = in.next();
        System.out.println("Enter the passenger age: ");
        int age = in.nextInt();
        System.out.println("Enter Berth Preference (Lower, Middle, Upper): ");
        String berthPreference = in.next();
        coach.bookTicket(name, age, berthPreference);  
        coach.printCabinDetails(); 
    }
}