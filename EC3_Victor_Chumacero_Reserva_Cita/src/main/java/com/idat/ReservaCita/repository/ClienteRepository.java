package com.idat.ReservaCita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.ReservaCita.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
