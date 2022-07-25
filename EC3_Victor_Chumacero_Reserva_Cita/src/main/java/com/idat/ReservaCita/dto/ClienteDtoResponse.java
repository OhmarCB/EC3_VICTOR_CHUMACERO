package com.idat.ReservaCita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ClienteDtoResponse {

	private Integer idClienteDto;
	private String nombreDto;
	private String celularDto;
}
