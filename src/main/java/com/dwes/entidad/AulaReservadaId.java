package com.dwes.entidad;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AulaReservadaId implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 7526053447149525349L;

	@Column(name = "aula_id")
    private Long aulaId;
 
    @Column(name = "profesor_id")
    private Long profesorId;
 
    @SuppressWarnings("unused")
	private AulaReservadaId(){
    	
    }
 
    public AulaReservadaId(
        Long aulaId,
        Long profesorId) {
        this.aulaId = aulaId;
        this.profesorId = profesorId;
    }
 
    //Getters omitted for brevity
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        AulaReservadaId that = (AulaReservadaId) o;
        return Objects.equals(aulaId, that.aulaId) &&
               Objects.equals(profesorId, that.profesorId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(aulaId, profesorId);
    }
}
    
