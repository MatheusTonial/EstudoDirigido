package utfpr.edu.br.tcc.dao;

import utfpr.edu.br.tcc.model.Cidade;

import java.util.List;

public interface CidadeDao {

    void save(Cidade cidade);

    void update(Cidade cidade);

    void delete(Long id);

    Cidade findById(Long id);

    List<Cidade> findAll();

    List<Cidade> findByNome(String nome);

    List<Cidade> findByEstado(String nome);
}
