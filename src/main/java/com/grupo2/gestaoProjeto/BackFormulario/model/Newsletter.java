package com.grupo2.gestaoProjeto.BackFormulario.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

// Modelo para os formulários de newsletters

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
//
@Entity
@Table(name = "tb_newsletter")
public class Newsletter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String email;
    private String profession;
    private String isWhatsApp;
    private String phone;
    private String lgpd;
    private LocalDateTime created;
}
