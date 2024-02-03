package cinema;

import java.util.Scanner;

public class ProfitCalculator {

    private final Scanner scanner;

    public ProfitCalculator() {
        this.scanner = new Scanner(System.in);
    }

    // Controls the execution order of ProfitCalculator statements
    public void start() {
        int numOfRows = numOfRows();
        int numOfSeats = numOfSeats();
        System.out.println();
        Layout layout = new Layout(numOfRows, numOfSeats);
        layout.start(numOfRows, numOfSeats);
        System.out.println();
        purchaseTicket(numOfRows, numOfSeats);
    }

    // Intakes row and seat number and outputs ticket cost
    public void purchaseTicket(int numOfRows, int numOfSeats) {
        System.out.println("Enter a row number:");
        int rowNum = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter a seat number in that row:");
        int seatNum = Integer.valueOf(scanner.nextLine());
        System.out.println();
        System.out.println("Ticket price: $" + calculateSeatCost(rowNum, numOfRows, numOfSeats));
        System.out.println();
        // FIXME : Creates new array instead of updating existing one.
        Layout layout = new Layout(numOfRows, numOfSeats);
        layout.occupySeat(rowNum, seatNum, numOfRows, numOfSeats);
        layout.printCinema(numOfRows, numOfSeats);
    }

    // calculates and returns seat cost based on location in cinema
    public int calculateSeatCost(int rowNum, int numOfRows, int numOfSeats) {
        int totalSeats = numOfRows * numOfSeats;
        int frontHalfRows = (numOfRows / 2);
        //int backHalfRows = (numOfRows - frontHalfRows);
        if (totalSeats <= 60 || rowNum <= frontHalfRows) {
            return 10;
        } else {
            return 8;
        }
    }

    // Gathers and returns the number of rows in the cinema
    public int numOfRows() {
        System.out.println("Enter the number of rows:");
        return Integer.valueOf(scanner.nextLine());
    }

    // Gathers and returns the number of seats in the cinema
    public int numOfSeats() {
        System.out.println("Enter the number of seats in each row:");
        return Integer.valueOf(scanner.nextLine());
    }

    // Accepts input to declare number of rows and seats in cinema
    public void numOfRowsAndSeats() {
        System.out.println("Enter the number of rows:");
        int numOfRows = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter the number of seats in each row:");
        int numOfSeats = Integer.valueOf(scanner.nextLine());
        totalIncome(numOfRows, numOfSeats);
    }

    public void totalIncome(int numOfRows, int numOfSeats) {
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
