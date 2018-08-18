package com.adexus.SFGE_Backend.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adexus.SFGE_Backend.service.TipoEleccionService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.adexus.SFGE_Backend.model.TipoEleccion;
import com.adexus.SFGE_Backend.util.RestResponse;

@RestController
public class TipoEleccionController {
	
	@Autowired
	protected TipoEleccionService tipoEleccionService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String tipoEleccionJson)
			throws JsonParseException, JsonMappingException, IOException {
		this.mapper = new ObjectMapper();

		TipoEleccion tipoEleccion = this.mapper.readValue(tipoEleccionJson, TipoEleccion.class);

		if (!this.validate(tipoEleccion)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Los campos obligatorios no estan diligenciados");
		}
		this.tipoEleccionService.save(tipoEleccion);

		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}
	
	@RequestMapping(value = "/getTipoElecciones", method = RequestMethod.GET)
	public List<TipoEleccion> getTipoElecciones() {
		return this.tipoEleccionService.findAll();
	}

	@RequestMapping(value = "/deleteTipoEleccion", method = RequestMethod.POST)
	public RestResponse deleteTipoEleccion(@RequestBody String tipoEleccionJson) throws Exception {
		this.mapper = new ObjectMapper();

	    TipoEleccion tipoEleccion = this.mapper.readValue(tipoEleccionJson, TipoEleccion.class);

		try {
		if (tipoEleccion.getId() == null) {
			throw new Exception("El id esta nulo");
		}
		this.tipoEleccionService.deleteTipoEleccion(tipoEleccion.getId());
		} catch( Exception ex) {
		return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"Error al borrar registro");
		}
		return new RestResponse(HttpStatus.OK.value(),"Borrado exitoso");
	}

	private boolean validate(TipoEleccion tipoEleccion) {
		boolean isValid = true;

		if (StringUtils.trimToNull(tipoEleccion.getNombreTipoEleccion()) == null) {
			isValid = false;
		}
		return isValid;
	}


}
