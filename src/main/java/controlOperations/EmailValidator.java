/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlOperations;

import MyExceptions.InvalidEmailFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Zahera
 */
public class EmailValidator {
        private EmailValidator(){}//The class can only be used via its static methods (EmailValidator.validateFormat()).
        private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";//email validation 
        private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);
        
        public static boolean isValid(String email) throws InvalidEmailFormatException{
            
        Matcher matcher= pattern.matcher(email);
        
        return matcher.matches();
        }
}
    