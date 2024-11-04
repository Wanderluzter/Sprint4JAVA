package br.com.fiap.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Peca {

    private int idPeca;
    private String nomePeca;
    private Double valorPeca;

    public Peca() {
        super();
    }

    public Peca(int idPeca, String nomePeca, Double valorPeca) {
        super();
        this.idPeca = idPeca;
        this.nomePeca = nomePeca;
        this.valorPeca = valorPeca;
    }

	public int getIdPeca() {
		return idPeca;
	}

	public void setIdPeca(int idPeca) {
		this.idPeca = idPeca;
	}

	public String getNomePeca() {
		return nomePeca;
	}

	public void setNomePeca(String nomePeca) {
		this.nomePeca = nomePeca;
	}

	public Double getValorPeca() {
		return valorPeca;
	}

	public void setValorPeca(Double valorPeca) {
		this.valorPeca = valorPeca;
	}

    
}
