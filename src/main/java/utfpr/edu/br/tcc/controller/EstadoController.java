package utfpr.edu.br.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utfpr.edu.br.tcc.model.Estado;
import utfpr.edu.br.tcc.service.EstadoService;

import javax.validation.Valid;

@Controller
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/cadastrar")
    public String cadastrar(ModelMap model){
        model.addAttribute("estado", new Estado());
        return "/estado/form";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("estados", estadoService.buscarTodos());
        return "/estado/list";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Estado estado, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()){
            return "/estado/form";
        }
        estadoService.salvar(estado);
        attr.addFlashAttribute("success", "Estado inserido com sucesso!");
        return "redirect:/estados/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("estado", estadoService.buscarPorId(id));
        return "/estado/form";
    }

    @PostMapping("/editar")
    public String editar(@Valid Estado estado, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()){
            return "/estado/form";
        }
        estadoService.editar(estado);
        attr.addFlashAttribute("success", "Estado editado com sucesso!");
        return "redirect:/estados/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        estadoService.excluir(id);
        attr.addFlashAttribute("success", "Estado excluido com sucesso");
        return "redirect:/estados/listar";
    }
    
}
