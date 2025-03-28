package com.demo.core.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.core.dto.PublicacionDTO;
import com.demo.core.entities.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

	@EntityGraph(attributePaths = {"persona"})
	Optional<Publicacion> findById(Long id);
		
	@Query("SELECT new com.demo.core.dto.PublicacionDTO(p.id, p.titulo, p.contenido, p.fechaPublicacion) FROM Publicacion p WHERE p.id = :id")
	Optional<PublicacionDTO> obtenerPublicacionId(@Param("id") Long id);
	
	@Query("SELECT new com.demo.core.dto.PublicacionDTO(p.id, p.titulo, p.contenido, p.fechaPublicacion) FROM Publicacion p")
	List<PublicacionDTO> obtenerPublicaciones();
}
