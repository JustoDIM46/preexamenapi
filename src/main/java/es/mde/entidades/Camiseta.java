package es.mde.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
  
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "JUGADOR")
  private Jugador jugador;
  
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

  public Jugador getJugador() {
    return jugador;
  }

  public void setJugador(Jugador jugador) {
    this.jugador = jugador;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public Camiseta() {
  }
  
}
