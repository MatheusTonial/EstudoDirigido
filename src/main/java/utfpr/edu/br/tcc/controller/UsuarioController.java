package utfpr.edu.br.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utfpr.edu.br.tcc.model.Cidade;
import utfpr.edu.br.tcc.model.Usuario;
import utfpr.edu.br.tcc.repository.UsuarioRepository;
import utfpr.edu.br.tcc.service.CidadeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/cadastrar")
    public String cadastrar(ModelMap model){
        model.addAttribute("usuario", new Usuario());
        return "/usuario/form";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("usuarios", repository.findAll());
        return "/usuario/list";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()){
            return "/usuario/form";
        }
        repository.save(usuario);
        attr.addFlashAttribute("success", "Usuario inserido com sucesso!");
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("usuario", repository.findOne(id));
        return "/usuario/form";
    }

    @PostMapping("/editar")
    public String editar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()){
            return "/usuario/form";
        }
        repository.save(usuario);
        attr.addFlashAttribute("success", "Usuario editado com sucesso!");
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        repository.delete(id);
        model.addAttribute("success", "Usuario excluido com sucesso");
        return listar(model);
    }

    @ModelAttribute("cidades")
    public List<Cidade> listaDeCidade(){
        return cidadeService.buscarTodos();
    }

    @GetMapping("/buscar/bairro")
    public String getByBairro(@RequestParam("bairro") String bairro, ModelMap model){
        model.addAttribute("usuarios", repository.findByBairroContainingIgnoreCase(bairro));
        return "/usuario/list";
    }

    @GetMapping("/buscar/cpf")
    public String getByCpf(@RequestParam("cpf") String cpf, ModelMap model){
        model.addAttribute("usuarios", repository.findByCpf(cpf));
        return "/usuario/list";
    }

    @GetMapping("/buscar/email")
    public String getByEmail(@RequestParam("email") String email, ModelMap model){
        model.addAttribute("usuarios", repository.findByEmailContainingIgnoreCase(email));
        return "/usuario/list";
    }

    @GetMapping("/buscar/nome")
    public String getByNome(@RequestParam("nome") String nome, ModelMap model){
        model.addAttribute("usuarios", repository.findByNomeContainingIgnoreCase(nome));
        return "/usuario/list";
    }

    @GetMapping("/buscar/rua")
    public String getByRua(@RequestParam("rua") String rua, ModelMap model){
        model.addAttribute("usuarios", repository.findByRuaContainingIgnoreCase(rua));
        return "/usuario/list";
    }

    @GetMapping("/buscar/telefone")
    public String getByTelefone(@RequestParam("telefone") String telefone, ModelMap model){
        model.addAttribute("usuarios", repository.findByTelefoneContaining(telefone));
        return "/usuario/list";
    }

    @GetMapping("/buscar/cidade")
    public String getByCidade(@RequestParam("cidade") String cidade, ModelMap model){
        model.addAttribute("usuarios", repository.findByCidade_Nome(cidade));
        return "/usuario/list";
    }
}
