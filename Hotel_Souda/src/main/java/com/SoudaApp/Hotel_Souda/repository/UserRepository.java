package com.SoudaApp.Hotel_Souda.repository;

import com.SoudaApp.Hotel_Souda.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);

    //Cette méthode retourne un Optional<User> correspondant à l'email fourni. Optional est un conteneur qui peut contenir soit un objet User (s'il est trouvé), soit être vide (s'il n'y a aucun utilisateur avec cet email).
    Optional<User> findByEmail(String email);
}
