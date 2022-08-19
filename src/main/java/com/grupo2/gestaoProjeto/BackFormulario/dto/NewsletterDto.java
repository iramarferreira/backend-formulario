package com.grupo2.gestaoProjeto.BackFormulario.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

// Modelo para os formulários de newsletters

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode

public class NewsletterDto {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String profession;
    @NotBlank
    private String isWhatsApp;
    @NotBlank
    private String phone;
    @NotBlank
    private String lgpd;

}
