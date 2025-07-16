import java.util.Scanner;

public class GameConsole {
  private static final String STUDENT_ID = "22571017";
  private static final String STUDENT_NAME = "Wong Wing Laam";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
      displayMenu();
      System.out.print("Enter the corresponding number (1-3) or 'q' to quit: ");
      String choice = scanner.nextLine().trim().toLowerCase();

      if ("1".equals(choice)) {
        TicTacToe ticTacToe = new TicTacToe(scanner);
        ticTacToe.play();
      } else if ("2".equals(choice)) {
        Hangman hangman = new Hangman();
        hangman.play();
      } else if ("3".equals(choice)) {
        RockPaperScissors rps = new RockPaperScissors();
        rps.play();
      } else if ("q".equals(choice)) {
        running = false;
        System.out.println("Thank you for playing! Goodbye!");
      } else {
        System.out.println("Invalid input. Please enter 1, 2, 3, or 'q'.");
      }
    }
    scanner.close();
  }

  private static void displayMenu() {
    System.out.println("=============================================");
    System.out.println("Student Information:");
    System.out.println("SID: " + STUDENT_ID + " Name: " + STUDENT_NAME);
    System.out.println("=============================================");
    System.out.println("Welcome to the Game Console: A Trio of Classic Games!");
    System.out.println("Please select a game to play:");
    System.out.println("1. Tic Tac Toe");
    System.out.println("2. Hangman");
    System.out.println("3. Rock Paper Scissors");
  }
}