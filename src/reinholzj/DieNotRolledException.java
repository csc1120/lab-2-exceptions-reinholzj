/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Josiah Reinholz
 * Last Updated: 9/11/2024
 */
package reinholzj;

public class DieNotRolledException extends RuntimeException{
    public DieNotRolledException(String message){
        super(message);
    }
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}
