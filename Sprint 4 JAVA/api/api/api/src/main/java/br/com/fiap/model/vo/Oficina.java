package br.com.fiap.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Oficina {

    private String emailOf;
    private String nomeOf;
    private String telefoneOf;
    private String enderecoOf;

    public Oficina() {
        super();
    }

    public Oficina(String emailOf, String nomeOf, String telefoneOf, String enderecoOf) {
        super();
        this.emailOf = emailOf;
        this.nomeOf = nomeOf;
        this.telefoneOf = telefoneOf;
        this.enderecoOf = enderecoOf;
    }

	public String getEmailOf() {
		return emailOf;
	}

	public void setEmailOf(String emailOf) {
		this.emailOf = emailOf;
	}

	public String getNomeOf() {
		return nomeOf;
	}

	public void setNomeOf(String nomeOf) {
		this.nomeOf = nomeOf;
	}

	public String getTelefoneOf() {
		return telefoneOf;
	}

	public void setTelefoneOf(String telefoneOf) {
		this.telefoneOf = telefoneOf;
	}

	public String getEnderecoOf() {
		return enderecoOf;
	}

	public void setEnderecoOf(String enderecoOf) {
		this.enderecoOf = enderecoOf;
	}

    
}
