package es.mde.entidades;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import es.mde.repositorios.JugadorListener;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Jugador")
@EntityListeners(JugadorListener.class)
public class Jugador {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true)
  private Long id;
  private String nombre;
  private String correo;
  private Instant fechaNacimiento;
  private boolean zurdo;
  private int altura;
  private transient boolean virgen;
  private int numero;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EQUIPO")
  private Equipo equipo;

  @OneToMany(cascade = CascadeType.ALL, targetEntity = Camiseta.class, mappedBy = "jugador")
  private Collection<Camiseta> camisetas = new ArrayList<>();

  public Jugador() {}

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public Instant getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Instant fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public boolean isZurdo() {
    return zurdo;
  }

  public void setZurdo(boolean zurdo) {
    this.zurdo = zurdo;
  }

  public int getAltura() {
    return altura;
  }

  public void setAltura(int altura) {
    this.altura = altura;
  }

  public boolean isVirgen() {
    return virgen;
  }

  public void setVirgen(boolean virgen) {
    this.virgen = virgen;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Equipo getEquipo() {
    return equipo;
  }

  public void setEquipo(Equipo equipo) {
    this.equipo = equipo;
  }

  
  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public Collection<Camiseta> getCamisetas() {
    return camisetas;
  }

  public void setCamisetas(Collection<Camiseta> camisetas) {
    this.camisetas = camisetas;
  }

  public void addCamiseta(Camiseta camiseta) {
    this.getCamisetas().add(camiseta);
    camiseta.setJugador(this);
}


}
