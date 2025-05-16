package com.cloud.yagodev.pmanager.domain.entity;

import com.cloud.yagodev.pmanager.domain.model.ProjectStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_projeto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "nome", nullable = false, length = 80)
    private String name;

    @Column(name = "descricao", nullable = false, length = 200)
    private String description;

    @Column(name = "data_inicial", nullable = false)
    private LocalDate initialDate;

    @Column(name = "data_final", nullable = false)
    private LocalDate finalDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)//O padrão é EnumType.ORDINAL para exibir um valor numeral, com esse "EnumType.STRING" fica realmente o valor da string do meu ENUM;
    private ProjectStatus status;
}
