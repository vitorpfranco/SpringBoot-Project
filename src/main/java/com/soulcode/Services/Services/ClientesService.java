package com.soulcode.Services.Services;

import com.soulcode.Services.Models.Clientes;
import com.soulcode.Services.Repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {
    @Autowired
    ClientesRepository clientesRepository;
    public List<Clientes> mostrarTodosClientes(){
        return clientesRepository.findAll();
    }
    public Clientes mostarUmClientePeloId(Integer idCliente){
        Optional<Clientes> cliente = clientesRepository.findById(idCliente);
        return cliente.orElseThrow();
    }
    public Clientes mostarUmClientePeloEmail(String email){
        Optional<Clientes> cliente = clientesRepository.findByEmail(email);
        return cliente.orElseThrow();
    }
    public Clientes cadastrarCliente(Clientes cliente){
        cliente.setIdCliente(null);
        return clientesRepository.save(cliente);
    }
    public void excluirCliente(Integer idCliente){
        clientesRepository.deleteById(idCliente);
    }

    public void editarCliente(Clientes cliente){
        clientesRepository.save(cliente);
    }
}

