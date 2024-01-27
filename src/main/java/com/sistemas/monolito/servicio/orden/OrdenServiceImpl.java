package com.sistemas.monolito.servicio.orden;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.monolito.dominio.Orden;
import com.sistemas.monolito.repositorio.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public Orden agregar(Orden entidad) {
        return ordenRepository.save(entidad);
    }

    @Override
    public List<Orden> listarTodos() {
        return ordenRepository.findAll();
    }

    @Override
    public Optional<Orden> buscar(Long id) {
        return ordenRepository.findById(id);
    }

    @Override
    public Orden actualizar(Orden entidad) {
        return ordenRepository.save(entidad);
    }

    @Override
    public void Eliminar(Long id) {
        ordenRepository.deleteById(id);
    }

    @Override
    public List<Orden> listarPorClienteId(Long id) {
        return ordenRepository.findByClienteId(id);
    }

}