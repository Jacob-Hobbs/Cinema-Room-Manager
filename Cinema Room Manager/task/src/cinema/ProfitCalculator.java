package cinema;

import java.util.Scanner;

public class ProfitCalculator {

    private final Scanner scanner;

    public ProfitCalculator() {
        this.scanner = new Scanner(System.in);
    }

    // Controls the execution order of ProfitCalculator statements
    public void start() {
        numOfRowsAndSeats();
    }

    // Accepts input to declare number of rows and seats in cinema
    public void numOfRowsAndSeats() {
        System.out.println("Enter the number of rows:");
        int numOfRows = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter the number of seats in each row:");
        int numOfSeats = Integer.valueOf(scanner.nextLine());
        System.out.println("Total income:");
        System.out.println("$" + calculateTotalProfit(numOfRows, numOfSeats));
    }

    // Calculates total profit based on number of rows and seats in cinema
    public static int calculateTotalProfit(int numOfRows, int numOfSeats) {
        int totalSeats = numOfRows * numOfSeats;
        if (totalSeats <= 60) {
            return totalSeats * 10;
        } else {
            int frontHalfRows = (numOfRows / 2);
            int backHalfRows = (numOfRows - frontHalfRows);
            return ((backHalfRows * numOfSeats) * 8) + ((frontHalfRows * numOfSeats) * 10);
        }
    }
}
