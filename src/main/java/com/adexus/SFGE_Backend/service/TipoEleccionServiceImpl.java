package com.adexus.SFGE_Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.adexus.SFGE_Backend.dao.TipoEleccionRepository;
import com.adexus.SFGE_Backend.model.TipoEleccion;


@Service

public class TipoEleccionServiceImpl implements TipoEleccionService {

	@Autowired
	protected TipoEleccionRepository tipoEleccionRepository;

	@Override
	public TipoEleccion save(TipoEleccion tipoEleccion) {
		return this.tipoEleccionRepository.save(tipoEleccion);
	}

	@Override
	public List<TipoEleccion> findAll() {
		return this.tipoEleccionRepository.findAll();
	}

	@Override
	public void deleteTipoEleccion(Long id) {
		this.tipoEleccionRepository.delete(id);
	}

}
