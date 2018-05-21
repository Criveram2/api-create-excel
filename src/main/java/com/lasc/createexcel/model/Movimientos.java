package com.lasc.createexcel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Movimientos")
public class Movimientos {
	private String fecha;
	private String concepto;
	private String documento;
	private String oficina;
	private String consignacion;
	private String retiro;
	private String saldo;
	private String codOperacion;
	private String refPago;

	public Movimientos() {

	}

	public Movimientos(String fecha, String concepto, String documento, String oficina, String consignacion,
			String retiro, String saldo, String codOperacion, String refPago) {
		super();
		this.fecha = fecha;
		this.concepto = concepto;
		this.documento = documento;
		this.oficina = oficina;
		this.consignacion = consignacion;
		this.retiro = retiro;
		this.saldo = saldo;
		this.codOperacion = codOperacion;
		this.refPago = refPago;
	}

	@XmlElement(name = "Fecha")
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@XmlElement(name = "Concepto")
	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	@XmlElement(name = "Documento")
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@XmlElement(name = "Oficina")
	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	@XmlElement(name = "Consignacion")
	public String getConsignacion() {
		return consignacion;
	}

	public void setConsignacion(String consignacion) {
		this.consignacion = consignacion;
	}

	@XmlElement(name = "Retiro")
	public String getRetiro() {
		return retiro;
	}

	public void setRetiro(String retiro) {
		this.retiro = retiro;
	}

	@XmlElement(name = "Saldo")
	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	@XmlElement(name = "CodOperacion")
	public String getCodOperacion() {
		return codOperacion;
	}

	public void setCodOperacion(String codOperacion) {
		this.codOperacion = codOperacion;
	}

	@XmlElement(name = "RefPago")
	public String getRefPago() {
		return refPago;
	}

	public void setRefPago(String refPago) {
		this.refPago = refPago;
	}

	@Override
	public String toString() {
		return "Movimientos [fecha=" + fecha + ", concepto=" + concepto + ", documento=" + documento + ", oficina="
				+ oficina + ", consignacion=" + consignacion + ", retiro=" + retiro + ", saldo=" + saldo
				+ ", codOperacion=" + codOperacion + ", refPago=" + refPago + "]";
	}

}
