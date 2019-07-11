package utfpr.edu.br.tcc.dao;

import utfpr.edu.br.tcc.model.Estado;

import java.util.List;

public interface EstadoDao {
    void save(Estado estado);

    void update(Estado estado);

    void delete(Long id);

    Estado findById(Long id);

    List<Estado> findAll();
}
