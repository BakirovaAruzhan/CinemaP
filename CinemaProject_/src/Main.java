import java.util.Scanner;

public class Main {
    static final int TICKET_PRICE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of seats in a row: ");
        int seats = scanner.nextInt();

        char[][] cinemaSeats = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinemaSeats[i][j] = 'S';
            }
        }
        menu(cinemaSeats, rows, seats);
    }

    public static void displayCinemaHall(char[][] cinemaSeats, int rows, int seats) {
        System.out.println("Cinema Hall");
        System.out.println();

        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(cinemaSeats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void buyingAticket(char[][] cinemaSeats, int rows, int seats) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to buy a ticket? (type y/n)");
            char answer = scanner.next().charAt(0);

            if (answer != 'y') {
                System.out.println("You declined to purchase.");
                return;
            }

            System.out.println("Select row=");
            int selectedRow = scanner.nextInt();

            System.out.println("Select seat=");
            int selectedSeat = scanner.nextInt();

            if (selectedRow < 1 || selectedRow > rows || selectedSeat < 1 || selectedSeat > seats) {
                System.out.println("Such seat doesn’t exist.");
                continue;
            }

            if (cinemaSeats[selectedRow - 1][selectedSeat - 1] == 'B') {
                System.out.println("This seat is already booked!");
                continue;
            }

            System.out.println("Ticket Price: $" + TICKET_PRICE);
            cinemaSeats[selectedRow - 1][selectedSeat - 1] = 'B';
            System.out.println("The ticket was successfully purchased!");
            return;
        }
    }

    public static void menu(char[][] cinemaSeats, int rows, int seats) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Print seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");

            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayCinemaHall(cinemaSeats, rows, seats);
                    break;
                case 2:
                    buyingAticket(cinemaSeats, rows, seats);
                    break;
                case 3:
                    statistics(cinemaSeats, rows, seats);
                case 0:
                    System.out.println("We will be glad to see you again!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    public static int countSoldTickets(char[][] cinemaSeats, int rows, int seats) {
        int soldTickets = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if (cinemaSeats[i][j] == 'B') {
                    soldTickets++;

                }
            }
        }
        return soldTickets;
    }

    public static int statistics(char[][] cinemaSeats, int rows, int seats) {
        Scanner scanner = new Scanner(System.in);

        int totalNumberOfSeats = rows * seats;
        int numberOftickets = countSoldTickets(cinemaSeats, rows, seats);
        int numberOfseats = totalNumberOfSeats - numberOftickets;
        int totalInCome = TICKET_PRICE * numberOftickets;
        int currentIncome = TICKET_PRICE * numberOftickets;


        while (true) {
            System.out.println("Statistics");
            System.out.println("1. Current income: ");
            System.out.println("2. Total income:");
            System.out.println("3. Number of free seats:");
            System.out.println("4. Total number of seats:");
            System.out.println("0. Exit");


            int choice2 = scanner.nextInt();

            switch (choice2) {
                case 1:
                    System.out.println(" Current income - " + currentIncome);
                    break;
                case 2:
                    System.out.println("Total income - " + totalNumberOfSeats);
                    break;
                case 3:
                    System.out.println("Number of free seats - " + numberOfseats);
                    break;
                case 4:
                    System.out.println("Total number of seats - " + totalNumberOfSeats);
                    break;
                case 0:
                    menu(cinemaSeats, rows, seats);
                default:

            }
        }
    }
}

