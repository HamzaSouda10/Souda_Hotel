package com.SoudaApp.Hotel_Souda.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User implements UserDetails {

    //clé primaire et valeure generée automatiquement (autoincrementé)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    //si le champ est vide ou seulement espace un message est apparut
    @NotBlank(message = "email is required")
    //chaque ligne est unique
    @Column(unique = true)
    private String email;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "phoneNumber is required")
    private String phoneNumber;

    @NotBlank(message = "password is required")
    private String password;

    private String role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> bookings=new ArrayList<>();

    //Cette méthode retourne les autorisations (rôles) de l'utilisateur, qui seront utilisées par Spring Security pour contrôler l'accès aux ressources.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    //Cette méthode retourne le nom d'utilisateur qui sera utilisé pour l'authentification.
    @Override
    public String getUsername() {
        return email;
    }

    //Ici, la méthode retourne toujours true, indiquant que le compte n'expire jamais.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //La méthode retourne true, indiquant que le compte n'est jamais verrouillé.
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //Ici, la méthode retourne toujours true, signifiant que le mot de passe n'expire jamais.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //cela signifie que le compte est toujours actif.
    @Override
    public boolean isEnabled() {
        return true;
    }
}
