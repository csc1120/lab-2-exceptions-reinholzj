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
    Random rand = new Random();
    private int numsides;
    private int currentValue;

    public void Die(int numsides){
        if(numsides < 2 || numsides > 100){
            throw new IllegalArgumentException("Number of sides between 2 and 100");
        }
        this.numsides = numsides;
    }
    public void roll(){
        this.currentValue = (int) (Math.random() * numsides) + 1;
    }
    public int getCurrentValue(){
        if(currentValue < 1 || currentValue > numsides){
            throw new IllegalStateException("Current value is not in the expected range of the die");
        }
        int valuetoReturn = currentValue;
        currentValue =0;
        return valuetoReturn;
    }
}