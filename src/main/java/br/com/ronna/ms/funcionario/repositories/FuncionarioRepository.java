package br.com.ronna.ms.funcionario.repositories;

import br.com.ronna.ms.funcionario.models.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}
