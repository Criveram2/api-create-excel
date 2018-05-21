package com.lasc.createexcel.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ExtAhorros")
public class ExtAhorros {

	private Cliente cliente;
	private List<Movimientos> movimientos;
	private TotalesAho totalesAhorros;
	private String nombreArchivo;
	private String rutaDestino;

	public ExtAhorros() {

	}

	public ExtAhorros(Cliente cliente, List<Movimientos> movimientos, TotalesAho totalesAhorros, String nombreArchivo) {
		super();
		this.cliente = cliente;
		this.movimientos = movimientos;
		this.totalesAhorros = totalesAhorros;
		this.nombreArchivo = nombreArchivo;
	}

	@XmlElement(name = "Cliente")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@XmlElement(name = "Movimientos")
	public List<Movimientos> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimientos> movimientos) {
		this.movimientos = movimientos;
	}

	@XmlElement(name = "TotalesAho")
	public TotalesAho getTotalesAhorros() {
		return totalesAhorros;
	}

	public void setTotalesAhorros(TotalesAho totalesAhorros) {
		this.totalesAhorros = totalesAhorros;
	}

	@XmlElement(name = "NombreArchivo")
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	@XmlElement(name = "RutaDestino")
	public String getRutaDestino() {
		return rutaDestino;
	}

	public void setRutaDestino(String rutaDestino) {
		this.rutaDestino = rutaDestino;
	}

	@Override
	public String toString() {
		return "ExtAhorros [cliente=" + cliente + ", movimientos=" + movimientos + ", totalesAhorros=" + totalesAhorros
				+ ", nombreArchivo=" + nombreArchivo + ", rutaDestino=" + rutaDestino + "]";
	}

}
