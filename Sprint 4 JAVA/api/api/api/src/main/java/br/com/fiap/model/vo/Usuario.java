package br.com.fiap.model.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {

    private String emailUs;
    private String nome;
    private String telefone;
    private String senha;
    private String enderecoUs;

    public Usuario() {
        super();
    }

    public Usuario(String emailUs, String nome, String telefone, String senha, String enderecoUs) {
        super();
        this.emailUs = emailUs;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.enderecoUs = enderecoUs;
    }

    public String getEmailUs() {
        return emailUs;
    }

    public void setEmailUs(String emailUs) {
        this.emailUs = emailUs;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEnderecoUs() {
        return enderecoUs;
    }

    public void setEnderecoUs(String enderecoUs) {
        this.enderecoUs = enderecoUs;
    }
}
