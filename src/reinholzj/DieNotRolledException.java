/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Josiah Reinholz
 * Last Updated: 9/15/2024
 */
package reinholzj;

/**
 * Creates a custom exception for the dice not having yet been rolled
 */
public class DieNotRolledException extends RuntimeException {
    /**
     * The method call for the DieNotRolledException
     * @param message creates the error message for DieNotRolledException
     */
    public DieNotRolledException(String message){
        super(message);
    }
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}
