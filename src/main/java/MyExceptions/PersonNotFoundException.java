/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyExceptions;

/**
 *
 * @author Zahera
 */
public class PersonNotFoundException extends RuntimeException {

    private String searchedEmail;
    private int id;
    public PersonNotFoundException(String searchedEmail, String message) {
        super(message);
        this.searchedEmail = searchedEmail;
    }

    public PersonNotFoundException(String searchedEmail) {
        this.searchedEmail = searchedEmail;
    }

    public String getSearchedEmail() {
        return searchedEmail;
    }
    public PersonNotFoundException(int id, String message) {
        super(message);
        this.id=id;
    }

    public PersonNotFoundException(int id) {
        this.id=id;
    }

    public int getSearchedid() {
        return id;
    }
    
    //then add it to update person method
    //ask if its better to exception inside the method or in the login button code
    
}
