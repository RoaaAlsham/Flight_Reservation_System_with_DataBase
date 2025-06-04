
package UserInterface;

import java.util.List;
import javax.persistence.EntityManager;
import models.Flight;
import models.MyEntityController;
import models.Reservation;

/**
 *
 * @author Zahera
 */
public class Testing {
    public static void main(String[] args) {
        EntityManager em= MyEntityController.getEntityManager();
        Flight f = em.find(Flight.class, 10);
        List<Reservation> reservations= (List<Reservation>)f.getReservationCollection();
        for (Reservation reservation : reservations) {
            System.out.println(reservation.getReservationDate());
        }
        /*
        
✅ TL;DR
Action	Required?	Notes
flight.getReservationCollection().add(r)	❌ Not required	JPA will populate this automatically when reloaded from DB
Setting r.setFlightId(flight)	✅ Required	This sets up the DB-side FK relationship
Accessing .getReservationCollection()	✅ Must do it while EntityManager is open, unless eager-fetched
        */
        
        
    }
            
}
