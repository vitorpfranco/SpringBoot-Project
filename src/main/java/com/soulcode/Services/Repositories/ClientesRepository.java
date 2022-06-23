package com.soulcode.Services.Repositories;

import com.soulcode.Services.Models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    Optional<Clientes> findByEmail(String Email);
}