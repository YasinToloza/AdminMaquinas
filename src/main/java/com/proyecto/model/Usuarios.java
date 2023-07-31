package com.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name ="tb_usuarios")
public class Usuarios {
	@Id
	private String id_usuarios;
	private String usuario;
	private String clave;

}
