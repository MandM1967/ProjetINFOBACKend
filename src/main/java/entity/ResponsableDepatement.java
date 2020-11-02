package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ResponsableDepatement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String nom;
    private String prenom;
    private String numtel;
    private String Password_responsabledepartement;
    @OneToMany(mappedBy = "responsableDepatement")
    private List<Reservation> reservations;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public ResponsableDepatement() {
    }

    public ResponsableDepatement(Long id, String email, String nom, String prenom, String numtel, List<Reservation> reservations) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.numtel = numtel;
        this.reservations = reservations;
    }
}
