package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Clientes;

@Repository
public interface IClientesRepository extends JpaRepository<Clientes, String>{

}
