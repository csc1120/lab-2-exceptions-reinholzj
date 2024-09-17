/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Josiah Reinholz
 * Last Updated: 9/15/2024
 */
package reinholzj;

import java.util.Random;

/**
 * The Die class creates and rolls the dice to be returned to the driver
 */
public class Die {
    static final int MIN_SIDES = 2;
    static final int MAX_SIDES = 100;
    private Random rand = new Random();
    private int numSides;
    private int currentValue;

    /**
     * The die method creates a die with a number of sides and sets value to 0
     * @param numSides
     * @throws IllegalArgumentException the value of numSides must be between 2 and 100
     */
    public Die(int numSides){
        if(numSides < MIN_SIDES || numSides > MAX_SIDES){
            throw new IllegalArgumentException("Number of sides between 2 and 100");
        }
        this.numSides = numSides;
        this.currentValue = 0;

    }

    /**
     * The roll method sets the current value to a random int within the parameters
     */
    public void roll(){
        this.currentValue = (int) (Math.random() * numSides) + 1;
    }

    /**
     * The method checks if the die has been rolled, will throw a DieNotRolled Excrpetion if not
     * @return valuetoReturn
     * @throws DieNotRolledException for having Currentvalue set to 0
     */
    public int getCurrentValue(){
        if(currentValue == 0){
            throw new DieNotRolledException("Die has not been rolled");
        }
        int valuetoReturn = currentValue;
        currentValue = 0;
        return valuetoReturn;
    }
}