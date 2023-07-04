import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int generatedNumber = generateRandomNumber(minRange, maxRange);
            int attempts = 0;

            JOptionPane.showMessageDialog(null, "Welcome to Guess the Number!");

            while (true) {
                String input = JOptionPane.showInputDialog("Enter a number between " + minRange + " and " + maxRange + ":");
                int guessedNumber = Integer.parseInt(input);

                attempts++;

                if (guessedNumber == generatedNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (guessedNumber < generatedNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }

                if (attempts >= maxAttempts) {
                    JOptionPane.showMessageDialog(null, "Oops! You've reached the maximum number of attempts. The number was " + generatedNumber + ".");
                    break;
                }
            }

            int choice = JOptionPane.showConfirmDialog(null, "Your current score is " + score + ". Do you want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                playAgain = false;
            }
        }

        JOptionPane.showMessageDialog(null, "Thank you for playing! Your final score is " + score + ".");
    }

    private static int generateRandomNumber(int minRange, int maxRange) {
        Random random = new Random();
        return random.nextInt(maxRange - minRange + 1) + minRange;
    }
}

