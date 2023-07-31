package com.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="tb_cliente")
public class Clientes {
	@Id
	private String id_cliente;
	private String nombre;
	private String apellido;
	private String numero;
	private String correo;
	private String dni;
}
