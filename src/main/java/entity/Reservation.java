package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int code_reservation;
    @OneToMany(mappedBy = "resevation")
    private List<Salle> salles;
    private Date date_resevation;
    @ManyToOne
    private ResponsableDepatement responsableDepatement;
    public int getCode_reservation() {
        return code_reservation;
    }

    public void setCode_reservation(int code_reservation) {
        this.code_reservation = code_reservation;
    }


    public Date getDate_resevation() {
        return date_resevation;
    }

    public void setDate_resevation(Date date_resevation) {
        this.date_resevation = date_resevation;
    }


    public Reservation() {
    }
}
