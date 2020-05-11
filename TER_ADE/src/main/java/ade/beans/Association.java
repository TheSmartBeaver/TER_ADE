package ade.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

public class Association {
    @Id
    private Integer id;
    @DBRef(lazy = true)
    private Metier metier;
    @DBRef(lazy = true)
    private Formation formation;

    public Association(Integer id, Metier metier, Formation formation) {
        this.id = id;
        this.metier = metier;
        this.formation = formation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
