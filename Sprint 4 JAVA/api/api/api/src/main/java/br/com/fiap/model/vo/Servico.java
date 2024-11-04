package br.com.fiap.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Servico {

    private String nomeServ;
    private Integer duracaoServ;
    private Double valorServ;

    public Servico() {
        super();
    }

    public Servico(String nomeServ, Integer duracaoServ, Double valorServ) {
        super();
        this.nomeServ = nomeServ;
        this.duracaoServ = duracaoServ;
        this.valorServ = valorServ;
    }

	public String getNomeServ() {
		return nomeServ;
	}

	public void setNomeServ(String nomeServ) {
		this.nomeServ = nomeServ;
	}

	public Integer getDuracaoServ() {
		return duracaoServ;
	}

	public void setDuracaoServ(Integer duracaoServ) {
		this.duracaoServ = duracaoServ;
	}

	public Double getValorServ() {
		return valorServ;
	}

	public void setValorServ(Double valorServ) {
		this.valorServ = valorServ;
	}

    
}
