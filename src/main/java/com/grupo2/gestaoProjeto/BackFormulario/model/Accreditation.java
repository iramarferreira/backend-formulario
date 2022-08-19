package com.grupo2.gestaoProjeto.BackFormulario.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

// Modelo relacionado aos credenciamentos

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// JPA
@Entity
@Table(name = "tb_accreditation")
public class Accreditation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String email;
    private String role;
    private String communication;
    private String rg;
    private String cpf;
    private String phone;
    private LocalDateTime created;
}
