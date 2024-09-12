/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Josiah Reinholz
 * Last Updated: 9/11/2024
 */
package reinholzj;

public class DieNotRolledException extends Exception{
    public void getMessage(){
        System.out.println("Die is not rolled properly");
    }
}
