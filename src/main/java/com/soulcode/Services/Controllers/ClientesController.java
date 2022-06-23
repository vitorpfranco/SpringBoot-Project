package com.soulcode.Services.Controllers;

import com.soulcode.Services.Models.Clientes;
import com.soulcode.Services.Services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("servicos")
public class ClientesController {

    @Autowired
    ClientesService clientesService;

    @GetMapping("/clientes")
    public List<Clientes> mostrarTodosClientes() {
        List<Clientes> clientes = clientesService.mostrarTodosClientes();
        return clientes;
    }

    @GetMapping("/clientes/{idCliente}")
    public ResponseEntity<Clientes> mostarUmClientePeloId(@PathVariable Integer idCliente) {
        Clientes clientes = clientesService.mostarUmClientePeloId(idCliente);
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/clientesEmail/{email}")
    public ResponseEntity<Clientes> mostarUmClientePeloEmail(@PathVariable String email) {
        Clientes cliente = clientesService.mostarUmClientePeloEmail(email);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Clientes> cadastrarCliente(@RequestBody Clientes cliente) {
        cliente = clientesService.cadastrarCliente(cliente);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id")
                .buildAndExpand(cliente.getIdCliente()).toUri();
        return ResponseEntity.created(novaUri).body(cliente);
    }
    @DeleteMapping("/clientes/{idCliente}")
    public ResponseEntity<Clientes> excluirCliente(@PathVariable Integer idCliente) {
        clientesService.excluirCliente(idCliente);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/clientes/{idCliente}")
    public ResponseEntity<Clientes> editarCliente(@PathVariable Integer idCliente, @RequestBody Clientes cliente) {
        cliente.setIdCliente(idCliente);
        clientesService.editarCliente(cliente);
        return ResponseEntity.ok().build();
    }
}
