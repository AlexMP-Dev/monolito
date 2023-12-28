package com.sistemas.monolito.servicio.tarifa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.monolito.dominio.Tarifa;
import com.sistemas.monolito.repositorio.TarifaRepository;

@Service
public class TarifaServiceImpl implements TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    @Override
    public Tarifa agregar(Tarifa entidad) {
        return tarifaRepository.save(entidad);
    }

    @Override
    public List<Tarifa> listarTodos() {
        return tarifaRepository.findAll();
    }

    @Override
    public Optional<Tarifa> buscar(Long id) {
        return tarifaRepository.findById(id);
    }

    @Override
    public Tarifa actualizar(Tarifa entidad) {
        return tarifaRepository.save(entidad);
    }

    @Override
    public void Eliminar(Long id) {
        tarifaRepository.deleteById(id);
    }

}
