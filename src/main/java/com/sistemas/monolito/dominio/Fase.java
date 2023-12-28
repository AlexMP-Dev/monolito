package com.sistemas.monolito.dominio;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Fase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 60)
    @NotBlank(message = "El nombre no debe estar en blanco")
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fase")
    private List<Asignacion> asignaciones;
}
