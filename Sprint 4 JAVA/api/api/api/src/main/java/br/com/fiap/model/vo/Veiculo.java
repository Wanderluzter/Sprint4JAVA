package br.com.fiap.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Veiculo {

    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private String cor;
    private String apelido;
    private Double quilometragem;
    private String emailDono;

    public Veiculo() {
        super();
    }

    public Veiculo(String placa, String modelo, String marca, int ano, String cor, String apelido, Double quilometragem, String emailDono) {
        super();
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
        this.apelido = apelido;
        this.quilometragem = quilometragem;
        this.emailDono = emailDono;
    }

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public String getEmailDono() {
		return emailDono;
	}

	public void setEmailDono(String emailDono) {
		this.emailDono = emailDono;
	}

    
}
