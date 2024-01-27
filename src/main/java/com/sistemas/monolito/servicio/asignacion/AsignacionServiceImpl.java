package com.sistemas.monolito.servicio.asignacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.monolito.dominio.Asignacion;
import com.sistemas.monolito.repositorio.AsignacionRepository;

@Service
public class AsignacionServiceImpl implements AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Override
    public Asignacion agregar(Asignacion entidad) {
        return asignacionRepository.save(entidad);
    }

    @Override
    public List<Asignacion> listarTodos() {
        return asignacionRepository.findAll();
    }

    @Override
    public Optional<Asignacion> buscar(Long id) {
        return asignacionRepository.findById(id);
    }

    @Override
    public Asignacion actualizar(Asignacion entidad) {
        return asignacionRepository.save(entidad);
    }

    @Override
    public void Eliminar(Long id) {
        asignacionRepository.deleteById(id);
    }

    @Override
    public List<Asignacion> listarPorOrdenId(Long id) {
        return asignacionRepository.findByOrdenId(id);
    }



}
