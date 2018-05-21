package com.lasc.createexcel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cliente")
public class Cliente {

	private String fecInicial;
	private String fecFinal;
	private String fechaGeneracion;
	private String hora;
	private String nombre;
	private String nit;
	private String cuenta;
	private String producto;

	public Cliente() {

	}

	public Cliente(String fecInicial, String fecFinal, String fechaGeneracion, String hora, String nombre, String nit,
			String cuenta, String producto) {
		super();
		this.fecInicial = fecInicial;
		this.fecFinal = fecFinal;
		this.fechaGeneracion = fechaGeneracion;
		this.hora = hora;
		this.nombre = nombre;
		this.nit = nit;
		this.cuenta = cuenta;
		this.producto = producto;
	}

	@XmlElement(name = "FecInicial")
	public String getFecInicial() {
		return fecInicial;
	}

	public void setFecInicial(String fecInicial) {
		this.fecInicial = fecInicial;
	}

	@XmlElement(name = "FecFinal")
	public String getFecFinal() {
		return fecFinal;
	}

	public void setFecFinal(String fecFinal) {
		this.fecFinal = fecFinal;
	}

	@XmlElement(name = "FechaGeneracion")
	public String getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	@XmlElement(name = "Hora")
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@XmlElement(name = "Nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement(name = "Nit")
	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	@XmlElement(name = "Cuenta")
	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	@XmlElement(name = "Poducto")
	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Cliente [fecInicial=" + fecInicial + ", fecFinal=" + fecFinal + ", fechaGeneracion=" + fechaGeneracion
				+ ", hora=" + hora + ", nombre=" + nombre + ", nit=" + nit + ", cuenta=" + cuenta + ", producto="
				+ producto + "]";
	}

}
