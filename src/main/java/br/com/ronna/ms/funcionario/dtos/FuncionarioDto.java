package br.com.ronna.ms.funcionario.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class FuncionarioDto {
    @NotBlank
    private String funcionarioNome;
    @NotBlank
    private String funcionarioTelefone;
    @NotBlank
    @Email
    private String funcionarioEmail;
    @NotBlank
    private String funcionarioEndereco;
    @NotBlank
    private String funcionarioBairro;
    @NotBlank
    private String funcionarioCEP;
    @NotNull
    private Long funcionarioEmpresaId;

    private LocalDateTime funcionarioCreated;
    private LocalDateTime funcionarioUpdated;
}
