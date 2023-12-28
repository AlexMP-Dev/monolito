package com.sistemas.monolito.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.monolito.dominio.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

}
