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

import com.idat.ReservaCita.dto.ClienteDtoRequest;
import com.idat.ReservaCita.dto.ClienteDtoResponse;
import com.idat.ReservaCita.service.IClienteService;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {
	
	@Autowired public IClienteService service;
	
	@RequestMapping(path ="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDtoResponse>> listarClientes(){
		
		return new ResponseEntity<List<ClienteDtoResponse>>(service.listarClientes(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteDtoRequest cliente){
		service.guardarCliente(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDtoResponse> listarPorId(@PathVariable Integer id) {
		
		ClienteDtoResponse c=service.obtenerCliente(id);
		if(c!=null)
			return new ResponseEntity<ClienteDtoResponse>(c,HttpStatus.OK);
		
		return new ResponseEntity<ClienteDtoResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody ClienteDtoRequest cliente){
		
		ClienteDtoResponse c=service.obtenerCliente(cliente.getIdClienteDto());
		
		if(c!=null) {
			service.editarCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ClienteDtoResponse u=service.obtenerCliente(id);
		
		if(u!=null) {
			service.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
