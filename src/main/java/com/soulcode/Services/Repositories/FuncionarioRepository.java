package com.soulcode.Services.Repositories;

import com.soulcode.Services.Models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    Optional<Funcionario> findByEmail(String Email);
//    Optional<Funcionario> findByNomeAndEmail(String nome, String email)
}
