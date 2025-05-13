package sn.eshop.produit.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sn.eshop.produit.DTO.CategorieDTO;
import sn.eshop.produit.Dao.IProduitRepository;
import sn.eshop.produit.Model.Produitentity;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    private final IProduitRepository repo;
    private final RestTemplate restTemplate;

    public ProduitService(IProduitRepository repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }
    public List<Produitentity> findAll() {
        return repo.findAll();
    }

    public Optional<Produitentity> findById(String ref) {
        return repo.findById(ref);
    }

    public List<Produitentity> search(String keyword) {
        return repo.findByDesignationContainingIgnoreCase(keyword);
    }

    public Produitentity save(Produitentity produit) {
        return repo.save(produit);
    }
    public void delete(String ref) {
        repo.deleteById(ref);
    }

    public CategorieDTO getCategorieForProduit(Produitentity produit) {
        String url = "http://localhost:8080/api/categories/" + produit.getCategoryId();
        return restTemplate.getForObject(url, CategorieDTO.class);
    }

    public boolean existsById(String reference) {
        return repo.existsById(reference);
    }


}
