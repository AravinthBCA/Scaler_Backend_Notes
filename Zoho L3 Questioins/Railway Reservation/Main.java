public class Main {

    public static Controller controller = new Controller();
    public static void main(String[] args) {
        options();
    }

    public static void options(){
        boolean flag = true;
        while(flag){
            System.out.println("1. Initialization");
            System.out.println("2. Book ticket for an adult passenger travelling alone");
            System.out.println("3. Print details of a given PNR");
            System.out.println("4. Book ticket for passengers traveling as a group in the same PNR");
            System.out.println("5. Cancel ticket");
            System.out.println("6. Re-assign tickets after cancellation");
            System.out.println("7. ZOHO Railways is now updating its coach with 2 more cabins");
            System.out.println("8. ZOHO Railways is now upgrading its train capacity by adding a new coach");
            System.out.println("9. Exit the program");
            System.out.println("Enter your choice: ");

            int choice = Integer.parseInt(System.console().readLine());
            switch(choice){
                case 1:
                    controller.initialization();
                    break;
                case 2:
                    controller.bookTicket();
                    break;
                case 3:
                    // PrintDetails();
                    break;
                case 4:
                    // BookTicketGroup();
                    break;
                case 5:
                    // CancelTicket();
                    break;
                case 6:
                    // ReAssignTicket();
                    break;
                case 7:
                    // ZOHO();
                    break;
                case 8:
                    // TrainCapacity();
                    break;
                case 9:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}