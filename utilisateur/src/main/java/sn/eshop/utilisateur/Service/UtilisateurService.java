package sn.eshop.utilisateur.Service;

import org.springframework.stereotype.Service;
import sn.eshop.utilisateur.Dao.IUtilisateurRepository;
import sn.eshop.utilisateur.Model.Utilisateurentity;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    private final IUtilisateurRepository repo;

    public UtilisateurService(IUtilisateurRepository repo) {
        this.repo = repo;
    }

    public List<Utilisateurentity> findAll() {
        return repo.findAll();
    }

    public Optional<Utilisateurentity> findById(int id) {
        return repo.findById(id);
    }
    public Utilisateurentity save(Utilisateurentity user) {
        return repo.save(user);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return repo.existsByEmail(email);
    }
}
