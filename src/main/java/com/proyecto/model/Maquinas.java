package com.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="tb_maquina")
public class Maquinas {
	@Id
	private String id_maquina;
	private String nom_Maquina;
	private String SKU;
	private String stock;
	private String precio;
	private String marca;
}
