package es.mde.repositorios;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import es.mde.entidades.Jugador;

/**
 * Representa la clase que contiene los Listeners de la entidad Cliente
 * 
 * @author JOSE LUIS PUENTES ALAMOS
 *
 */
@Component
public class JugadorListener {
	private Logger log = LoggerFactory.getLogger(JugadorListener.class);
	private JugadorDAO jugadorDAO;

	/**
	 * Crea un ClienteDAO
	 * 
	 * @param clienteDAO ClienteDAO inyectado
	 */
	@Autowired
	public void init(JugadorDAO jugadorDAO) {
		this.jugadorDAO = jugadorDAO;
	}

//	@PostPersist
//	public void preGuardar(Jugador jugador) {
//		System.err.println("Se va a guardar un cliente: " + cliente.getNombre());
//	}

	/**
	 * Crea un Listener que se ejecuta después de borrar un cliente
	 * 
	 * @param cliente Cliente que se ha borrado
	 */
//	@PostRemove
//	@PostPersist
//	public void postBorrar(Jugador jugador) {
//		System.err.println("Se ha creado el jugador: " + jugador.getNombre());
//	}

	 @PostPersist
	 public void postCrear(Jugador jugador) {
     log.error("Se ha creado el jugador: " + jugador.getNombre());
  }
	
	/**
	 * Crea un Listener que se ejecuta después de actualizar un cliente
	 * 
	 * @param cliente Cliente que se ha actualizado
	 */
//	@PostUpdate
//	public void postActualizar(Jugador jugador) {
//		System.err.println("Se ha actualizado al cliente: " + jugador.getNombre());
//	}

//	@PostLoad
//	public void postGuardar(Cliente cliente) {
//		log.warn("has guardado un cliente: " + cliente.getNombre());
//	}
}
