package com.grupo2.gestaoProjeto.BackFormulario.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;


// Modelo relacionado aos avisos de pauta

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

public class NoticeDto {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String institution;
    @NotBlank
    private String phone;
    @NotBlank
    private String lgpd;

}
