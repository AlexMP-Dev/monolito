package com.sistemas.monolito.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.monolito.dominio.Tarifa;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {

}
