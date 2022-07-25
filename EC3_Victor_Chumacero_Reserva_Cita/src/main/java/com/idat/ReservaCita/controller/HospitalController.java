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

import com.idat.ReservaCita.dto.HospitalDtoRequest;
import com.idat.ReservaCita.dto.HospitalDtoResponse;
import com.idat.ReservaCita.service.IHospitalService;

@RestController
@RequestMapping("/hospital/v1")
public class HospitalController {

	@Autowired public IHospitalService service;
	
	@RequestMapping(path ="/listar", method = RequestMethod.GET)
	public ResponseEntity<List<HospitalDtoResponse>> listarHospitales(){
		
		return new ResponseEntity<List<HospitalDtoResponse>>(service.listarHospitales(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody HospitalDtoRequest hospital){
		service.guardarHospital(hospital);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<HospitalDtoResponse> listarPorId(@PathVariable Integer id) {
		
		HospitalDtoResponse h=service.obtenerHospital(id);
		if(h!=null)
			return new ResponseEntity<HospitalDtoResponse>(h,HttpStatus.OK);
		
		return new ResponseEntity<HospitalDtoResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PATCH)
	public ResponseEntity<Void> editar(@RequestBody HospitalDtoRequest hospital){
		
		HospitalDtoResponse h=service.obtenerHospital(hospital.getIdHospitalDto());
		
		if(h!=null) {
			service.editarHospital(hospital);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		HospitalDtoResponse h=service.obtenerHospital(id);
		
		if(h!=null) {
			service.eliminarHospital(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
