package com.ust.patient_demo.dto;

import jakarta.validation.constraints.NotEmpty;

public record IllnessDto(

        long id,

        @NotEmpty(message = "Illness term is required")
        String illnessTerm
) {

}
