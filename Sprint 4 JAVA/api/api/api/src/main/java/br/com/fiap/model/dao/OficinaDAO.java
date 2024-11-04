package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.model.vo.Oficina;

public class OficinaDAO {

    private Connection minhaConexao;

    public OficinaDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Oficina oficina) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "INSERT INTO OFICINA (EMAIL_OF, NOME_OF, ENDERECO_OF, TELEFONE_OF) VALUES (?, ?, ?, ?)");
            stmt.setString(1, oficina.getEmailOf());
            stmt.setString(2, oficina.getNomeOf());
            stmt.setString(3, oficina.getEnderecoOf());
            stmt.setString(4, oficina.getTelefoneOf());
            stmt.execute();
            return "Oficina cadastrada com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Delete
    public String deletar(String emailOf) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement("DELETE FROM OFICINA WHERE EMAIL_OF = ?");
            stmt.setString(1, emailOf);
            stmt.execute();
            return "Oficina deletada com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Update
    public String atualizar(Oficina oficina) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "UPDATE OFICINA SET NOME_OF = ?, ENDERECO_OF = ?, TELEFONE_OF = ? WHERE EMAIL_OF = ?");
            stmt.setString(1, oficina.getNomeOf());
            stmt.setString(2, oficina.getEnderecoOf());
            stmt.setString(3, oficina.getTelefoneOf());
            stmt.setString(4, oficina.getEmailOf());
            stmt.executeUpdate();
            return "Oficina atualizada com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Select
    public List<Oficina> selecionar() throws SQLException {
        List<Oficina> listaOficinas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = minhaConexao.prepareStatement("SELECT * FROM OFICINA");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Oficina oficina = new Oficina();
                oficina.setEmailOf(rs.getString("EMAIL_OF"));
                oficina.setNomeOf(rs.getString("NOME_OF"));
                oficina.setEnderecoOf(rs.getString("ENDERECO_OF"));
                oficina.setTelefoneOf(rs.getString("TELEFONE_OF"));
                listaOficinas.add(oficina);
            }
            return listaOficinas;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    public Oficina selecionarUm(String emailOf) throws SQLException {
        // Prepara a consulta SQL
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM OFICINA WHERE EMAIL_OF = ?");
        stmt.setString(1, emailOf);

        // Executa a consulta e obtém o ResultSet
        ResultSet rs = stmt.executeQuery();

        // Processa o resultado, se houver
        if (rs.next()) {
            Oficina oficina = new Oficina();
            oficina.setEmailOf(rs.getString("EMAIL_OF"));
            oficina.setNomeOf(rs.getString("NOME_OF"));
            oficina.setEnderecoOf(rs.getString("ENDERECO_OF"));
            oficina.setTelefoneOf(rs.getString("TELEFONE_OF"));

            // Fecha recursos
            rs.close();
            stmt.close();
            minhaConexao.close();

            return oficina;
        }

        // Fecha recursos caso não haja resultados
        rs.close();
        stmt.close();
        minhaConexao.close();
        return null;
    }

}
