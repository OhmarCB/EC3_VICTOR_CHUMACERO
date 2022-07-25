package com.idat.ReservaCita.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.ReservaCita.dto.HospitalDtoRequest;
import com.idat.ReservaCita.dto.HospitalDtoResponse;
import com.idat.ReservaCita.model.Hospital;
import com.idat.ReservaCita.repository.HospitalRepository;

public class HospitalServiceImpl implements IHospitalService{
	
	@Autowired public HospitalRepository repository;

	@Override
	public void guardarHospital(HospitalDtoRequest hos) {
		Hospital h=new Hospital();
		h.setIdHospital(hos.getIdHospitalDto());
		h.setNombre(hos.getNombreDto());
		h.setDescripcion(hos.getDescripcionDto());
		h.setDistrito(hos.getDistritoDto());
		
		
		repository.save(h);
	}

	@Override
	public void editarHospital(HospitalDtoRequest hos) {
		Hospital h=new Hospital();
		h.setIdHospital(hos.getIdHospitalDto());
		h.setNombre(hos.getNombreDto());
		h.setDescripcion(hos.getDescripcionDto());
		h.setDistrito(hos.getDistritoDto());
		
		
		repository.saveAndFlush(h);
	}

	@Override
	public void eliminarHospital(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<HospitalDtoResponse> listarHospitales() {
		List<HospitalDtoResponse>lista=new ArrayList<HospitalDtoResponse>();
		HospitalDtoResponse h=null;
		
		for (Hospital hospitales : repository.findAll()) {
			h=new HospitalDtoResponse();
			h.setIdHospitalDto(hospitales.getIdHospital());
			h.setNombreDto(hospitales.getNombre());
			h.setDescripcionDto(hospitales.getDescripcion());
			h.setDistritoDto(hospitales.getDistrito());
			
			lista.add(h);
		}
		
		return lista;
	}

	@Override
	public HospitalDtoResponse obtenerHospital(Integer id) {
		HospitalDtoResponse h=new HospitalDtoResponse();
		Hospital hospital=repository.findById(id).orElse(null);
		
		h.setIdHospitalDto(hospital.getIdHospital());
		h.setNombreDto(hospital.getNombre());
		h.setDescripcionDto(hospital.getDescripcion());
		h.setDistritoDto(hospital.getDistrito());
		
		return h;
	}

}
