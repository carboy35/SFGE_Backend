package com.adexus.SFGE_Backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adexus.SFGE_Backend.model.TipoEleccion;


public interface TipoEleccionRepository extends JpaRepository<TipoEleccion, Long> {

	@SuppressWarnings("unchecked")
	TipoEleccion save(TipoEleccion tipoEleccion);
	
	
}

