import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private Scanner scanner;

    public TicTacToe(Scanner scanner) {
        this.scanner = scanner;
        board = new char[3][3];
        currentPlayer = 'O';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void play() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player 1: O, Player 2: X");
        System.out.println("Enter 'q' at any time to quit the game.");

        boolean gameEnded = false;
        while (!gameEnded) {
            displayBoard();
            String result = getPlayerMove();
            if (result.equals("quit")) {
                System.out.println("Game ended. Returning to main menu.");
                break;
            }
            int move = Integer.parseInt(result);
            placeMove(move);

            if (checkWin()) {
                displayBoard();
                System.out.println("Player " + (currentPlayer == 'O' ? "1" : "2") + " wins!");
                gameEnded = true;
            } else if (isBoardFull()) {
                displayBoard();
                System.out.println("It's a tie!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
            }
        }
    }

    private void displayBoard() {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    private String getPlayerMove() {
        while (true) {
            System.out.print("Player " + (currentPlayer == 'O' ? "1" : "2") + "'s turn. Enter a number (1-9) or 'q' to quit: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("q")) {
                return "quit";
            }
            try {
                int move = Integer.parseInt(input);
                if (move >= 1 && move <= 9 && isValidMove(move)) {
                    return String.valueOf(move);
                } else {
                    System.out.println("Invalid move. Please choose an empty space (1-9) or 'q' to quit.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9 or 'q' to quit.");
            }
        }
    }

    private boolean isValidMove(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        return board[row][col] == ' ';
    }

    private void placeMove(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        board[row][col] = currentPlayer;
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}