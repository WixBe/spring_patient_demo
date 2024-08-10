package com.ust.patient_demo.dto;

import com.ust.patient_demo.domain.Illness;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

public record PatientDto(

        long id,

        @NotEmpty(message = "Name is required")
        @Pattern(regexp = "^[a-zA-Z\\s]{3,20}$", message = "Name should only contain letters and blank spaces, and be between 3 and 20 characters long")
        String fullName,

        @NotEmpty(message = "Email is required")
        @Email(message = "Invalid email")
        String email,

        @NotEmpty(message = "phone is required")
        @Pattern(regexp = "^//+?[0-9]{1,3}//s?[0-9]{10}", message = "Phone number is invalid")
        String phone,

        @NotEmpty(message = "Date of birth required")
        @Past(message = "Date of birth must be a past date")
        LocalDate dob,

        @NotEmpty(message = "Address is required")
        String address,

        List<Illness> illnesses
) {
}
