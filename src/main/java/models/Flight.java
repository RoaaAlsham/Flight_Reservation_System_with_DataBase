
package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author Zahera
 */
@Entity
@Table(name = "flight")
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f"),
    @NamedQuery(name = "Flight.findByIdflight", query = "SELECT f FROM Flight f WHERE f.idflight = :idflight"),
    @NamedQuery(name = "Flight.findByFlightCapacity", query = "SELECT f FROM Flight f WHERE f.flightCapacity = :flightCapacity"),
    @NamedQuery(name = "Flight.findByDepartureDateTime", query = "SELECT f FROM Flight f WHERE f.departureDateTime = :departureDateTime"),
    @NamedQuery(name = "Flight.findBySeatPrice", query = "SELECT f FROM Flight f WHERE f.seatPrice = :seatPrice")})
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idflight")
    private Integer idflight;

    @Basic(optional = false)
    @Column(name = "flightCapacity")
    private int flightCapacity;

    @Basic(optional = false)
    @Column(name = "departureDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDateTime;

    @Basic(optional = false)
    @Column(name = "seatPrice")
    private float seatPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seatFlightId")
    private Collection<Seat> seatCollection;

    @JoinColumn(name = "destinationAirport", referencedColumnName = "idAirport")
    @ManyToOne(optional = false)
    private Airport destinationAirport;

    @JoinColumn(name = "originAirport", referencedColumnName = "idAirport")
    @ManyToOne(optional = false)
    private Airport originAirport;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flightId")
    private Collection<Reservation> reservationCollection;

    public Flight() {
        
    }

    public Flight(Integer idflight, int flightCapacity, Date departureDateTime, float seatPrice) {
        this.idflight = idflight;
        this.flightCapacity = flightCapacity;
        this.departureDateTime = departureDateTime;
        this.seatPrice = seatPrice;
     
    }
    
    public Flight( int flightCapacity, Date departureDateTime, float seatPrice) {
        
        this.flightCapacity = flightCapacity;
        this.departureDateTime = departureDateTime;
        this.seatPrice = seatPrice;
     
    }

    public Integer getIdflight() {
        return idflight;
    }

    public void setIdflight(Integer idflight) {
        this.idflight = idflight;
    }

    public int getFlightCapacity() {
        return flightCapacity;
    }

    public void setFlightCapacity(int flightCapacity) {
        this.flightCapacity = flightCapacity;

    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public float getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(float seatPrice) {
        this.seatPrice = seatPrice;
    }

    public Collection<Seat> getSeatCollection() {
        return seatCollection;
    }

    public void setSeatCollection(Collection<Seat> seatCollection) {
        this.seatCollection = seatCollection;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Airport getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(Airport originAirport) {
        this.originAirport = originAirport;
    }

    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idflight != null ? idflight.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.idflight == null && other.idflight != null) || (this.idflight != null && !this.idflight.equals(other.idflight))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Flight[ idflight=" + idflight + " ]";
    }

    public int calculateAvailableSeats() {
        EntityManager em = MyEntityController.getEntityManager();
        try {
            TypedQuery<Long> q = em.createQuery("SELECT COUNT(s) FROM Seat s WHERE s.seatFlightId = :flight AND s.isAvailable = 1", Long.class);
            q.setParameter("flight", this);
            return q.getSingleResult().intValue();
        } finally {
            em.close();
        }
    }

}
