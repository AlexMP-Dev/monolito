package com.sistemas.monolito.servicio.fase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.monolito.dominio.Fase;
import com.sistemas.monolito.repositorio.FaseRepository;

@Service
public class FaseServiceImpl implements FaseService {

    @Autowired
    private FaseRepository faseRepository;

    @Override
    public Fase agregar(Fase entidad) {
        return faseRepository.save(entidad);
    }

    @Override
    public List<Fase> listarTodos() {
        return faseRepository.findAll();
    }

    @Override
    public Optional<Fase> buscar(Long id) {
        return faseRepository.findById(id);
    }

    @Override
    public Fase actualizar(Fase entidad) {
        return faseRepository.save(entidad);
    }

    @Override
    public void Eliminar(Long id) {
        faseRepository.deleteById(id);
    }

}
