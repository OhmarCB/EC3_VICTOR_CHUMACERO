package com.idat.ReservaCita.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.ReservaCita.dto.UsuarioClienteDtoRequest;
import com.idat.ReservaCita.dto.UsuarioClienteDtoResponse;
import com.idat.ReservaCita.model.UsuarioCliente;
import com.idat.ReservaCita.repository.UsuarioClienteRepository;

public class UsuarioClienteServiceImpl implements IUsuarioClienteService{
	
	@Autowired public UsuarioClienteRepository repository; 

	@Override
	public void guardarUsuario(UsuarioClienteDtoRequest usu) {
		
		UsuarioCliente u=new UsuarioCliente();
		u.setIdUsuario(usu.getIdUsuarioDto());
		u.setUsuario(usu.getUsuarioDto());
		u.setPassword(usu.getPasswordDto());
		u.setRol(usu.getRolDto());
		
		
		repository.save(u);
	}

	@Override
	public void editarUsuario(UsuarioClienteDtoRequest usu) {
		UsuarioCliente u=new UsuarioCliente();
		u.setIdUsuario(usu.getIdUsuarioDto());
		u.setUsuario(usu.getUsuarioDto());
		u.setPassword(usu.getPasswordDto());
		u.setRol(usu.getRolDto());
		
		
		repository.saveAndFlush(u);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<UsuarioClienteDtoResponse> listarUsuarios() {
		
		List<UsuarioClienteDtoResponse>lista=new ArrayList<UsuarioClienteDtoResponse>();
		UsuarioClienteDtoResponse u=null;
		
		for (UsuarioCliente usuarios : repository.findAll()) {
			u=new UsuarioClienteDtoResponse();
			u.setIdUsuarioDto(usuarios.getIdUsuario());
			u.setUsuarioDto(usuarios.getUsuario());
			u.setPasswordDto(usuarios.getPassword());
			u.setRolDto(usuarios.getRol());
			
			lista.add(u);
		}
		
		return lista;
	}

	@Override
	public UsuarioClienteDtoResponse obtenerUsuario(Integer id) {
		UsuarioClienteDtoResponse u=new UsuarioClienteDtoResponse();
		UsuarioCliente usuario=repository.findById(id).orElse(null);
		
		u.setIdUsuarioDto(usuario.getIdUsuario());
		u.setUsuarioDto(usuario.getUsuario());
		u.setPasswordDto(usuario.getPassword());
		u.setRolDto(usuario.getRol());
		
		return u;
	}

	@Override
	public UsuarioCliente findByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
