package es.mde.entidades;

import java.util.ArrayList;
import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CAMISETAS_DE_FUTBOL")
public class Camiseta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true)
  private Long id;
  @Column(name = "lavadoEnSeco")
  @JsonProperty("Dry")
  private boolean lavableEnSeco;
  @Column(name = "numero-dorsal")
  private int numero;
  
  @OneToMany(cascade = CascadeType.ALL, targetEntity = Jugador.class, mappedBy = "camiseta")
  private Collection<Jugador> jugadores = new ArrayList<>();
  
  public boolean isLavabeEnSeco() {
    return lavableEnSeco;
  }

  public void setLavabeEnSeco(boolean lavabeEnSeco) {
    this.lavableEnSeco = lavabeEnSeco;
  }

  public int getNumero() {
    return numero;
  }

  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isLavableEnSeco() {
    return lavableEnSeco;
  }

  public void setLavableEnSeco(boolean lavableEnSeco) {
    this.lavableEnSeco = lavableEnSeco;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public Collection<Jugador> getJugadores() {
    return jugadores;
  }

  public void setJugadores(Collection<Jugador> jugadores) {
    this.jugadores = jugadores;
  }

  public void addJugador(Jugador jugador) {
    this.getJugadores().add(jugador);
    jugador.setCamiseta(this);
  }
  
  public Camiseta() {
  }
  
}
