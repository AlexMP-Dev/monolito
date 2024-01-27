package com.sistemas.monolito.servicio.asignacion;

import java.util.List;

import com.sistemas.monolito.dominio.Asignacion;
import com.sistemas.monolito.servicio.iGenericoService;

public interface AsignacionService extends iGenericoService<Asignacion, Long> {
    
    List<Asignacion> listarPorOrdenId(Long id);
    

}
