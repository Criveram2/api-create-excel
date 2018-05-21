package com.lasc.createexcel.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Resultado")
public class Resultado {
	private int codigo;
	private String msg;
	private String urlFile;

	public Resultado(int codigo, String msg, String urlFile) {
		this.codigo = codigo;
		this.msg = msg;
		this.urlFile = urlFile;

	}

	public Resultado() {
	}

	@XmlElement(name = "Codigo")
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@XmlElement(name = "Msg")
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@XmlElement(name = "UrlFile")
	public String getUrlFile() {
		return urlFile;
	}

	public void setUrlFile(String urlFile) {
		this.urlFile = urlFile;
	}

	@Override
	public String toString() {
		return "Resultado[" + "codigo=" + codigo + ", msg=" + msg + ", urlFile=" + urlFile + ']';
	}

}
