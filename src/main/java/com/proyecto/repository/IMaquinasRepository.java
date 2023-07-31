package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Maquinas;

@Repository
public interface IMaquinasRepository extends JpaRepository<Maquinas, String>{

}
