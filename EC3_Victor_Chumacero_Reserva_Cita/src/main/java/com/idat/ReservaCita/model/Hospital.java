package com.idat.ReservaCita.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="hospital")
public class Hospital {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Integer idHospital;
	private String nombre;
	private String descripcion;
	private String distrito;
	
	@OneToMany(mappedBy = "hospital")
	private List<Cliente> clientes;
}
