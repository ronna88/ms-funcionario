package br.com.ronna.ms.funcionario.controllers;

import br.com.ronna.ms.funcionario.dtos.FuncionarioDto;
import br.com.ronna.ms.funcionario.models.FuncionarioModel;
import br.com.ronna.ms.funcionario.services.FuncionarioService;
import br.com.ronna.ms.funcionario.vo.ResponseTemplateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/funcionario/create-funcionario")
    public ResponseEntity<FuncionarioModel> createFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto){
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(funcionarioDto, funcionarioModel);
        funcionarioService.createFuncionario(funcionarioModel);
        return new ResponseEntity<>(funcionarioModel, HttpStatus.CREATED);
    }

    @PutMapping("/funcionario/edit-funcionario/{id}")
    public FuncionarioModel editFuncionario(@RequestBody FuncionarioModel funcionarioModel) {
        return funcionarioService.saveFuncionario(funcionarioModel);
    }

    @GetMapping("/funcionario/list-funcionario")
    public List<FuncionarioModel> listFuncionario(){
        return funcionarioService.listFuncionario();
    }

    @GetMapping("/funcionario/{id}")
    public FuncionarioModel getFuncionario(@PathVariable("id") Long funcionarioId){
        return funcionarioService.getFuncionario(funcionarioId);
    }

    @GetMapping("/funcionario/{id}/full")
    public ResponseTemplateVO getFullFuncionario(@PathVariable("id") Long funcionarioId){
        return funcionarioService.getFullFuncionario(funcionarioId);
    }
}
