package CodeSoftTask;
import java.util.*;
public class NumberGame 
{
    public static int gameRound()
    {
        int lowRange = 1, highRange = 100; 
        int maxAttempts = 5;
        int targetNumber = (int) (Math.random() * (highRange - lowRange + 1) + lowRange);
        System.out.println(" Guess the number between "+lowRange+ " and "+highRange);
        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        while (attempts < maxAttempts) 
        {
            System.out.print(" Enter your Guess... ");
            int guessNumber = sc.nextInt();
            attempts++;
            if (guessNumber > targetNumber) 
            {
                System.out.println(" Too High! ");
            } 
            else if (guessNumber < targetNumber) 
            {
                System.out.println(" Too Low! ");
            } 
            else 
            {
                System.out.println(" Congratulations! you guessed the number.... " + targetNumber + " in " + attempts);
                return attempts;
            }
        }
        System.out.println(" Your maximum attempts is over! The number was..... " + targetNumber);
        return 0;
    }

    public static void StartGame() 
    {
        Scanner sc = new Scanner(System.in);
        int totalAttempts = 0;
        int rounds = 0;
        while (true) 
        {
            rounds++;
            System.out.println("Round..." + rounds);
            int roundAttempts = gameRound();
            totalAttempts += roundAttempts;
            System.out.println(" Do you want to play another round ? (yes/no).....!  ");
            String playAgain = sc.next();
            if (!playAgain.equalsIgnoreCase("yes")) 
            {
                break;
            }
        }
        System.out.println(" GameOver! youPlayed " + rounds + " round and the total Attempts.... " + totalAttempts);
    }

    public static void main(String[] args) {
        NumberGame.StartGame();
    }
}
