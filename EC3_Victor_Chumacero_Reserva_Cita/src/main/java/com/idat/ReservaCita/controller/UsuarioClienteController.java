package com.idat.ReservaCita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ReservaCita.dto.UsuarioClienteDtoRequest;
import com.idat.ReservaCita.dto.UsuarioClienteDtoResponse;
import com.idat.ReservaCita.service.IUsuarioClienteService;

@RestController
@RequestMapping("/usuario/v1")
public class UsuarioClienteController {

	@Autowired public IUsuarioClienteService service;
	
	@RequestMapping(path ="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioClienteDtoResponse>> listarUsuarios(){
		
		return new ResponseEntity<List<UsuarioClienteDtoResponse>>(service.listarUsuarios(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioClienteDtoRequest usuario){
		service.guardarUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioClienteDtoResponse> listarPorId(@PathVariable Integer id) {
		
		UsuarioClienteDtoResponse u=service.obtenerUsuario(id);
		if(u!=null)
			return new ResponseEntity<UsuarioClienteDtoResponse>(u,HttpStatus.OK);
		
		return new ResponseEntity<UsuarioClienteDtoResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody UsuarioClienteDtoRequest usuario){
		
		UsuarioClienteDtoResponse u=service.obtenerUsuario(usuario.getIdUsuarioDto());
		
		if(u!=null) {
			service.editarUsuario(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		UsuarioClienteDtoResponse u=service.obtenerUsuario(id);
		
		if(u!=null) {
			service.eliminarUsuario(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
