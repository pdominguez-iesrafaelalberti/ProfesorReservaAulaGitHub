package com.dwes.entidad;


import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


import com.sun.istack.NotNull;

@Entity
@Table(name = "aulasreservadas")
public class AulaReservada extends Auditoria {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 @EmbeddedId
	 private AulaReservadaId id;
	 
	 @NotNull
	 private LocalDateTime reserva_fechahora;
	 
	    @ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("profesorId")
	    private Profesor profesor;
	 
	    @ManyToOne(fetch = FetchType.LAZY)
	    @MapsId("aulaId")
	    private Aula aula;
	 

	public LocalDateTime getReserva_fechahora() {
		return reserva_fechahora;
	}

	public void setReserva_fechahora(LocalDateTime reserva_fechahora) {
		this.reserva_fechahora = reserva_fechahora;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public AulaReservada(Aula aula, Profesor profesor) {
		super();
		this.profesor = profesor;
		this.aula = aula;
	  this.id = new AulaReservadaId(aula.getId(), profesor.getId());
	}

	public AulaReservada() {
		super();
	}
	 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        AulaReservada that = (AulaReservada) o;
        return Objects.equals(aula, that.aula) &&
               Objects.equals(profesor, that.profesor);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(aula, profesor);
    }
	 
}

