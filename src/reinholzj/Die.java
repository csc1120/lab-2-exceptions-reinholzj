/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Josiah
 * Last Updated: Reinholz
 */
package reinholzj;

import java.io.IOException;
import java.util.Random;

public class Die {
    public static final int MIN_SIDES = 2;
    public static final int MAX_SIDES = 100;
    Random rand = new Random();
    private int numSides;
    private int currentValue;

    public void Die(int numSides){
        if(numSides < MIN_SIDES || numSides > MAX_SIDES){
            throw new IllegalArgumentException("Number of sides between 2 and 100");
        }
        this.numSides = numSides;
        this.currentValue = 0;

    }
    public void roll(){
        this.currentValue = (int) (Math.random() * numSides) + 1;
    }
    public int getCurrentValue(){
        if(currentValue == 0){
            throw new DieNotRolledException("Die has not been rolled");
        }
        int valuetoReturn = currentValue;
        currentValue =0;
        return valuetoReturn;
    }
}