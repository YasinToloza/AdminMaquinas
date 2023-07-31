package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Usuarios;



@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, String>{
	
		
		Usuarios findByUsuarioAndClave(String usuario, String clave);

}
