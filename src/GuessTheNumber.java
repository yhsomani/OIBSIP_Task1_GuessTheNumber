import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {

    public static void main(String[] args) {
        final int MIN = 1;
        final int MAX = 100;

        Random random = new Random();
        int numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;
        final int MAX_ATTEMPTS = 5;

        int attempts = 0;
        int score = 0;

        while (attempts < MAX_ATTEMPTS) {
            String guessString = JOptionPane.showInputDialog(null,
                    "Guess the number between " + MIN + " and " + MAX +
                            "\nAttempts left: " + (MAX_ATTEMPTS - attempts) +
                            "\nScore: " + score);
            if (guessString == null) {
                break;
            }

            int guess;
            try {
                guess = Integer.parseInt(guessString);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            if (guess == numberToGuess) {
                score += MAX_ATTEMPTS - attempts;
                JOptionPane.showMessageDialog(null,
                        "Congratulations, you guessed the number!\nScore: " + score);
                break;
            } else if (guess < numberToGuess) {
                JOptionPane.showMessageDialog(null,
                        "The number is higher than you guess.", "Try again", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "The number is lower than you guess.", "Try again", JOptionPane.INFORMATION_MESSAGE);
            }

            attempts++;
        }

        if (attempts == MAX_ATTEMPTS) {
            JOptionPane.showMessageDialog(null,
                    "Sorry, you did not guess the number.\nThe number was: " + numberToGuess +
                            "\nScore: " + score);
        }
    }

}
