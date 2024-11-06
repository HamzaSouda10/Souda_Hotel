package com.SoudaApp.Hotel_Souda.repository;

import com.SoudaApp.Hotel_Souda.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    Optional<Booking> findByBookingConfirmationCode(String confirmationCode);

}
