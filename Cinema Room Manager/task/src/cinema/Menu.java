package cinema;

import java.sql.Array;

public class Menu {

    private final String[][] cinemaArray;

    public Menu() {
        this.cinemaArray = new String[9][18];
    }

    // Controls the execution order of program statements
    public void start() {
        initializeEmptyCinema();
        printEmptyCinema();
    }

    // Initializes empty cinema seats within 2D Array
    public void initializeEmptyCinema() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 18; j++) {
                if (i == 1) {
                    if ((j < 3) || (j % 2 == 0)) {
                        cinemaArray[i][j] = " ";
                    } else {
                        cinemaArray[i][j] = String.valueOf((j - 1) / 2);
                    }
                } else {
                    if (j == 1) {
                        cinemaArray[i][j] = String.valueOf(i - 1);
                    } else {
                        if (j % 2 == 0) {
                            cinemaArray[i][j] = " ";
                        } else {
                            cinemaArray[i][j] = "S";
                        }
                    }
                }
            }
        }
    }

    // Prints empty cinema seats as stored in 2D Array
    public void printEmptyCinema() {
        System.out.println("Cinema:");
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 18; j++) {
                System.out.print(cinemaArray[i][j]);
            }
            System.out.println();
        }
    }
}
