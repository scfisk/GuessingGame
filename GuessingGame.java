//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.sun.tools.javac.Main;

import java.util.Scanner;

public class GuessingGame {

    static int GetInteger() {
        Scanner scn = new Scanner(System.in);
        return scn.nextInt();
    }

    static int GenerateRandomNumber(int min, int max) {
        return (int)(Math.random() * max) + min;
    }

    static int GetGuess() {
        System.out.println("Type your guess: ");
        return GetInteger();
    }

    static boolean IsCorrect(int target, int guess) {
        if (guess > target) {
            System.out.println("Incorrect. Too high!");
            return false;
        }
        else if (guess < target) {
            System.out.println("Incorrect. Too low!");
            return false;
        }
        else {
            System.out.println( "Correct!");
            return true;
        }
    }

    static String GetHint(int hintNumber) {
        return switch (hintNumber) {
            case 0 -> "Too high!";
            case 1 -> "Too low!";
            default -> "No hint!";
        };

    }

    static int MainMenuOptions(){
        System.out.println("Welcome to Guess the Number! Please select and option:");
        System.out.println("1 - Play Game");
        System.out.println("2 - See Instructions");
        System.out.println("3 - Quit Game");
        return GetInteger();
    }


    static void PlayGame() {
        int target = GenerateRandomNumber(1,100);
        int i = 0;
        boolean isPlaying = true;
        while (isPlaying && (i < 8)) {
            int guess = GetGuess();
            boolean isCorrect = IsCorrect(target,guess);
            if (isCorrect)
                isPlaying = false;
            else
                i++;
        }
        if (i == 8){
            System.out.println("All out of guesses!");
        }
    }

    static void DisplayInstructions(){
        System.out.println("The computer will generate a random, positive number between 1 and 100. " +
                "You will then have 8 tries to guess the number correctly. After each guess you'll be given " +
                "the option to guess again, or receive a hint. The hint will tell you whether your guess was" +
                "too high or too low. Those hints can really come in handy!");
    }

    static void EndGame(){
        System.out.println("Goodbye!");
        System.exit(0);
    }


    public static void main(String[] args) {
        boolean keepGoing = true;
        while (keepGoing) {
            int choice = MainMenuOptions();
            switch (choice) {
                case 1:
                    PlayGame();
                    break;
                case 2:
                    DisplayInstructions();
                    break;
                case 3:
                    keepGoing = false;
                    EndGame();
                    break;
            }
        }

    }
}
