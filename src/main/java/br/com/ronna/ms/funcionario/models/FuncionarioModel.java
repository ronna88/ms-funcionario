package br.com.ronna.ms.funcionario.models;

import br.com.ronna.ms.funcionario.enums.StatusFuncionario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "TB_FUNCIONARIO")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class FuncionarioModel  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long funcionarioId;
    private String funcionarioNome;
    private String funcionarioTelefone;
    private String funcionarioEmail;
    private String funcionarioEndereco;
    private String funcionarioBairro;
    private String funcionarioCEP;
    private Long funcionarioEmpresaId;
    private StatusFuncionario statusFuncionario;
    private LocalDateTime funcionarioCreated;
    private LocalDateTime funcionarioUpdated;
}
