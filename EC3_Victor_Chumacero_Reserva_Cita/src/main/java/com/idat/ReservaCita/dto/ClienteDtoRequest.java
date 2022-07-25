package com.idat.ReservaCita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ClienteDtoRequest {

	private Integer idClienteDto;
	private String nombreDto;
	private String celularDto;
}
