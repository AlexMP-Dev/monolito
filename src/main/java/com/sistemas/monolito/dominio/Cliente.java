package com.sistemas.monolito.dominio;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 60)
    @NotBlank(message = "El nombre no debe estar en blanco")
    private String nombre;

    @Column(length = 8)
    @NotBlank(message = "El dni no debe estar en blanco")
    private String dni;

    @Column(length = 60)
    @NotBlank(message = "El apellido no debe estar en blanco")
    private String apellido;

    @Column(length = 8)
    @Size(min = 9, max = 9, message = "El celular debe tener 9 digitos")
    private String celular;

    @Column(length = 80)
    @Email(message = "Debe ingresar un eMail válido")
    private String email;

    @Temporal(TemporalType.DATE)
    @Past(message = "La fecha de nacimiento debe ser anterior a la actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Orden> ordenes;
}
