package es.mde.entidades;

import java.util.ArrayList;
import java.util.Collection;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Equipo")
public class Equipo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true)
  private Long id;
  private String nombre;
  private boolean mixto;

  @OneToMany(cascade = CascadeType.ALL, targetEntity = Jugador.class, mappedBy = "equipo")
  private Collection<Jugador> jugadores = new ArrayList<>();


  public Equipo() {}

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public boolean isMixto() {
    return mixto;
  }

  public void setMixto(boolean mixto) {
    this.mixto = mixto;
  }

}
