public class Passenger{
    
    int pnr = 0;
    String name;
    int age;
    String berthType;
    String currentStatus;
    int berthNo;

    public Passenger(int pnr2, int berthNo2, String currentStatus2, String berthType2, String name2, int age2) {
        pnr = pnr2;
        berthNo = berthNo2;
        currentStatus = currentStatus2;
        berthType = berthType2;
        name = name2;
        age = age2;    
    }

    public String toString(){
        return "PNR: " + pnr + ", Name: " + name + ", Age: " + age + ", Berth Type: " + berthType + ", Current Status: " + currentStatus + ", Berth No: " + berthNo;
    }
}