package br.com.ronna.ms.funcionario.vo;

import br.com.ronna.ms.funcionario.models.FuncionarioModel;
import lombok.Data;

@Data
public class ResponseTemplateVO {

    private FuncionarioModel funcionarioModel;
    private EmpresaModel empresaModel;
}
