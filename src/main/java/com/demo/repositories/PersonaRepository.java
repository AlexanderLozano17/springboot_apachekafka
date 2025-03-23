package com.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.dto.PersonaDTO;
import com.demo.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	@Query("SELECT new com.demo.dto.PersonaDTO(p.id, p.nombres, p.apellidos, p.edad, p.email, p.telefono) FROM Persona p WHERE p.id = :id")
	Optional<PersonaDTO> findPersonaBasicById(@Param("id") Long id);

	@Query("SELECT new com.demo.dto.PersonaDTO(p.id, p.nombres, p.apellidos, p.edad, p.email, p.telefono) FROM Persona p")
	List<PersonaDTO> obtenerPersonas();

}
