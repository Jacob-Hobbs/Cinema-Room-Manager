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
        int rowNum = getRowNumber();
        int seatNum = getSeatNumber();
        System.out.println();
        System.out.println("Ticket price: $" + calculateSeatCost(rowNum, numOfRows,
                numOfSeats));
        System.out.println();
        purchaseTicket(numOfRows, numOfSeats, layout, rowNum, seatNum);
    }

    // Retrieves requested row number from user
    public int getRowNumber() {
        System.out.println("Enter a row number:");
        return Integer.valueOf(scanner.nextLine());
    }

    // Retrieves requested seat number from user
    public int getSeatNumber() {
        System.out.println("Enter a seat number in that row:");
        return Integer.valueOf(scanner.nextLine());
    }

    // Intakes row and seat number and outputs ticket cost
    public void purchaseTicket(int numOfRows, int numOfSeats, Layout layout,
                               int rowNum, int seatNum) {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        layout.occupySeat(rowNum, seatNum, profitCalculator.calculateSeatCost(rowNum, numOfRows, numOfSeats));
        layout.printCinema(numOfRows, numOfSeats);
    }

    // calculates and returns seat cost based on location in cinema
    public int calculateSeatCost(int rowNum, int numOfRows, int numOfSeats) {
        int totalSeats = numOfRows * numOfSeats;
        int frontHalfRows = (numOfRows / 2);
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

    // Outputs total income of whole cinema
    public void totalIncome(int numOfRows, int numOfSeats) {
        System.out.println("Total income:");
        System.out.println("$" + calculateTotalProfit(numOfRows, numOfSeats));
    }

    // Calculates total profit based on number of rows and seats in cinema
    public int calculateTotalProfit(int numOfRows, int numOfSeats) {
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
