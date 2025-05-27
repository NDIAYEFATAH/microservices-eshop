package com.example.authService.Dao;

import com.example.authService.Entity.Utilisateurentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class IUtilisateur extends JpaRepository<Utilisateurentity, Integer> {
}
