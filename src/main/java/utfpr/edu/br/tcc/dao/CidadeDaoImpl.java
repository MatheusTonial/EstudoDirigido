package utfpr.edu.br.tcc.dao;

import org.springframework.stereotype.Repository;
import utfpr.edu.br.tcc.model.Cidade;

import java.util.List;

@Repository
public class CidadeDaoImpl extends AbstractDao<Cidade, Long> implements CidadeDao{
    @Override
    public List<Cidade> findByNome(String nome) {
        return createQuery("Select c from Cidade c where UPPER(c.nome) like UPPER(?1)", "%"+nome+"%");
    }

    @Override
    public List<Cidade> findByEstado(String nome) {
        return createQuery("Select c from Cidade c where UPPER(c.estado.nome) like UPPER(?1) OR UPPER(c.estado.sigla) like UPPER(?1)", "%"+nome+"%");
    }
}
