package es.mde.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import es.mde.entidades.Camiseta;
import es.mde.entidades.Jugador;

@RepositoryRestResource(path = "camisetas", itemResourceRel = "camiseta", collectionResourceRel = "camisetas")
public interface CamisetaDAO extends JpaRepository<Camiseta, Long>{

  @RestResource(path = "numero")
  List<Camiseta> findByNumero(int numero);
}
