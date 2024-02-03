package cinema;

public class Layout {

    private final String[][] cinemaArray;
    private final int rows;
    private final int seats;

    public Layout(int rows, int seats) {
        this.cinemaArray = new String[rows + 2][seats + seats + 2];
        this.rows = rows;
        this.seats = seats;
    }

    // Controls the execution order of Layout statements
    public void start(int rows, int seats) {
        initializeEmptyCinema(rows, seats);
        printCinema(rows, seats);
    }

    // Initializes empty cinema seats within 2D Array
    public void initializeEmptyCinema(int rows, int seats) {
        for (int i = 1; i < (rows + 2); i++) {
            for (int j = 1; j < (seats + seats + 2); j++) {
                if (i == 1) {
                    if ((j < 3) || (j % 2 == 0)) {
                        this.cinemaArray[i][j] = " ";
                    } else {
                        this.cinemaArray[i][j] = String.valueOf((j - 1) / 2);
                    }
                } else {
                    if (j == 1) {
                        this.cinemaArray[i][j] = String.valueOf(i - 1);
                    } else {
                        if (j % 2 == 0) {
                            this.cinemaArray[i][j] = " ";
                        } else {
                            this.cinemaArray[i][j] = "S";
                        }
                    }
                }
            }
        }
    }

    // Prints empty cinema seats as stored in 2D Array
    public void printCinema(int rows, int seats) {
        System.out.println("Cinema:");
        for (int i = 1; i < (rows + 2); i++) {
            for (int j = 1; j < (seats + seats + 2); j++) {
                System.out.print(this.cinemaArray[i][j]);
            }
            System.out.println();
        }
    }

    // Marks chosen seat as occupied with a "B"
    public void occupySeat(int pickedRow, int pickedSeat) {
        this.cinemaArray[pickedRow + 1][(pickedSeat + pickedSeat) + 1] = "B";
    }

    // Getter for cinemaArray
    public String[][] getCinemaArray() {
        return this.cinemaArray;
    }

    // Getter for rows
    public int getRows() {
        return rows;
    }

    // Getter for seats
    public int getSeats() {
        return seats;
    }
}
