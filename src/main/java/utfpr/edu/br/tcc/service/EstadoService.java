package utfpr.edu.br.tcc.service;

import utfpr.edu.br.tcc.model.Estado;

import java.util.List;

public interface EstadoService {
    void salvar(Estado estado) ;

    void editar(Estado estado);

    void excluir(Long id);

    Estado buscarPorId(Long id);

    List<Estado> buscarTodos();
}
