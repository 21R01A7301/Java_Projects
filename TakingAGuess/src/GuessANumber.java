import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String play = "yes";
        while(play.equals("yes")){
            Random rand = new Random();
            int num = rand.nextInt(100);
            int guess = -1;
            int tries = 0;

            while (guess != num){
                System.out.println("Guess a number between 1 and 100: ");
                guess = sc.nextInt();
                tries++;
                if(guess == num){
                    System.out.println("Bravo!! You have guessed the number in only "+tries+" guesses");
                    System.out.println("Would you like to continue the game (Yes or No)?");
                    play = sc.next().toLowerCase();
                }
                else if(guess > num){
                    System.out.println("Your guess is too high. Try Again!!");
                }
                else {
                    System.out.println("Your guess is too low. Try Again!!");
                }
            }
        }
        sc.close();
    }
}
