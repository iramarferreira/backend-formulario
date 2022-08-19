package com.grupo2.gestaoProjeto.BackFormulario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

// Modelo relacionado aos credenciamentos

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AccreditationDto {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String role;
    @NotBlank
    private String communication;
    @NotBlank
    private String rg;
    @NotBlank
    private String cpf;
    @NotBlank
    private String phone;

}
