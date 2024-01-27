package com.sistemas.monolito.controlador;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemas.monolito.dominio.Asignacion;
import com.sistemas.monolito.servicio.asignacion.AsignacionService;
import com.sistemas.monolito.servicio.empleado.EmpleadoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/asignacion")

public class AsignacionController {
    @Autowired
    private AsignacionService asignacionService;
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping({ "{ordenid}/", "{ordenid}/index" })
    public String getIndex(
            @PathVariable("ordenid") Long ordenid,
            Model model) {
        model.addAttribute("listaAsignaciones", asignacionService.listarPorOrdenId(ordenid));
        return "asignacion/asignacionIndex";
    }

    @GetMapping("/editar/{id}")
    public String getAsignacionFormEdit(
            @PathVariable("id") Long id,
            Model model) {
        Optional<Asignacion> buscado = asignacionService.buscar(id);
        model.addAttribute("asignacion",
                buscado.isPresent() ? buscado.get() : new Asignacion());
        model.addAttribute("listaEmpleados", empleadoService.listarTodos());
        return "asignacion/asignacionForm";
    }

    @PostMapping("/editar")
    public String postAsignacionFormEdit(
            @Valid @ModelAttribute("asignacion") Asignacion asignacion,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listaEmpleados", empleadoService.listarTodos());
            return "asignacion/asignacionForm";
        }
        asignacionService.agregar(asignacion);
        return "redirect:/asignacion/" + asignacion.getOrden().getId() + "/index";
    }






@GetMapping("/iniciar/{id}")
public String getTareaIniciar(
    @PathVariable("id") Long id,
    Model model ) {
        
        Long ordenId = 0L;
        Optional<Asignacion> buscado = asignacionService.buscar(id);

        if (buscado.isPresent()){
            Asignacion asignacion = buscado.get();
            asignacion.setFechaInicio(new Date());
            ordenId = asignacion.getOrden().getId();
            asignacionService.actualizar(asignacion);
        }
        return "redirect:/asignacion/" + ordenId + "/index";
    }


    @GetMapping("/terminar/{id}")
    public String getTareaTerminar(
        @PathVariable("id") Long id,
        Model model ) {
            
            Long ordenId = 0L;
            Optional<Asignacion> buscado = asignacionService.buscar(id);

            if (buscado.isPresent()) {
                Asignacion asignacion = buscado.get();
                asignacion.setFechaFin(new Date());
                ordenId = asignacion.getOrden().getId();
                asignacionService.actualizar(asignacion);
                
            }
            return "redirect:/asignacion/" + ordenId + "/index";
        }
    }
    

