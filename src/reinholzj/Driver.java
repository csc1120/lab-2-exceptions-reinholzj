/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Josiah Reinholz
 * Last Updated: 9/15/2024
 */
package reinholzj;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The driver class takes and displays the input for rolling dice
 */
public class Driver {
    static final int NUM = 10;
    static final int MIN_DICE = 2;
    static final int MAX_DICE = 10;

    public static void main(String[] args){
        while(true){
            try{
                int[] input = getInput();
                int numDice = input[0];
                int numSides = input[1];
                int numRolls = input[2];
                Die[] dice = createDice(numDice, numSides);
                int[] rolls = rollDice(dice, numSides, numRolls);
                int max = findMax(rolls);
                report(max, rolls, numDice);
            } catch(IllegalArgumentException e) {
                System.out.println("Unable to create dice: Illegal Argument");
            } catch(InputMismatchException e){
                System.out.println("All inputs must be whole numbers: Invalid Input ");
            } catch(DieNotRolledException e){
                System.out.println("Die Not Rolled");
            }
        }
    }
    private static int[] getInput(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try{
                System.out.println("Please enter the number of dice to roll, " +
                        "how many sides the dice have,");
                System.out.println("and how many rolls to complete, separated with a space");
                System.out.println("Example: \"2 6 1000\"");
                System.out.print("Enter Configuration: ");
                String[] input = scanner.nextLine().trim().split(" ");
                if(input.length != 3){
                    throw new IllegalArgumentException("Expected 3 inputs, only received "
                            + input.length);
                }
                int numDice = Integer.parseInt(input[0]);
                int numSides = Integer.parseInt(input[1]);
                int numRolls = Integer.parseInt(input[2]);

                if(numDice < MIN_DICE || numDice > MAX_DICE){
                    throw new IllegalArgumentException("Wrong number of dice: " + numDice);
                }
                return new int[] {numDice, numSides, numRolls};
            } catch(NumberFormatException e) {
                System.out.println("All inputs must be whole numbers");
            }
        }
    }
    private static Die[] createDice(int numSides, int numDice){
        Die[] dice = new Die[numSides];
        for(int i = 0; i < numSides; i++){
            dice[i] = new Die(numSides);
        }
        return dice;
    }

    /**
     * The rollDice() finds the total value by calling the roll and getCurrentvalue
     * @param dice
     * @param numSides
     * @param numRolls
     * @return rollResults the total minus the number of dice
     */
    public static int[] rollDice(Die[] dice, int numSides, int numRolls){
        int[] rollResults = new int[numSides * dice.length - dice.length + 1];
        try{
            for (int i = 0; i < numRolls; i++) {
                int total = 0;
                for (Die die : dice) {
                    die.roll();
                    total += die.getCurrentValue();
                }
                rollResults[total - dice.length]++;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indexing Failed: Array out of bounds");
        }
        return rollResults;
    }

    private static int findMax(int[] rolls){
        int max = 0;
        for(int roll : rolls){
            if(roll > max){
                max = roll;
            }
        }
        return max;
    }
    private static void report(int max, int[] rolls, int numDice){
        int scale = max / NUM;
        if(scale == 0){
            scale = 1;
        }
        for(int i = 0; i < rolls.length; i++){
            int numStars = rolls[i] / scale;
            System.out.printf("%2d: %5d\t%s%n", i + numDice, rolls[i], "*".repeat(numStars));
        }
    }

}