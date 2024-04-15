package es.mde.rest;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Clase que maneja los MixIns de la API
 * 
 * @author JOSE LUIS PUENTES ALAMOS
 *
 */
public class MixIns {
	
	/**
	 * Interfaz MixIn para la clase Jugador
	 * 
	 */
//	@JsonPropertyOrder({ "nombre", "correo" })
	@JsonIgnoreProperties({"altura"})//si quiero que en el GET no me incluya una propiedad...
	public static interface Jugadores {
	}
	
	/**
	 * Interfaz MixIn para la clase Equipo
	 * 
	 */
//	@JsonPropertyOrder({ "nombre", "autor" })
	public static interface Equipos {
	}
	
	/**
	 * Interfaz MixIn para la clase Camiseta
	 * 
	 */
//	@JsonPropertyOrder({ "nombre", "hojas" })
	
	public static interface Camisetas {
	  @JsonPropertyOrder({ "dry" })  
	  boolean isLavabeEnSeco();
	}

}
