package com.idat.ReservaCita.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="usuario_cliente")
public class UsuarioCliente {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Integer idUsuario;
	private String usuario;
	private String password;
	private String rol;
	
	@OneToOne
	@JoinColumn(name="id_cliente", nullable=false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references clientes(id_cliente)"))
	private Cliente cliente;
}
