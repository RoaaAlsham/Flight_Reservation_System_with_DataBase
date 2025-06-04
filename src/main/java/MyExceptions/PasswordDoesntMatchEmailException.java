/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyExceptions;

/**
 *
 * @author Zahera
 */  
public class PasswordDoesntMatchEmailException extends RuntimeException {
    private String askedEmail;
    private String enteredPassword;
    public PasswordDoesntMatchEmailException(String askedEmail,String enteredPassword){
        super("password: "+enteredPassword+" doesn't match this email: " +askedEmail);
        this.askedEmail= askedEmail;
        this.enteredPassword= enteredPassword;
    }

    public PasswordDoesntMatchEmailException() {
    }
    
    public String getAskedEmail(){
        return askedEmail;
    }

    public String getEnteredPassword() {
        return enteredPassword;
    }
}


