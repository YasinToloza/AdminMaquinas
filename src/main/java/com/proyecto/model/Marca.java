package com.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="tb_marca")
public class Marca {
	@Id
	private String id_marca;
	private String nom_Marca;
	private String year_Fundacion;
	private String pag_Web;

}
