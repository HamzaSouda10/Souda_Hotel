package com.SoudaApp.Hotel_Souda.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    // Représente le code de statut de la réponse HTTP, comme 200 pour succès ou 404 pour ressource non trouvée. Il aide le client à comprendre l'état de la requête.
    private int statusCode;
    //Contient un message descriptif de la réponse, comme "Succès", "Échec" ou un message d'erreur spécifique. Cela est utile pour fournir des détails explicatifs sur la réponse.
    private String message;

    //Contient le jeton d'authentification, souvent un JWT (JSON Web Token), permettant au client de s'authentifier lors de futures requêtes.
    private String token;
    //Indique le rôle de l'utilisateur, par exemple "admin" ou "utilisateur". Ce champ est important pour gérer les autorisations et les droits d'accès.
    private String role;
    // Définit l'heure d'expiration du token ou de la session, ce qui permet au client de savoir quand il devra réauthentifier.
    private String expirationTime;
    private String bookingConfirmationCode;

    private UserDto userDto;
    private RoomDto roomDto;
    private BookingDto bookingDto;
    private List<UserDto> userDtoList;
    private List<RoomDto> roomDtoList;
    private List<BookingDto> bookingDtoList;

}
