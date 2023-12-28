package com.sistemas.monolito.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.monolito.dominio.Fase;

@Repository
public interface FaseRepository extends JpaRepository<Fase, Long> {

}
