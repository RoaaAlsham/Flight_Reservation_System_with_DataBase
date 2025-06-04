/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Zahera
 */
@Entity
@Table(name = "airport")
@NamedQueries({
    @NamedQuery(name = "Airport.findAll", query = "SELECT a FROM Airport a"),
    @NamedQuery(name = "Airport.findByIdAirport", query = "SELECT a FROM Airport a WHERE a.idAirport = :idAirport"),
    @NamedQuery(name = "Airport.findByAirportName", query = "SELECT a FROM Airport a WHERE a.airportName = :airportName"),
    @NamedQuery(name = "Airport.findByCity", query = "SELECT a FROM Airport a WHERE a.city = :city")})
public class Airport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAirport")
    private Integer idAirport;
    @Basic(optional = false)
    @Column(name = "airportName")
    private String airportName;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destinationAirport")
    private Collection<Flight> flightDestinationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "originAirport")
    private Collection<Flight> flightOriginCollection;

    public Airport() {
    }

    public Airport(Integer idAirport) {
        this.idAirport = idAirport;
    }

    public Airport(Integer idAirport, String airportName, String city) {
        this.idAirport = idAirport;
        this.airportName = airportName;
        this.city = city;
    }

    public Integer getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(Integer idAirport) {
        this.idAirport = idAirport;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Collection<Flight> getFlightDestinationCollection() {
        return flightDestinationCollection;
    }

    public void setFlightDestinationCollection(Collection<Flight> flightDestinationCollection) {
        this.flightDestinationCollection = flightDestinationCollection;
    }

    public Collection<Flight> getFlightOriginCollection() {
        return flightOriginCollection;
    }

    public void setFlightOriginCollection(Collection<Flight> flightOriginCollection) {
        this.flightOriginCollection = flightOriginCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAirport != null ? idAirport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airport)) {
            return false;
        }
        Airport other = (Airport) object;
        if ((this.idAirport == null && other.idAirport != null) || (this.idAirport != null && !this.idAirport.equals(other.idAirport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ "+idAirport+" ] "+airportName+"{"+city+"}";
    }
    
}
