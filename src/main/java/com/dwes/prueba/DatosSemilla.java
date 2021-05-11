package com.dwes.prueba;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.dwes.entidad.Aula;
import com.dwes.entidad.AulaReservada;
import com.dwes.entidad.Departamento;
import com.dwes.entidad.Profesor;
import com.dwes.repositorio.AulaRepositorio;
import com.dwes.repositorio.AulaReservadaRepositorio;
import com.dwes.repositorio.ProfesorRepositorio;

@Component
public class DatosSemilla implements CommandLineRunner {
	
	@Autowired
	private AulaRepositorio aularepositorio;
	
	
	@Autowired
	private ProfesorRepositorio profesorrepositorio;
	
	@Autowired
	private AulaReservadaRepositorio aulareservadarepositorio;
	

	@Override
	public void run(String... args) throws Exception {
		aulareservadarepositorio.deleteAllInBatch();
		aularepositorio.deleteAllInBatch();
		profesorrepositorio.deleteAllInBatch();
		/**
		 * Creación de las Aulas	
		 */
		
		Aula aula0 = new Aula("BIBLIOTECA", "Aula de Docencia");
		Aula aula1 = new Aula("AULA 017", "Aula de Docencia");
		Aula aula2 = new Aula("AULA 022", "Aula de Ordenadores");
		Aula aula3 = new Aula("AULA 021", "Aula de Ordenadores");
		Aula aula4 = new Aula("AULA 130", "Aula de Ordenadores");
		
		aularepositorio.save(aula0);
		aularepositorio.save(aula1);
		aularepositorio.save(aula2);
		aularepositorio.save(aula3);
		aularepositorio.save(aula4);
		
		/**
		 * Creación de profesores
		 */
		Profesor prof1 = new Profesor("EVA", Departamento.TECNOLOGIA);
		Profesor prof2 = new Profesor("PAOLO", Departamento.INFORMATICA);
		profesorrepositorio.save(prof1);
		profesorrepositorio.save(prof2);

		
		/**
		 * Reserva de Aulas
		 */
		// 11 de Mayo de 2021 a las 10:34
		LocalDateTime datetime1 = LocalDateTime.of(2021, 5, 11, 10, 30);  
	    
		LocalDateTime datetime2 = LocalDateTime.now();  
	    /** DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	    String formatDateTime = now.format(format); */

		// PAOLO de INFORMATICA reserva el dia 11 de Mayo de 2021 a las 10.30
		AulaReservada aulareservada = new AulaReservada(aula0, prof1);
		aulareservada.setReserva_fechahora(datetime1);
		aulareservadarepositorio.save(aulareservada);
		
		AulaReservada aulareservada2 = new AulaReservada(aula0, prof2);
		aulareservada.setReserva_fechahora(datetime2);
		aulareservadarepositorio.save(aulareservada2);
		
		AulaReservada aulareservada3 = new AulaReservada(aula2, prof1);
		aulareservada.setReserva_fechahora(datetime2);
		aulareservadarepositorio.save(aulareservada3);
	
	}
}
