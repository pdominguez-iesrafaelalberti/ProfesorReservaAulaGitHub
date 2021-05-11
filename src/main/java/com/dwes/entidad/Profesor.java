package com.dwes.entidad;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity(name = "Profesor")
@Table(name = "profesores")
public class Profesor extends Auditoria{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String nombre;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 15)
    private Departamento departamento;
	

	@OneToMany
    private Set<AulaReservada> aulareservadas = new HashSet<>();

	public Profesor(String nombre, Departamento departamento) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<AulaReservada> getAulareservadas() {
		return aulareservadas;
	}

	public void setAulareservadas(Set<AulaReservada> aulareservadas) {
		this.aulareservadas = aulareservadas;
	}

	public Profesor() {
		super();
	}
	
	
}
