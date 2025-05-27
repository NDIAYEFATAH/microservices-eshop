package sn.eshop.utilisateur.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.eshop.utilisateur.Model.Utilisateurentity;
import sn.eshop.utilisateur.Security.AuthRequest;
import sn.eshop.utilisateur.Security.AuthResponse;
import sn.eshop.utilisateur.Security.JwtUtil;
import sn.eshop.utilisateur.Service.UtilisateurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService service;
    private final JwtUtil jwtUtil;
    @GetMapping("/ping")
    public String ping() {
        return "Utilisateur service is alive";
    }

    public UtilisateurController(UtilisateurService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping
    public List<Utilisateurentity> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateurentity> getById(@PathVariable int id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "Créer un utilisateur")
    @ApiResponse(responseCode = "201", description = "Utilisateur créée avec succès")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Utilisateurentity user) {
        if (service.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email déjà utilisé");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateurentity> update(@PathVariable int id, @RequestBody Utilisateurentity user) {
        user.setId(id);
        return ResponseEntity.ok(service.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/token")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest request) {
        Optional<Utilisateurentity> user = service.findByEmail(request.getEmail());
        if (user != null && user.getClass().equals(request.getMotDePasse())) {
            String token = jwtUtil.generateToken(String.valueOf(user.getClass().equals(request.getMotDePasse())));
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Email ou mot de passe invalide");
        }
    }
}
