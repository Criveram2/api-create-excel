package com.lasc.createexcel.model;

public class Reporte {
	private String fecInicial;
	private String fecFinal;
	private String fechaGeneracion;
	private String hora;
	private String nombre;
	private String nit;
	private String cuenta;
	private String producto;

	private String fecha;
	private String concepto;
	private String documento;
	private String oficina;
	private String consignacion;
	private String retiro;
	private String saldo;
	private String codOperacion;
	private String refPago;

	private String totConsig;
	private String totIntereses;
	private String totRetiros;
	private String totRetFte;
	private String sdoDisponible;
	private String sdoCanje;
	private String sdoTotal;

	public Reporte() {
	}

	public Reporte(String fecInicial, String fecFinal, String fechaGeneracion, String hora, String nombre, String nit,
			String cuenta, String producto, String totConsig, String totIntereses, String totRetiros, String totRetFte,
			String sdoDisponible, String sdoCanje, String sdoTotal) {
		this.fecInicial = fecInicial;
		this.fecFinal = fecFinal;
		this.fechaGeneracion = fechaGeneracion;
		this.hora = hora;
		this.nombre = nombre;
		this.nit = nit;
		this.cuenta = cuenta;
		this.producto = producto;
		this.totConsig = totConsig;
		this.totIntereses = totIntereses;
		this.totRetiros = totRetiros;
		this.totRetFte = totRetFte;
		this.sdoDisponible = sdoDisponible;
		this.sdoCanje = sdoCanje;
		this.sdoTotal = sdoTotal;
	}

	public String getFecInicial() {
		return fecInicial;
	}

	public void setFecInicial(String fecInicial) {
		this.fecInicial = fecInicial;
	}

	public String getFecFinal() {
		return fecFinal;
	}

	public void setFecFinal(String fecFinal) {
		this.fecFinal = fecFinal;
	}

	public String getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getConsignacion() {
		return consignacion;
	}

	public void setConsignacion(String consignacion) {
		this.consignacion = consignacion;
	}

	public String getRetiro() {
		return retiro;
	}

	public void setRetiro(String retiro) {
		this.retiro = retiro;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getCodOperacion() {
		return codOperacion;
	}

	public void setCodOperacion(String codOperacion) {
		this.codOperacion = codOperacion;
	}

	public String getRefPago() {
		return refPago;
	}

	public void setRefPago(String refPago) {
		this.refPago = refPago;
	}

	public String getTotConsig() {
		return totConsig;
	}

	public void setTotConsig(String totConsig) {
		this.totConsig = totConsig;
	}

	public String getTotIntereses() {
		return totIntereses;
	}

	public void setTotIntereses(String totIntereses) {
		this.totIntereses = totIntereses;
	}

	public String getTotRetiros() {
		return totRetiros;
	}

	public void setTotRetiros(String totRetiros) {
		this.totRetiros = totRetiros;
	}

	public String getTotRetFte() {
		return totRetFte;
	}

	public void setTotRetFte(String totRetFte) {
		this.totRetFte = totRetFte;
	}

	public String getSdoDisponible() {
		return sdoDisponible;
	}

	public void setSdoDisponible(String sdoDisponible) {
		this.sdoDisponible = sdoDisponible;
	}

	public String getSdoCanje() {
		return sdoCanje;
	}

	public void setSdoCanje(String sdoCanje) {
		this.sdoCanje = sdoCanje;
	}

	public String getSdoTotal() {
		return sdoTotal;
	}

	public void setSdoTotal(String sdoTotal) {
		this.sdoTotal = sdoTotal;
	}

	@Override
	public String toString() {
		return "Reporte{" + "fecInicial=" + fecInicial + ", fecFinal=" + fecFinal + ", fechaGeneracion="
				+ fechaGeneracion + ", hora=" + hora + ", nombre=" + nombre + ", nit=" + nit + ", cuenta=" + cuenta
				+ ", producto=" + producto + ", fecha=" + fecha + ", concepto=" + concepto + ", documento=" + documento
				+ ", oficina=" + oficina + ", consignacion=" + consignacion + ", retiro=" + retiro + ", saldo=" + saldo
				+ ", codOperacion=" + codOperacion + ", refPago=" + refPago + ", totConsig=" + totConsig
				+ ", totIntereses=" + totIntereses + ", totRetiros=" + totRetiros + ", totRetFte=" + totRetFte
				+ ", sdoDisponible=" + sdoDisponible + ", sdoCanje=" + sdoCanje + ", sdoTotal=" + sdoTotal + '}';
	}

}
