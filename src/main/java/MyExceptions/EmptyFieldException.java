/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyExceptions;

/**
 *
 * @author Zahera
 */
public class EmptyFieldException extends IllegalArgumentException {

    public EmptyFieldException(String fieldName) {
        super("invalid empty field : \n"
                + fieldName + "is empty");
    }

}