/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Zahera
 */
public class MyEntityController {
    
     private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.fsmvu_Flight_Reservation_FinalProject_jar_1.0-SNAPSHOTPU");
    // cannot be used again after closing
   
   
    public static EntityManager getEntityManager(){
        
         return emf.createEntityManager();
        
    
    }
    
    public static void endEntityFactoryUsage(){
        if(emf.isOpen()){
            emf.close();
        }
    }
}
