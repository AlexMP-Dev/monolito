package com.sistemas.monolito.servicio.orden;

import java.util.List;

import com.sistemas.monolito.dominio.Orden;
import com.sistemas.monolito.servicio.iGenericoService;

public interface OrdenService extends iGenericoService<Orden, Long> {
    List<Orden> listarPorClienteId(Long id);
}