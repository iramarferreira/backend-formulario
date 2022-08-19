package com.grupo2.gestaoProjeto.BackFormulario.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


// Modelo relacionado aos avisos de pauta

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
// JPA
@Entity
@Table(name = "tb_notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String email;
    private String institution;
    private String phone;
    private String lgpd;
    private LocalDateTime created;
}
