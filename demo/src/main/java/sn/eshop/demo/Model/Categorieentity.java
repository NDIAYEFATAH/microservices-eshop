package sn.eshop.demo.Model;



import io.swagger.annotations.Api;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Api(tags = "API Categories")
@Entity
@Table(name = "categorie", schema = "public", catalog = "microservice_db")
public class Categorieentity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nom")
    private String nom;
    /*@OneToMany(mappedBy = "categorieByCategoryId")
    private Collection<Produitentity> produitsById;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorieentity that = (Categorieentity) o;

        if (id != that.id) return false;
        if (!Objects.equals(nom, that.nom)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }

    /*public Collection<Produitentity> getProduitsById() {
        return produitsById;
    }*/

    /*public void setProduitsById(Collection<Produitentity> produitsById) {
        this.produitsById = produitsById;
    }*/
}
