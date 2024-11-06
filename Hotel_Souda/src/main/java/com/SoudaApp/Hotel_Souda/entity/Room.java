package com.SoudaApp.Hotel_Souda.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String roomType;

    private BigDecimal roomPrice;

    private String roomPhotoUrl;

    private String roomDescription;

    //@onetomany cela signifie qu'une Room peut être associée à plusieurs Booking .Ici, mappedBy = "room" indique que l'attribut room dans la classe Booking est le propriétaire de la relation. Cela signifie que c'est dans Booking que le lien est défini, et la table correspondante contiendra la clé étrangère pour Room.FetchType.LAZY indique que les données associées (ici les Booking) ne sont chargées que lorsque cela est nécessaire. Par exemple, si vous interrogez une Room, ses Booking ne seront pas automatiquement chargés dans l'objet Room, mais uniquement lorsqu'on accède spécifiquement à bookings.cascade = CascadeType.ALL Par exemple, si une Room est supprimée, tous ses Booking associés seront également supprimés.
    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> bookings =new ArrayList<>();

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomType='" + roomType + '\'' +
                ", roomPrice=" + roomPrice +
                ", roomPhotoUrl='" + roomPhotoUrl + '\'' +
                ", roomDescription='" + roomDescription + '\'' +
                '}';
    }


}
