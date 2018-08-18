package com.adexus.SFGE_Backend.service;

import java.util.List;

import com.adexus.SFGE_Backend.model.TipoEleccion;

public interface TipoEleccionService {
	
	/**
	 * Guarda un tipo de eleccion
	 * 
	 * @param tipo eleccion
	 * @return el tipo de eleccion guardada
	 */
	TipoEleccion save(TipoEleccion tipoEleccion);

	/**
	 * Recupera la lista de tipos de eleccion
	 * 
	 * @return lista de tipos de eleccion
	 */
	List<TipoEleccion> findAll();

	/**
	 * Elimina una eleccion con el id recibido
	 * 
	 * @param id
	 */
	void deleteTipoEleccion(Long id);

}
