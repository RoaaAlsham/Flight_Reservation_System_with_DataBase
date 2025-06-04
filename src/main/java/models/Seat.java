/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Zahera
 */
@Entity
@Table(name = "seat")
@NamedQueries({
    @NamedQuery(name = "Seat.findAll", query = "SELECT s FROM Seat s"),
    @NamedQuery(name = "Seat.findByIdseat", query = "SELECT s FROM Seat s WHERE s.idseat = :idseat"),
    @NamedQuery(name = "Seat.findByIsAvailable", query = "SELECT s FROM Seat s WHERE s.isAvailable = :isAvailable")})
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idseat")
    private Integer idseat;
    
    @Basic(optional = false)
    @Column(name = "isAvailable")
    private short isAvailable;

  
    
    @JoinColumn(name = "seatFlightId", referencedColumnName = "idflight")
    @ManyToOne(optional = false)
    private Flight seatFlightId;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "seatId")
    private Reservation reservation;

    public Seat() {
    }

    public Seat(Integer idseat) {
        this.idseat = idseat;
    }

    public Seat(Integer idseat, short isAvailable) {
        this.idseat = idseat;
        this.isAvailable = isAvailable;
    }

    public Integer getIdseat() {
        return idseat;
    }

    public void setIdseat(Integer idseat) {
        this.idseat = idseat;
    }

    public short getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(short isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Flight getSeatFlightId() {
        return seatFlightId;
    }

    public void setSeatFlightId(Flight seatFlightId) {
        this.seatFlightId = seatFlightId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idseat != null ? idseat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seat)) {
            return false;
        }
        Seat other = (Seat) object;
        if ((this.idseat == null && other.idseat != null) || (this.idseat != null && !this.idseat.equals(other.idseat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Seat[ idseat=" + idseat + " ]";
    }
    
}
