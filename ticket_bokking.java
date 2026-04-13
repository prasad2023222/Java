import java.util.*;

public class TicketSystem {
    static int seats = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter seats to book: ");
        int n = sc.nextInt();

        if (n <= seats) {
            seats -= n;
            System.out.println("Booked! Remaining: " + seats);
        } else {
            System.out.println("Not enough seats");
        }
    }
}
