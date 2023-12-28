package com.sistemas.monolito.dominio;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente_orden"))
    private Cliente cliente;

    @Column(length = 60)
    @NotBlank(message = "Debe ingresar una descripcion")
    private String descripcion;

    @Positive
    @Max(value = 50)
    private Double largo;

    @Positive
    @Max(value = 20)
    private Double ancho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarifa_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_tarifa_orden"))
    private Tarifa tarifa;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaOrden;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrega;

    @Positive
    private Double costo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orden")
    public List<Asignacion> asignaciones;
}
