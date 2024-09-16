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

public class Driver {
    public static final int MIN_DICE = 2;
    public static final int MAX_DICE = 10;

    public static void main(String[] args){
        try{
            int[] input = getInput();
        }
    }
    private static int[] getInput(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try{
                System.out.println("Please enter the number of dice to roll, how many sides the dice have, and how many rolls to complete, separated with a space");
                System.out.println("Example: \"2 6 1000\"");
                System.out.print("Enter Configuration: ");
                String[] input = scanner.nextLine().trim().split(" ");
                if(input.length != 3){
                    throw new IllegalArgumentException("Expected 3 inputs, only received " + input.length);
                }
                int numDice = Integer.parseInt(input[0]);
                int numSides = Integer.parseInt(input[1]);
                int numRolls = Integer.parseInt(input[2]);

                if(numDice < MIN_DICE || numDice > MAX_DICE){
                    throw new IllegalArgumentException("Wrong number of dice: " + numDice);
                }
                return new int[]{numDice, numSides, numRolls};
            } catch(NumberFormatException e) {
                System.out.println("All inputs must be whole numbers");
            }
        }
    }

}