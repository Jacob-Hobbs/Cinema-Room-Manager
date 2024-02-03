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
                while (true) {
                    System.out.println();
                    int rowNum = profitCalculator.getRowNumber();
                    int seatNum = profitCalculator.getSeatNumber();
                    if (rowNum > layout.getRows() || seatNum > layout.getSeats()) {
                        System.out.println();
                        System.out.println("Wrong input!");
                    } else if (!layout.occupySeat(rowNum, seatNum,
                            profitCalculator.calculateSeatCost(rowNum, numOfRows, numOfSeats))) {
                        System.out.println();
                        System.out.println("That ticket has already been purchased!");
                    } else {
                        System.out.println();
                        layout.occupySeat(rowNum, seatNum,
                                profitCalculator.calculateSeatCost(rowNum, numOfRows, numOfSeats));
                        System.out.println("Ticket price: $" +
                                profitCalculator.calculateSeatCost(rowNum, numOfRows, numOfSeats));
                        break;
                    }
                }
            } else if (selection == 3) {
                System.out.println();
                System.out.println("Number of purchased tickets: " + layout.getPurchasedTickets());
                double percentage = ((double)layout.getPurchasedTickets()/(numOfRows * numOfSeats)) * 100;
                String formattedPercentage = String.format("%.2f", percentage);
                System.out.println("Percentage: " + formattedPercentage + "%");
                System.out.println("Current income: $" + layout.getCurrentIncome());
                System.out.println("Total income: $" +
                        profitCalculator.calculateTotalProfit(numOfRows, numOfSeats));
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
