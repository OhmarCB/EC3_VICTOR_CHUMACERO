package com.idat.ReservaCita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HospitalDtoResponse {

	private Integer idHospitalDto;
	private String nombreDto;
	private String descripcionDto;
	private String distritoDto;
}
