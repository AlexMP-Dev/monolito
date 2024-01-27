package com.sistemas.monolito.controlador;

import java.util.Optional;

/* import javax.validation.Valid; */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistemas.monolito.dominio.Fase;
import com.sistemas.monolito.servicio.fase.FaseService;

@Controller
@RequestMapping("/fase")
public class FaseController {
    @Autowired private FaseService faseService;

    @GetMapping({ "/", "/index" })
    public String index(Model model) {
        model.addAttribute("listaFases", faseService.listarTodos());

        return "fase/faseIndex";
    }

    @GetMapping("/nuevo")
    public String getFaseNuevoForm(Model model) {
        model.addAttribute("fase", new Fase());

        return "fase/faseForm";
    }

    @PostMapping("/nuevo")
    public String postFaseNuevoForm(
        @Valid @ModelAttribute("fase") Fase fase,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            
            return "fase/faseForm";
        }
        faseService.agregar(fase);
        redirectAttributes.addFlashAttribute("flash", "Agregado correctamente");

        return "redirect:/fase/index";
        }

    @GetMapping("/editar/{id}")
    public String getFaseEditForm(
        @PathVariable("id") Long id,
        Model model){
            
        Optional<Fase> buscado = faseService.buscar(id);
        model.addAttribute("fase",
        buscado.isPresent() ? buscado.get() : new Fase());

        return "fase/faseForm";
        }

    @PostMapping("/editar")
    public String postFaseEditForm(
        @Valid @ModelAttribute("fase") Fase fase,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes){
            
        if(bindingResult.hasErrors()){
            
            return "fase/faseForm";
        }

        faseService.actualizar(fase);
        redirectAttributes.addFlashAttribute("flash", "Actualizado correctamente");
        return "redirect:/fase/index";
        }

    @GetMapping("/eliminar/{id}")
    public String getFaseEliminar(
        @PathVariable("id") Long id,
        RedirectAttributes redirectAttrs){
            
        faseService.Eliminar(id);
        redirectAttrs.addFlashAttribute("flash", "Eliminado correctamente");
        return "redirect:/fase/index";
        }
    }
        
   