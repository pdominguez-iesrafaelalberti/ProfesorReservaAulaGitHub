package com.dwes.entidad;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity(name = "Aula")
@Table(name = "aulas")
public class Aula extends Auditoria{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String descripcion;
	
	@OneToMany
    private Set<AulaReservada> aulareservas  = new HashSet<>();
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public Aula(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Aula() {
	
	}

	public Set<AulaReservada> getAulareservas() {
		return aulareservas;
	}

	public void setAulareservas(Set<AulaReservada> aulareservas) {
		this.aulareservas = aulareservas;
	}
	
	
	
}
