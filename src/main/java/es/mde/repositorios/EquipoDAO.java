package es.mde.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import es.mde.entidades.Equipo;

@RepositoryRestResource(path = "equipos", itemResourceRel = "equipo", collectionResourceRel = "equipos")
public interface EquipoDAO extends JpaRepository<Equipo, Long> {

}
