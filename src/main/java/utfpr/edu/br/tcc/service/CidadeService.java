package utfpr.edu.br.tcc.service;

import utfpr.edu.br.tcc.model.Cidade;

import java.util.List;

public interface CidadeService {

    void salvar(Cidade cidade) ;

    void editar(Cidade cidade);

    void excluir(Long id);

    Cidade buscarPorId(Long id);

    List<Cidade> buscarTodos();

    List<Cidade> findByNome(String nome);

    List<Cidade> findByEstado(String nome);
}
