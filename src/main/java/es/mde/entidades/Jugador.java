package es.mde.entidades;

import java.time.Instant;

public class Jugador {

	private String nombre;
	private String correo;
	private Instant fechaNacimiento;
	private boolean zurdo;
	private double altura;
	private boolean virgen;

	public Jugador() {
	}

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

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public boolean isVirgen() {
		return virgen;
	}

	public void setVirgen(boolean virgen) {
		this.virgen = virgen;
	}

}
