package com.idat.ReservaCita.service;

import java.util.List;

import com.idat.ReservaCita.dto.UsuarioClienteDtoRequest;
import com.idat.ReservaCita.dto.UsuarioClienteDtoResponse;
import com.idat.ReservaCita.model.UsuarioCliente;

public interface IUsuarioClienteService {
	
	public void guardarUsuario(UsuarioClienteDtoRequest usu);
	
	public void editarUsuario(UsuarioClienteDtoRequest usu);
	
	public void eliminarUsuario(Integer id);
	
	public List<UsuarioClienteDtoResponse> listarUsuarios();
	
	public UsuarioClienteDtoResponse obtenerUsuario(Integer id);
	
	public UsuarioCliente findByUsuario(String usuario);
}
