package sn.eshop.produit.Model;



import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produit", schema = "public", catalog = "microservice_db")
public class Produitentity {
    @Id
    @Column(name = "reference")
    private String reference;
    @Basic
    @Column(name = "designation")
    private String designation;
    @Basic
    @Column(name = "prix")
    private BigDecimal prix;
    @Basic
    @Column(name = "quantite")
    private int quantite;
    @Basic
    @Column(name = "category_id")
    private Integer categoryId;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produitentity that = (Produitentity) o;

        if (quantite != that.quantite) return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;
        if (prix != null ? !prix.equals(that.prix) : that.prix != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reference != null ? reference.hashCode() : 0;
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        result = 31 * result + quantite;
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        return result;
    }
}
