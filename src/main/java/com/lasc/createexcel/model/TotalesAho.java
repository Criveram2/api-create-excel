package com.lasc.createexcel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TotalesAho")
public class TotalesAho {

	private String totConsig;
	private String totIntereses;
	private String totRetiros;
	private String totRetFte;
	private String sdoDisponible;
	private String sdoCanje;
	private String sdoTotal;

	public TotalesAho() {

	}

	public TotalesAho(String totConsig, String totIntereses, String totRetiros, String totRetFte, String sdoDisponible,
			String sdoCanje, String sdoTotal) {
		super();
		this.totConsig = totConsig;
		this.totIntereses = totIntereses;
		this.totRetiros = totRetiros;
		this.totRetFte = totRetFte;
		this.sdoDisponible = sdoDisponible;
		this.sdoCanje = sdoCanje;
		this.sdoTotal = sdoTotal;
	}

	@XmlElement(name = "TotConsig")
	public String getTotConsig() {
		return totConsig;
	}

	public void setTotConsig(String totConsig) {
		this.totConsig = totConsig;
	}

	@XmlElement(name = "TotIntereses")
	public String getTotIntereses() {
		return totIntereses;
	}

	public void setTotIntereses(String totIntereses) {
		this.totIntereses = totIntereses;
	}

	@XmlElement(name = "TotRetiros")
	public String getTotRetiros() {
		return totRetiros;
	}

	public void setTotRetiros(String totRetiros) {
		this.totRetiros = totRetiros;
	}

	@XmlElement(name = "TotRetFte")
	public String getTotRetFte() {
		return totRetFte;
	}

	public void setTotRetFte(String totRetFte) {
		this.totRetFte = totRetFte;
	}

	@XmlElement(name = "SdoDisponible")
	public String getSdoDisponible() {
		return sdoDisponible;
	}

	public void setSdoDisponible(String sdoDisponible) {
		this.sdoDisponible = sdoDisponible;
	}

	@XmlElement(name = "SdoCanje")
	public String getSdoCanje() {
		return sdoCanje;
	}

	public void setSdoCanje(String sdoCanje) {
		this.sdoCanje = sdoCanje;
	}

	@XmlElement(name = "SdoTotal")
	public String getSdoTotal() {
		return sdoTotal;
	}

	public void setSdoTotal(String sdoTotal) {
		this.sdoTotal = sdoTotal;
	}

	@Override
	public String toString() {
		return "TotalesAho [totConsig=" + totConsig + ", totIntereses=" + totIntereses + ", totRetiros=" + totRetiros
				+ ", totRetFte=" + totRetFte + ", sdoDisponible=" + sdoDisponible + ", sdoCanje=" + sdoCanje
				+ ", sdoTotal=" + sdoTotal + "]";
	}

}
