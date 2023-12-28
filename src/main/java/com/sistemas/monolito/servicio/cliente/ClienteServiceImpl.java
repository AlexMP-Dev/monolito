package com.sistemas.monolito.servicio.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.monolito.dominio.Cliente;
import com.sistemas.monolito.repositorio.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente agregar(Cliente entidad) {
        return clienteRepository.save(entidad);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscar(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente actualizar(Cliente entidad) {
        return clienteRepository.save(entidad);
    }

    @Override
    public void Eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

}
