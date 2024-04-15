package es.mde.rest;
import java.util.List;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import es.mde.entidades.Jugador;
import es.mde.repositorios.JugadorDAO;

/**
 * Controlador que maneja y expone los métodos personalizados de los clientes
 * 
 * @author JOSE LUIS PUENTES ALAMOS
 *
 */
@RepositoryRestController
@Configuration
public class JugadorController {

	private JugadorDAO jugadorDAO;

	public JugadorController(JugadorDAO jugadorDAO) {

		this.jugadorDAO = jugadorDAO;
	}
	
	@GetMapping("/jugadores/search/diez")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getJugadoresConNumeroDiez(
			PersistentEntityResourceAssembler assembler) {
		System.err.println("prueba");
		List<Jugador> jugadores = jugadorDAO.getJugadoresConNumeroDiez();
		return assembler.toCollectionModel(jugadores);
	}

}
