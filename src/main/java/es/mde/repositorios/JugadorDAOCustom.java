package es.mde.repositorios;

import java.util.List;
import es.mde.entidades.Jugador;


public interface JugadorDAOCustom {

  List<Jugador> getJugadoresConNumeroDiez();

  List<Jugador> getJugadoresConNumero(int numero);
}
