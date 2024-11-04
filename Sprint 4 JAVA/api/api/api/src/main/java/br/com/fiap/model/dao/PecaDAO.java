package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.model.vo.Peca;

public class PecaDAO {

    public Connection minhaConexao;

    public PecaDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Peca peca) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "INSERT INTO PECA (ID_PECA, NOME_PECA, VALOR_PECA) VALUES (?, ?, ?)");
            stmt.setInt(1, peca.getIdPeca());
            stmt.setString(2, peca.getNomePeca());
            stmt.setDouble(3, peca.getValorPeca());
            stmt.execute();
            return "Peça cadastrada com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Delete
    public String deletar(int idPeca) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement("DELETE FROM PECA WHERE ID_PECA = ?");
            stmt.setInt(1, idPeca);
            stmt.execute();
            return "Peça deletada com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Update
    public String atualizar(Peca peca) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "UPDATE PECA SET NOME_PECA = ?, VALOR_PECA = ? WHERE ID_PECA = ?");
            stmt.setString(1, peca.getNomePeca());
            stmt.setDouble(2, peca.getValorPeca());
            stmt.setInt(3, peca.getIdPeca());
            stmt.executeUpdate();
            return "Peça atualizada com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Select all
    public List<Peca> selecionar() throws SQLException {
        List<Peca> listaPecas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = minhaConexao.prepareStatement("SELECT * FROM PECA");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Peca peca = new Peca();
                peca.setIdPeca(rs.getInt("ID_PECA"));
                peca.setNomePeca(rs.getString("NOME_PECA"));
                peca.setValorPeca(rs.getDouble("VALOR_PECA"));
                listaPecas.add(peca);
            }
            return listaPecas;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Select one
    public Peca selecionarUm(int idPeca) throws SQLException {
        Peca peca = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = minhaConexao.prepareStatement("SELECT * FROM PECA WHERE ID_PECA = ?");
            stmt.setInt(1, idPeca);
            rs = stmt.executeQuery();
            if (rs.next()) {
                peca = new Peca();
                peca.setIdPeca(rs.getInt("ID_PECA"));
                peca.setNomePeca(rs.getString("NOME_PECA"));
                peca.setValorPeca(rs.getDouble("VALOR_PECA"));
            }
            return peca;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }
}
