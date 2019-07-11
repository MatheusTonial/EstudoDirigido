package utfpr.edu.br.tcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utfpr.edu.br.tcc.dao.EstadoDao;
import utfpr.edu.br.tcc.model.Estado;

import java.util.List;

@Service
@Transactional(readOnly=false)
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoDao dao;

    @Override
    public void salvar(Estado estado) {
        dao.save(estado);
    }

    @Override
    public void editar(Estado estado) {
        dao.update(estado);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Estado buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Estado> buscarTodos() {
        return dao.findAll();
    }
}
