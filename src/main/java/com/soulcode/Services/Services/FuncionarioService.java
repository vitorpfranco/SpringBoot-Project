package com.soulcode.Services.Services;

import com.soulcode.Services.Models.Funcionario;
import com.soulcode.Services.Repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    FuncionarioRepository funcionarioRepository;
    public List<Funcionario>mostrarTodosFuncionarios(){
return funcionarioRepository.findAll();
    }
    public Funcionario mostarUmFuncionarioPeloId(Integer idFuncionario){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
        return funcionario.orElseThrow();
    }
    public Funcionario mostarUmFuncionarioPeloEmail(String email){
        Optional<Funcionario> funcionario = funcionarioRepository.findByEmail(email);
        return funcionario.orElseThrow();
    }
    public Funcionario cadastrarFuncionario(Funcionario funcionario){
        funcionario.setIdFuncionario(null);
        return funcionarioRepository.save(funcionario);
    }
    public void excluirFuncionario(Integer idFuncionario){
        funcionarioRepository.deleteById(idFuncionario);
    }

    public void editarFuncionario(Funcionario funcionario){
        funcionarioRepository.save(funcionario);
    }
}
