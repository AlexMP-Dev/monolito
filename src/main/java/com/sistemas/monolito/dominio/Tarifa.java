package com.sistemas.monolito.dominio;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 80)
    @NotBlank(message = "Debe ingresar una descripcion")
    private String descripcion;

    @Min(value = 0)
    private Double precio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarifa")
    private List<Orden> ordenes;
}
