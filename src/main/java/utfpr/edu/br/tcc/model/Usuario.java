package utfpr.edu.br.tcc.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo em branco!")
    @Size(min = 4, max = 45, message="Deve estar entre {min} e {max} caracters")
    @Column(length = 45, nullable = false)
    private String nome;

    @NotBlank(message = "Campo em branco!")
    @Size(min = 4, max = 45, message="Deve estar entre {min} e {max} caracters")
    @Column(length = 45, nullable = false)
    private String email;

    @NotBlank(message = "Campo em branco!")
    @Size(min = 4, max = 45, message="Deve estar entre {min} e {max} caracters")
    @Column(length = 45, nullable = false)
    private String rua;

    @NotBlank(message = "Campo em branco!")
    @Size(min = 1, max = 7, message="Deve ter no maximo {max} caracters")
    @Column(length = 7, nullable = false)
    private String numero;

    @NotBlank(message = "Campo em branco!")
    @Size(min = 4, max = 45, message="Deve estar entre {min} e {max} caracters")
    @Column(length = 45, nullable = false)
    private String bairro;

    @NotBlank(message = "Campo em branco!")
    @Size(min = 10, max = 14, message="Deve estar entre {min} e {max} caracters")
    @Column(length = 45, nullable = false)
    private String telefone;

    @NotBlank(message = "Campo em branco!")
    @Size(min = 10, max = 14, message="Deve ter {min} caracters")
    @Column(length = 45, nullable = false)
    private String cpf;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "id", nullable = false)
    private Cidade cidade;

}
