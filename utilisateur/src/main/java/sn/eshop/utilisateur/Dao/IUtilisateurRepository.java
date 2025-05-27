package sn.eshop.utilisateur.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.eshop.utilisateur.Model.Utilisateurentity;

import java.util.Optional;

@Repository
public interface IUtilisateurRepository extends JpaRepository<Utilisateurentity, Integer>{
    boolean existsByEmail(String email);
    Optional<Utilisateurentity> findByEmail(String email);
}
