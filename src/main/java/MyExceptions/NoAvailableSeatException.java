package MyExceptions;

import models.Flight;

/**
 *
 * @author Zahera
 */
public class NoAvailableSeatException extends RuntimeException {

    private Flight flight;
    private int askedSeatNumber;
  

    public NoAvailableSeatException(Flight flight, int askedSeatNumber) {
        
        super("no available seat found for this flight, \n already remained seat count is : "
                + (flight.getFlightCapacity() - flight.getReservationCollection().size()) + "\n so asked seat number " + askedSeatNumber + " cannot be reserved");
        this.flight = flight;
        this.askedSeatNumber = askedSeatNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getAskedSeatNumber() {
        return askedSeatNumber;
    }

}
