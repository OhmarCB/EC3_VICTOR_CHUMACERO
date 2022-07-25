package com.idat.ReservaCita.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Integer idCliente;
	private String nombre;
	private String celular;
	
	@OneToOne(mappedBy = "cliente")
	private UsuarioCliente usuarioCliente;
	
	@JoinColumn(name="id_hospital", nullable = false,unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_hospital) references clientes(id_hospital)"))
	@ManyToOne
	private Hospital hospital;
}
