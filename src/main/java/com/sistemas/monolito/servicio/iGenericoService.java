package com.sistemas.monolito.servicio;

import java.util.List;
import java.util.Optional;

public interface iGenericoService<Entidad, ID> {
    public Entidad agregar(Entidad entidad);

    public List<Entidad> listarTodos();

    public Optional<Entidad> buscar(ID id);

    public Entidad actualizar(Entidad entidad);

    public void Eliminar(ID id);
}
