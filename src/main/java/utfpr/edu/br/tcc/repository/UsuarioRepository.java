package utfpr.edu.br.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.edu.br.tcc.model.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByBairroContainingIgnoreCase (String bairro);

    List<Usuario> findByCpf (String cpf);

    List<Usuario> findByEmailContainingIgnoreCase (String email);

    List<Usuario> findByNomeContainingIgnoreCase (String nome);

    List<Usuario> findByRuaContainingIgnoreCase (String rua);

    List<Usuario> findByTelefoneContaining (String telefone);

    List<Usuario> findByCidade_Nome (String cidade_nome);



}
