package sn.eshop.demo.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import sn.eshop.demo.Model.Categorieentity;
import sn.eshop.demo.Service.CategorieService;

import java.util.List;

@Tag(name = "API Categorie", description = "Gestion des catégories de produits")
@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    private final CategorieService service;

    public CategorieController(CategorieService service) {
        this.service = service;
    }

    @Operation(summary = "Lister toutes les catégories")
    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès")
    @GetMapping
    public List<Categorieentity> getAll() {
        return service.findAll();
    }

    @Operation(summary = "Obtenir une catégorie par ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Catégorie trouvée"),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée")
    })
    @GetMapping("/{id}")
    public Categorieentity getById(@PathVariable int id) {
        return service.findById(id).orElseThrow();
    }

    @Operation(summary = "Créer une nouvelle catégorie")
    @ApiResponse(responseCode = "201", description = "Catégorie créée avec succès")
    @PostMapping
    public Categorieentity create(@RequestBody Categorieentity categorie) {
        return service.save(categorie);
    }

    @Operation(summary = "Mettre à jour une catégorie")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Catégorie mise à jour"),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée")
    })
    @PutMapping("/{id}")
    public Categorieentity update(@PathVariable int id, @RequestBody Categorieentity categorie) {
        categorie.setId(id);
        return service.save(categorie);
    }

    @Operation(summary = "Supprimer une catégorie")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Catégorie supprimée"),
            @ApiResponse(responseCode = "404", description = "Catégorie non trouvée")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
