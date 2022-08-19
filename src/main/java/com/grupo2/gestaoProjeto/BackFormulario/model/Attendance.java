package com.grupo2.gestaoProjeto.BackFormulario.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


// Modelo relacionado aos atendimentos

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
// JPA
@Entity
@Table(name = "tb_Attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String email;
    private String communication;
    private String phone;
    private String deadline;
    private String solicitation;
    private LocalDateTime created;

}
