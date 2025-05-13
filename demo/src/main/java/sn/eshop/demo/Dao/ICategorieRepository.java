package sn.eshop.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.eshop.demo.Model.Categorieentity;

@Repository
public interface ICategorieRepository extends JpaRepository<Categorieentity, Integer> {
}
