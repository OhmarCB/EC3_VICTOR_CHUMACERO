package com.idat.ReservaCita.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.ReservaCita.dto.ClienteDtoRequest;
import com.idat.ReservaCita.dto.ClienteDtoResponse;
import com.idat.ReservaCita.model.Cliente;
import com.idat.ReservaCita.repository.ClienteRepository;

public class ClienteServiceImpl implements IClienteService{
	
	@Autowired public ClienteRepository repository;
	
	@Override
	public void guardarCliente(ClienteDtoRequest cli) {
		Cliente c=new Cliente();
		c.setIdCliente(cli.getIdClienteDto());
		c.setNombre(cli.getNombreDto());
		c.setIdCliente(cli.getIdClienteDto());
		
		
		repository.save(c);
	}

	@Override
	public void editarCliente(ClienteDtoRequest cli) {
		Cliente c=new Cliente();
		c.setIdCliente(cli.getIdClienteDto());
		c.setNombre(cli.getNombreDto());
		c.setIdCliente(cli.getIdClienteDto());
		
		
		repository.saveAndFlush(c);
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<ClienteDtoResponse> listarClientes() {
		List<ClienteDtoResponse>lista=new ArrayList<ClienteDtoResponse>();
		ClienteDtoResponse c=null;
		
		for (Cliente clientes : repository.findAll()) {
			c=new ClienteDtoResponse();
			c.setIdClienteDto(clientes.getIdCliente());
			c.setNombreDto(clientes.getNombre());
			c.setCelularDto(clientes.getCelular());
			
			lista.add(c);
		}
		
		return lista;
	}

	@Override
	public ClienteDtoResponse obtenerCliente(Integer id) {
		ClienteDtoResponse c=new ClienteDtoResponse();
		Cliente cliente=repository.findById(id).orElse(null);
		
		c.setIdClienteDto(cliente.getIdCliente());
		c.setNombreDto(cliente.getNombre());
		c.setCelularDto(cliente.getCelular());
		
		return c;
	}

}
