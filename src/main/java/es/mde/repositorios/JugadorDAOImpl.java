package es.mde.repositorios;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import es.mde.entidades.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Representa la clase implementada con los metodos personalizados de los clientes 
 * @author JOSE LUIS PUENTES ALAMOS - MIGUEL PRADA MUNOZ
 *
 */
@Transactional(readOnly = true)
public class JugadorDAOImpl implements JugadorDAOCustom {

	@Autowired
	JugadorDAO jugadorDAO;
	@PersistenceContext
	EntityManager entityManager;

//	@Override
//	public List<Jugador> getProductosPagadosDeCliente(Long id) {
//		List<Producto> productos = clienteDAO.findById(id).get().getProductos().stream()
//				.filter(p -> p.isPagado() == true).collect(Collectors.toList());
//		return productos;
//	}

  @Override
  public List<Jugador> getJugadoresConNumeroDiez() {
    
    return jugadorDAO.findByNumero(10).stream().distinct().collect(Collectors.toList());
  }
}
