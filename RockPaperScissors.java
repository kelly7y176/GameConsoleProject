import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private Scanner scanner;
    private Random random;

    public RockPaperScissors() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void play() {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter 'rock', 'paper', or 'scissors' to play, or 'q' to return to the main menu.");

        while (true) {
            System.out.print("Player 1's choice: ");
            String player1 = scanner.nextLine().trim().toLowerCase();

            if (player1.equals("q")) {
                break;
            }

            if (!isValidChoice(player1)) {
                System.out.println("Invalid choice. Please enter 'rock', 'paper', or 'scissors'.");
                continue;
            }

            System.out.print("Player 2's choice: ");
            String player2 = scanner.nextLine().trim().toLowerCase();

            if (!isValidChoice(player2)) {
                System.out.println("Invalid choice. Please enter 'rock', 'paper', or 'scissors'.");
                continue;
            }

            System.out.println("Player 1 chose: " + player1);
            System.out.println("Player 2 chose: " + player2);
            determineWinner(player1, player2);
        }
    }

    private boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }

    private void determineWinner(String player1, String player2) {
        if (player1.equals(player2)) {
            System.out.println("It's a tie!");
        } else if ((player1.equals("rock") && player2.equals("scissors")) ||
                   (player1.equals("paper") && player2.equals("rock")) ||
                   (player1.equals("scissors") && player2.equals("paper"))) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }
}