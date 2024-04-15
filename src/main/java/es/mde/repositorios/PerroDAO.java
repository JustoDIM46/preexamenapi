package es.mde.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import es.mde.externas.Perro;

@RepositoryRestResource(path = "perros", itemResourceRel = "perro", collectionResourceRel = "perros")
public interface PerroDAO extends JpaRepository<Perro, Long> {

  @RestResource(exported = false)
  void deleteById(Long id);

  /**
   * Elimina un perro. No está expuesto
   * 
   * @param cliente Cliente a eliminar
   */
  @RestResource(exported = false)
  void delete(Perro perro);
}