package com.idat.ReservaCita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.ReservaCita.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
