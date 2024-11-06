package com.SoudaApp.Hotel_Souda.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//Cette annotation de Lombok génère automatiquement des méthodes de type getter, setter, toString, equals, et hashCode pour tous les champs de la classe.
@Data
//Cette annotation, venant de la bibliothèque Jackson, permet d'exclure les champs null lorsque l'objet UserDTO est converti en JSON. Cela signifie que, si un champ n'a pas de valeur (il est null), il ne sera pas inclus dans la réponse JSON envoyée au client.
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String role;
    private List<BookingDto> bookings = new ArrayList<>();
}


