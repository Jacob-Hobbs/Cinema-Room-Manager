package cinema;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    // Controls the execution order of Menu statements
    public void start() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        int numOfRows = profitCalculator.numOfRows();
        int numOfSeats = profitCalculator.numOfSeats();
        Layout layout = new Layout(numOfRows, numOfSeats);
        layout.initializeEmptyCinema(numOfRows, numOfSeats);
        while(true) {
            System.out.println();
            printMainMenu();
            int selection = Integer.valueOf(scanner.nextLine());
            if (selection == 1) {
                layout.printCinema(numOfRows, numOfSeats);
            } else if (selection == 2) {
                int rowNum = profitCalculator.getRowNumber();
                int seatNum = profitCalculator.getSeatNumber();
                layout.occupySeat(rowNum, seatNum);
                System.out.println("Ticket price: $" +
                        profitCalculator.calculateSeatCost(rowNum, numOfRows, numOfSeats));
            } else {
                break;
            }
        }
    }

    // Outputs main menu to terminal
    public void printMainMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }
}
