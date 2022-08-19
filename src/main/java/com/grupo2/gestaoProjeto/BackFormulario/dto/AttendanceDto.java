package com.grupo2.gestaoProjeto.BackFormulario.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;


// Modelo relacionado aos atendimentos

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode

public class AttendanceDto {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String communication;
    @NotBlank
    private String phone;
    @NotBlank
    private String deadline;
    @NotBlank
    private String solicitation;


}
