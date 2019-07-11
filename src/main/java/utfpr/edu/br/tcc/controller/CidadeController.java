package utfpr.edu.br.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utfpr.edu.br.tcc.model.Cidade;
import utfpr.edu.br.tcc.model.Estado;
import utfpr.edu.br.tcc.service.CidadeService;
import utfpr.edu.br.tcc.service.EstadoService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/cadastrar")
    public String cadastrar(ModelMap model){
        model.addAttribute("cidade", new Cidade());
        return "/cidade/form";

    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("cidades", cidadeService.buscarTodos());
        return "/cidade/list";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()){
            return "/cidade/form";

        }
        cidadeService.salvar(cidade);
        attr.addFlashAttribute("success", "Cidade inserida com sucesso!");
        return "redirect:/cidades/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cidade", cidadeService.buscarPorId(id));
        return "/cidade/form";
    }

    @PostMapping("/editar")
    public String editar(@Valid Cidade cidade, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()){
            return "/cidade/form";
        }
        cidadeService.editar(cidade);
        attr.addFlashAttribute("success", "Cidade editado com sucesso!");
        return "redirect:/cidades/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        cidadeService.excluir(id);
        model.addAttribute("success", "Cidade excluido com sucesso");
        return listar(model);
    }

    @GetMapping("/buscar/nome")
    public String getByNome(@RequestParam("nome") String nome, ModelMap model){
        model.addAttribute("cidades", cidadeService.findByNome(nome));
        return "/cidade/list";
    }
    @GetMapping("/buscar/estado")
    public String getByEstado(@RequestParam("nome") String nome, ModelMap model){
        model.addAttribute("cidades", cidadeService.findByEstado(nome));
        return "/cidade/list";
    }

    @ModelAttribute("estados")
    public List<Estado> listaDeEstado(){
        return estadoService.buscarTodos();
    }

}
