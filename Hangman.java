import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS = {"apple", "house", "smile", "chair", "light"};
    private String word;
    private char[] displayWord;
    private int attemptsLeft;
    private boolean[] guessedLetters;
    private Scanner scanner;

    public Hangman() {
        Random random = new Random();
        word = WORDS[random.nextInt(WORDS.length)];
        displayWord = new char[word.length()];
        Arrays.fill(displayWord, '_');
        attemptsLeft = 7;
        guessedLetters = new boolean[26];
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to Hangman!");
        boolean gameWon = false;

        while (attemptsLeft > 0 && !gameWon) {
            displayHangman();
            System.out.println("Word: " + String.valueOf(displayWord));
            System.out.print("Guess a letter: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);
            if (guessedLetters[guess - 'a']) {
                System.out.println("You already guessed that letter. Try another.");
                continue;
            }

            guessedLetters[guess - 'a'] = true;
            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    displayWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attemptsLeft--;
                System.out.println("Incorrect guess. You have " + attemptsLeft + " tries left.");
            }

            if (String.valueOf(displayWord).equals(word)) {
                gameWon = true;
                System.out.println("Congratulations! You guessed the word: " + word);
            }
        }

        if (!gameWon) {
            displayHangman();
            System.out.println("Game over! The word was: " + word);
        }
    }

    private void displayHangman() {
        System.out.println("---------");
        System.out.println("| |");
        System.out.println("| " + (attemptsLeft < 7 ? "O" : " "));
        System.out.println("| " + (attemptsLeft < 6 ? "\\" : " ") + (attemptsLeft < 5 ? "|" : " ") + (attemptsLeft < 4 ? "/" : " "));
        System.out.println("| " + (attemptsLeft < 3 ? "|" : " "));
        System.out.println("| " + (attemptsLeft < 2 ? "/" : " ") + " " + (attemptsLeft < 1 ? "\\" : " "));
        System.out.println("_|_");
    }
}