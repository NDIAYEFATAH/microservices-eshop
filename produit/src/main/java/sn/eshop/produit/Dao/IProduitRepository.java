package sn.eshop.produit.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.eshop.produit.Model.Produitentity;

import java.util.List;

@Repository
public interface IProduitRepository extends JpaRepository<Produitentity, String> {
    List<Produitentity> findByDesignationContainingIgnoreCase(String keyword);
}
