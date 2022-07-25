package com.idat.ReservaCita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UsuarioClienteDtoResponse {

	private Integer idUsuarioDto;
	private String usuarioDto;
	private String passwordDto;
	private String rolDto;
}
