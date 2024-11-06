package com.SoudaApp.Hotel_Souda.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //ce champ ne doit pas etre vide
    @NotNull(message = "champ obligatoire")
    private LocalDate checkInDate;

    //Cette contrainte de validation spécifie que la date de départ (checkOutDate) doit être dans le futur par rapport à la date actuelle.
    @Future(message = "Cette date de depart doit obligatoirement etre en future")
    private LocalDate checkOutDate;

    //Cette contrainte de validation indique que la valeur minimale pour numOfAdults (nombre d'adultes) doit être au moins 1
    @Min(value = 1,message = "le nombre d'adulte doit etre au moins 1")
    private int numOfAdults;

    @Min(value =0,message = "Le nombre de enfant doit etre au moins 0")
    private int numOfChildren;

    private int totalNumOfGuest;

    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    //@ManyToOne : Cette annotation indique qu'il existe une relation de plusieurs Booking pour un seul User. Autrement dit, un utilisateur peut avoir plusieurs réservations, mais chaque réservation est associée à un seul utilisateur.
    @ManyToOne(fetch = FetchType.LAZY)
    //Dans l'entité Booking, la colonne user_id est la clé étrangère qui relie chaque réservation (Booking) à un utilisateur (User).La table Booking ne contient pas toutes les informations de User mais uniquement la clé étrangère user_id, qui référence l'entité User. Cette clé étrangère permet de créer une relation entre Booking et User sans dupliquer les données de User.
    @JoinColumn(name = "user_id")
    private User user;


    public void calculateTotalNumOfGuest(){
        this.totalNumOfGuest=this.numOfAdults+this.numOfChildren;

    }

    public void setNumOfChildren(int numOfChildren){
        this.numOfChildren=numOfChildren;
        calculateTotalNumOfGuest();
    }

    public void setNumOfAdults(int numOfAdults){
        this.numOfAdults=numOfAdults;
        calculateTotalNumOfGuest();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numOfAdults=" + numOfAdults +
                ", numOfChildren=" + numOfChildren +
                ", totalNumOfGuest=" + totalNumOfGuest +
                ", bookingConfirmationCode='" + bookingConfirmationCode + '\'' +
                '}';
    }


}
