package sn.eshop.utilisateur.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.eshop.utilisateur.Model.Utilisateurentity;
import sn.eshop.utilisateur.Service.UtilisateurService;
import sn.eshop.utilisateur.Security.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UtilisateurService utilisateurService;
    private final JwtUtil jwtUtil;

    public AuthController(UtilisateurService utilisateurService, JwtUtil jwtUtil) {
        this.utilisateurService = utilisateurService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Utilisateurentity user) {
        if (utilisateurService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email déjà utilisé");
        }
        Utilisateurentity savedUser = utilisateurService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    /*@PostMapping("/token")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest request) {
        Optional<Utilisateurentity> user = utilisateurService.findByEmail(request.getEmail());
        if (user != null && user.getClass().equals(request.getMotDePasse())) {
            String token = jwtUtil.generateToken(String.valueOf(user.getClass().equals(request.getMotDePasse())));
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Email ou mot de passe invalide");
        }
    }*/
}
