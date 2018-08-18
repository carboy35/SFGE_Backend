package com.adexus.SFGE_Backend.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tipo_eleccion")
@Access(AccessType.FIELD)
public class TipoEleccion extends ParentEntity {

	private static final long serialVersionUID = -1409021843644860526L;

	@Column(name="nombre_tipo_eleccion", nullable=false,length=255)
	private String nombreTipoEleccion;
	
	public String getNombreTipoEleccion() {
		return nombreTipoEleccion;
	}
	public void setNombreTipoEleccion(String nombreTipoEleccion) {
		this.nombreTipoEleccion = nombreTipoEleccion;
	}
	    


	
}
