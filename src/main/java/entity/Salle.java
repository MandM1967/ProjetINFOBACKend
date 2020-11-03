package entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String num_salle;
    private String emplacement_salle;
    private int capacite;
    @ManyToOne
    private Reservation resevation;
    @OneToMany(mappedBy = "salleconcernee")
    private List<Materiel> materieldispo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservation getResevation() {
        return resevation;
    }

    public void setResevation(Reservation resevation) {
        this.resevation = resevation;
    }

    public List<Materiel> getMaterieldispo() {
        return materieldispo;
    }

    public void setMaterieldispo(List<Materiel> materieldispo) {
        this.materieldispo = materieldispo;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getNum_salle() {
        return num_salle;
    }

    public void setNum_salle(String num_salle) {
        this.num_salle = num_salle;
    }

    public String getEmplacement_salle() {
        return emplacement_salle;
    }

    public void setEmplacement_salle(String emplacement_salle) {
        this.emplacement_salle = emplacement_salle;
    }



    public Salle() {
    }

}
