package com.idat.ReservaCita.service;

import java.util.List;

import com.idat.ReservaCita.dto.ClienteDtoRequest;
import com.idat.ReservaCita.dto.ClienteDtoResponse;

public interface IClienteService {

	public void guardarCliente(ClienteDtoRequest cli);
	
	public void editarCliente(ClienteDtoRequest cli);
	
	public void eliminarCliente(Integer id);
	
	public List<ClienteDtoResponse> listarClientes();
	
	public ClienteDtoResponse obtenerCliente(Integer id);
}
