package com.SoudaApp.Hotel_Souda.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class LoginRequest {
    @NotBlank(message = "email est obligatoir")
    private String email;

    @NotBlank(message = "password est obligatoir")
    private String password;
}
