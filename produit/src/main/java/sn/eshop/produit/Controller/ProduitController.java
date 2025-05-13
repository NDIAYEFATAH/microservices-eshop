package sn.eshop.produit.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.eshop.produit.DTO.CategorieDTO;
import sn.eshop.produit.Model.Produitentity;
import sn.eshop.produit.Service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    private final ProduitService service;

    @GetMapping("/ping")
    public String ping() {
        return "Produit service is alive";
    }

    public ProduitController(ProduitService service) {
        this.service = service;
    }
    @Operation(summary = "Lister toutes les produits")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping
    public List<Produitentity> getAll() {
        return service.findAll();
    }
    @Operation(summary = "Obtenir un Produit par REF")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produit trouvée"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvée")
    })
    @GetMapping("/{ref}")
    public Produitentity getById(@PathVariable String ref) {
        return service.findById(ref).orElseThrow();
    }
    // Spring Gateway
    // eureka
    @Operation(summary = "Recherche de Produit")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produit trouvée"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvée")
    })
    @GetMapping("/search")
    public List<Produitentity> search(@RequestParam String keyword) {
        return service.search(keyword);
    }
    @Operation(summary = "Créer un nouveau produit")
    @ApiResponse(responseCode = "201", description = "Produit créée avec succès")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Produitentity produit) {
        if (service.existsById(produit.getReference())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Produit avec cette référence existe déjà");
        }
        Produitentity saved = service.save(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @Operation(summary = "Mettre à jour un Produit")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produit mise à jour"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvée")
    })
    @PutMapping("/{ref}")
    public Produitentity update(@PathVariable String ref, @RequestBody Produitentity produit) {
        produit.setReference(ref);
        return service.save(produit);
    }
    @Operation(summary = "Supprimer un Produit")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Produit supprimée"),
            @ApiResponse(responseCode = "404", description = "Produit non trouvée")
    })
    @DeleteMapping("/{ref}")
    public void delete(@PathVariable String ref) {
        service.delete(ref);
    }
    @Operation(summary = "Obtenir la catégorie d’un produit")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Catégorie trouvée"),
            @ApiResponse(responseCode = "404", description = "Produit ou catégorie non trouvée")
    })
    @GetMapping("/{ref}/categorie")
    public CategorieDTO getCategorie(@PathVariable String ref) {
        Produitentity produit = service.findById(ref).orElseThrow();
        return service.getCategorieForProduit(produit);
    }
}
