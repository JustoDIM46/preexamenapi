package es.mde.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import es.mde.entidades.Jugador;

@RepositoryRestResource(path = "jugadores", itemResourceRel = "jugador", collectionResourceRel = "jugadores")
public interface JugadorDAO extends JpaRepository<Jugador, Long> {

  @RestResource(path = "por-altura")
  List<Jugador> findByAltura(@Param(value = "medida") int medida);
  
  @RestResource(path = "por-numero")
  List<Jugador> findByNumero(@Param(value = "numero") int numero);
  
  @RestResource(path = "diez")
  List<Jugador> getJugadoresConNumeroDiez();
}
