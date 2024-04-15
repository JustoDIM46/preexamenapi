package es.mde.repositorios;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "camisetas", itemResourceRel = "camiseta", collectionResourceRel = "camisetas")
public interface CamisetaDAO {

}
