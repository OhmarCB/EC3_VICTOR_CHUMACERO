package com.idat.ReservaCita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.idat.ReservaCita.model.UsuarioCliente;

public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer>{

	UsuarioCliente findByUsuario(String usuario);
}
