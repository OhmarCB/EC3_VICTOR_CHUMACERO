package com.idat.ReservaCita.service;

import java.util.List;

import com.idat.ReservaCita.dto.HospitalDtoRequest;
import com.idat.ReservaCita.dto.HospitalDtoResponse;

public interface IHospitalService {

	public void guardarHospital(HospitalDtoRequest hos);
	
	public void editarHospital(HospitalDtoRequest hos);
	
	public void eliminarHospital(Integer id);
	
	public List<HospitalDtoResponse> listarHospitales();
	
	public HospitalDtoResponse obtenerHospital(Integer id);
}
