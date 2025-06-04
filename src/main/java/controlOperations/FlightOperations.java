package controlOperations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import models.Airport;
import models.Flight;
import models.MyEntityController;
import models.Person;
import models.Reservation;
import models.Seat;

/**
 *
 * @author Zahera
 */
public class FlightOperations {

    public static List<Flight> getAllFlights() {
        EntityManager em = MyEntityController.getEntityManager();
        try {

            TypedQuery<Flight> q = em.createQuery("SELECT f FROM Flight f", Flight.class);
            List<Flight> ls = q.getResultList();
            return ls;
        } finally {
            em.close();
        }
    }

    public static Flight createFlight(EntityManager em, Airport originAirport, Airport destinationAirport,
            int flightCapacity, Date departureDateTime, float seatPrice) {

        Flight f = new Flight(flightCapacity, departureDateTime, seatPrice);
        f.setDestinationAirport(destinationAirport);
        f.setOriginAirport(originAirport);

        em.persist(f);
        List<Seat> seatlist = new ArrayList<>();

        for (int i = 0; i < flightCapacity; i++) {
            Seat s = new Seat();
            s.setIsAvailable((short) 1);
            s.setSeatFlightId(f);
            seatlist.add(s);
            em.persist(s);
        }
        f.setSeatCollection(seatlist);

        return f;

    }

    public static Flight updateFlight(EntityManager em, Flight f, Airport originAirport, Airport destinationAirport,
            int flightCapacity, Date departureDateTime, float seatPrice) {

        int addedSeats = flightCapacity - f.getFlightCapacity();
        f.setFlightCapacity(flightCapacity);
        f.setDepartureDateTime(departureDateTime);
        f.setOriginAirport(originAirport);
        f.setDestinationAirport(destinationAirport);
        f.setSeatPrice(seatPrice);
        for (int i = 0; i < addedSeats; i++) {
            Seat s = new Seat();
            s.setIsAvailable((short) 1);
            s.setSeatFlightId(f);
            f.getSeatCollection().add(s);
            em.persist(s);
        }

        return f;

    }

    public static List<Flight> getFlights_From_TO(Airport origin, Airport destination) {

        EntityManager em = MyEntityController.getEntityManager();
        try {
            
            Query q = em.createQuery("Select f From Flight f where f.originAirport = :origin and f.destinationAirport=:destination");
            q.setParameter("origin", origin);
            q.setParameter("destination", destination);
            
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public static List<Airport> get_All_Airtports() {
        EntityManager em = MyEntityController.getEntityManager();
        try {

            TypedQuery<Airport> q = em.createQuery("SELECT a FROM Airport a", Airport.class);
            List<Airport> ls = q.getResultList();
            return ls;
        } finally {
            em.close();
        }

    }

    public static Airport getAirportByAirportName(String airportName) {

        EntityManager em = MyEntityController.getEntityManager();
        try {

            TypedQuery<Airport> q = em.createQuery("SELECT a FROM Airport a where a.airportName= :airportName", Airport.class);
            q.setParameter("airportName", airportName);
            List<Airport> ls = q.getResultList();
            if (ls.isEmpty()) {
                return null;
            }
            return ls.get(0);
        } finally {
            em.close();
        }

    }

    public static Airport addAiport(EntityManager em, String name, String city) {

        Airport a = new Airport();
        a.setAirportName(name);
        a.setCity(city);
        em.persist(a);

        return a;

    }

    public static void updateAirport(EntityManager em, Airport a, String name, String city) {
        a.setAirportName(name);
        a.setCity(city);
    }

    public static void makeReservation(EntityManager em, Flight flight, Person person, Seat seat, Date reservationDate) {

        em.getTransaction().begin();
        Reservation r = new Reservation();
        r.setFlightId(flight);
        r.setPassengerId(person);
        r.setSeatId(seat);
        r.setReservationDate(reservationDate);
        seat.setIsAvailable((short) 0);
        person.getReservationCollection().add(r);
        flight.getReservationCollection().add(r);
        em.persist(r);
        em.getTransaction().commit();

    }

    public static void removeReservation(EntityManager em, Reservation r) {

        em.getTransaction().begin();
        Seat s = em.find(Seat.class, r.getSeatId().getIdseat());
        s.setIsAvailable((short) 1);
        Person p = em.find(Person.class, r.getPassengerId().getIdperson());
        Flight f = em.find(Flight.class, r.getFlightId().getIdflight());
        p.getReservationCollection().remove(r);
        f.getReservationCollection().remove(r);
        em.remove(r);
        em.getTransaction().commit();
    }

    public static Seat getAvailableSeat(Flight f) {
        List<Seat> seats = (List<Seat>) f.getSeatCollection();
        for (Seat seat : seats) {
            if (seat.getIsAvailable() == 1) {
                return seat;
            }
        }
        return null;
    }

    public static List<Reservation> getAllReservations() {
        EntityManager em = MyEntityController.getEntityManager();
        try {
            TypedQuery<Reservation> query = em.createQuery("Select r from Reservation r ", Reservation.class);

            return query.getResultList();
        } finally {
            em.close();
        }

    }

    public static List<Reservation> getReservationsForPerson(Person p) {
        EntityManager em = MyEntityController.getEntityManager();
        try {
            TypedQuery<Reservation> query = em.createQuery("SELECT r FROM Reservation r WHERE r.passengerId = :person", Reservation.class);
            //Syntax error parsing [Select r From Reservation r where r.passengerId = :p].
            //in JPQL, there must be no space between the colon (:) and the parameter name.
            query.setParameter("person", p);

            return query.getResultList();
        } finally {
            em.close();
        }
        /*
        r.passengerId → a Person object

        :pId → an int (the person's ID)
         */
    }
}
