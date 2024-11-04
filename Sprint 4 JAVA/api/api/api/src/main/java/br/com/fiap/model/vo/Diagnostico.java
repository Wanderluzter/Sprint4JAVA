package br.com.fiap.model.vo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Diagnostico {

    private int idDiag;
    private Date dataDiag;
    private String descDiag;
    private String veiculoDiag;
    private String servicoDiag;
    private int pecaDiag;

    public Diagnostico() {
        super();
    }

    public Diagnostico(int idDiag, Date dataDiag, String descDiag, String veiculoDiag, String servicoDiag, int pecaDiag) {
        super();
        this.idDiag = idDiag;
        this.dataDiag = dataDiag;
        this.descDiag = descDiag;
        this.veiculoDiag = veiculoDiag;
        this.servicoDiag = servicoDiag;
        this.pecaDiag = pecaDiag;
    }

	public int getIdDiag() {
		return idDiag;
	}

	public void setIdDiag(int idDiag) {
		this.idDiag = idDiag;
	}

	public java.sql.Date getDataDiag() {
		return (java.sql.Date) dataDiag;
	}

	public void setDataDiag(Date dataDiag) {
		this.dataDiag = dataDiag;
	}

	public String getDescDiag() {
		return descDiag;
	}

	public void setDescDiag(String descDiag) {
		this.descDiag = descDiag;
	}

	public String getVeiculoDiag() {
		return veiculoDiag;
	}

	public void setVeiculoDiag(String veiculoDiag) {
		this.veiculoDiag = veiculoDiag;
	}

	public String getServicoDiag() {
		return servicoDiag;
	}

	public void setServicoDiag(String servicoDiag) {
		this.servicoDiag = servicoDiag;
	}

	public int getPecaDiag() {
		return pecaDiag;
	}

	public void setPecaDiag(int pecaDiag) {
		this.pecaDiag = pecaDiag;
	}

    
}
