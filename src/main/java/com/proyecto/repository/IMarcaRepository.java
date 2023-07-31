package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Marca;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, String>{

}
