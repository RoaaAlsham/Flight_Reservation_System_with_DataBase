/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyExceptions;

/**
 *
 * @author Zahera
 */
public class InvalidEmailFormatException extends IllegalArgumentException{
     private String enteredEmail;
    private String username= "username";

    public InvalidEmailFormatException(String enteredEmail, String username) {
                 
        super("entered Email "+enteredEmail + " format is not valid.\n "
                + "what about trying this email address \n" +username+"@example.com");
        this.enteredEmail= enteredEmail;
        this.username= username;
                
       }

    public InvalidEmailFormatException(String enteredEmail) {
                 
        super("entered Email "+enteredEmail + " format is not valid.\n "
                + "what about trying this email address \n" +"username@example.com");
        this.enteredEmail= enteredEmail;        
       }

    public String getEnteredEmail() {
        return enteredEmail;
    }
    
}
