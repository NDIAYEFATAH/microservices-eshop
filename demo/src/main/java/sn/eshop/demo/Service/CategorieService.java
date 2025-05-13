package sn.eshop.demo.Service;

import org.springframework.stereotype.Service;
import sn.eshop.demo.Dao.ICategorieRepository;
import sn.eshop.demo.Model.Categorieentity;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    private final ICategorieRepository repo;

    public CategorieService(ICategorieRepository repo) {
        this.repo = repo;
    }

    public List<Categorieentity> findAll() {
        return repo.findAll();
    }

    public Optional<Categorieentity> findById(int id) {
        return repo.findById(id);
    }

    public Categorieentity save(Categorieentity categorie) {
        return repo.save(categorie);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
