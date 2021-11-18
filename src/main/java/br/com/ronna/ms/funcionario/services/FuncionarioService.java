package br.com.ronna.ms.funcionario.services;

import br.com.ronna.ms.funcionario.enums.StatusFuncionario;
import br.com.ronna.ms.funcionario.models.FuncionarioModel;
import br.com.ronna.ms.funcionario.repositories.FuncionarioRepository;
import br.com.ronna.ms.funcionario.vo.EmpresaModel;
import br.com.ronna.ms.funcionario.vo.ResponseTemplateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void createFuncionario(FuncionarioModel funcionarioModel) {
        funcionarioModel.setFuncionarioCreated(LocalDateTime.now());
        funcionarioModel.setFuncionarioUpdated(funcionarioModel.getFuncionarioCreated());
        if(funcionarioModel.getStatusFuncionario() == null){
            funcionarioModel.setStatusFuncionario(StatusFuncionario.ACTIVE);
        }
        funcionarioRepository.save(funcionarioModel);
    }

    public List<FuncionarioModel> listFuncionario() {
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel getFuncionario(Long funcionarioId) {
        return funcionarioRepository.getById(funcionarioId);
    }

    public FuncionarioModel saveFuncionario(FuncionarioModel funcionarioModel) {
        FuncionarioModel funcionarioEdit = funcionarioRepository.getById(funcionarioModel.getFuncionarioId());

        BeanUtils.copyProperties(funcionarioModel, funcionarioEdit);
        funcionarioEdit.setFuncionarioUpdated(LocalDateTime.now());
        return funcionarioRepository.save(funcionarioEdit);
    }

    public ResponseTemplateVO getFullFuncionario(Long funcionarioId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();

        FuncionarioModel funcionarioModel = funcionarioRepository.getById(funcionarioId);

        EmpresaModel empresaModel = restTemplate.getForObject("http://localhost:7000/empresa/" + funcionarioModel.getFuncionarioEmpresaId(), EmpresaModel.class);

        vo.setFuncionarioModel(funcionarioModel);
        vo.setEmpresaModel(empresaModel);
        return vo;
    }
}
