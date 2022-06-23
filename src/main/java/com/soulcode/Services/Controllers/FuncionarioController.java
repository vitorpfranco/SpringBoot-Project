package com.soulcode.Services.Controllers;

import com.soulcode.Services.Models.Funcionario;
import com.soulcode.Services.Services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("servicos")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> mostrarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.mostrarTodosFuncionarios();
        return funcionarios;
    }

    @GetMapping("/funcionarios/{idFuncionario}")
    public ResponseEntity<Funcionario> mostarUmFuncionarioPeloId(@PathVariable Integer idFuncionario) {
        Funcionario funcionario = funcionarioService.mostarUmFuncionarioPeloId(idFuncionario);
        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping("/funcionariosEmail/{email}")
    public ResponseEntity<Funcionario> mostarUmFuncionarioPeloEmail(@PathVariable String email) {
        Funcionario funcionario = funcionarioService.mostarUmFuncionarioPeloEmail(email);
        return ResponseEntity.ok().body(funcionario);
    }

    @PostMapping("/funcionarios")
    public ResponseEntity<Funcionario> cadastrarfuncionario(@RequestBody Funcionario funcionario) {
        funcionario = funcionarioService.cadastrarFuncionario(funcionario);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id")
                .buildAndExpand(funcionario.getIdFuncionario()).toUri();
        return ResponseEntity.created(novaUri).body(funcionario);
    }
    @DeleteMapping("/funcionarios/{idFuncionario}")
    public ResponseEntity<Funcionario> excluirFuncionario(@PathVariable Integer idFuncionario) {
        funcionarioService.excluirFuncionario(idFuncionario);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/funcionarios/{idFuncionario}")
    public ResponseEntity<Funcionario> editarFuncionario(@PathVariable Integer idFuncionario, @RequestBody Funcionario funcionario) {
        funcionario.setIdFuncionario(idFuncionario);
        funcionarioService.editarFuncionario(funcionario);
        return ResponseEntity.ok().build();
    }
}