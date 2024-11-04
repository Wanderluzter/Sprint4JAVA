package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.model.vo.Diagnostico;

public class DiagnosticoDAO {

    private Connection minhaConexao;

    public DiagnosticoDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Diagnostico diagnostico) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "INSERT INTO DIAGNOSTICO (ID_DIAG, DESC_DIAG, DATA_DIAG, VEICULO_DIAG, SERVICO_DIAG, PECA_DIAG) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, diagnostico.getIdDiag());
            stmt.setString(2, diagnostico.getDescDiag());
            stmt.setDate(3, diagnostico.getDataDiag());
            stmt.setString(4, diagnostico.getVeiculoDiag());
            stmt.setString(5, diagnostico.getServicoDiag());
            stmt.setInt(6, diagnostico.getPecaDiag());
            stmt.execute();
            return "Diagnóstico cadastrado com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Delete
    public String deletar(int idDiag) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement("DELETE FROM DIAGNOSTICO WHERE ID_DIAG = ?");
            stmt.setInt(1, idDiag);
            stmt.execute();
            return "Diagnóstico deletado com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Update
    public String atualizar(Diagnostico diagnostico) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "UPDATE DIAGNOSTICO SET DESC_DIAG = ?, DATA_DIAG = ?, VEICULO_DIAG = ?, SERVICO_DIAG = ?, PECA_DIAG = ? WHERE ID_DIAG = ?");
            stmt.setString(1, diagnostico.getDescDiag());
            stmt.setDate(2, diagnostico.getDataDiag());
            stmt.setString(3, diagnostico.getVeiculoDiag());
            stmt.setString(4, diagnostico.getServicoDiag());
            stmt.setInt(5, diagnostico.getPecaDiag());
            stmt.setInt(6, diagnostico.getIdDiag());
            stmt.executeUpdate();
            return "Diagnóstico atualizado com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Select
    public List<Diagnostico> selecionar() throws SQLException {
        List<Diagnostico> listaDiagnosticos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = minhaConexao.prepareStatement("SELECT * FROM DIAGNOSTICO");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Diagnostico diagnostico = new Diagnostico();
                diagnostico.setIdDiag(rs.getInt("ID_DIAG"));
                diagnostico.setDescDiag(rs.getString("DESC_DIAG"));
                diagnostico.setDataDiag(rs.getDate("DATA_DIAG"));
                diagnostico.setVeiculoDiag(rs.getString("VEICULO_DIAG"));
                diagnostico.setServicoDiag(rs.getString("SERVICO_DIAG"));
                diagnostico.setPecaDiag(rs.getInt("PECA_DIAG"));
                listaDiagnosticos.add(diagnostico);
            }
            return listaDiagnosticos;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    public Diagnostico selecionarUm(int idDiag) throws SQLException {
        // Prepara a consulta SQL
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM DIAGNOSTICO WHERE ID_DIAG = ?");
        stmt.setInt(1, idDiag);
        
        // Executa a consulta e obtém o ResultSet
        ResultSet rs = stmt.executeQuery();

        // Processa o resultado, se houver
        if (rs.next()) {
            Diagnostico diagnostico = new Diagnostico();
            diagnostico.setIdDiag(rs.getInt("ID_DIAG"));
            diagnostico.setDescDiag(rs.getString("DESC_DIAG"));
            diagnostico.setDataDiag(rs.getDate("DATA_DIAG"));
            diagnostico.setVeiculoDiag(rs.getString("VEICULO_DIAG"));
            diagnostico.setServicoDiag(rs.getString("SERVICO_DIAG"));
            diagnostico.setPecaDiag(rs.getInt("PECA_DIAG"));
            
            // Fecha recursos
            rs.close();
            stmt.close();
            minhaConexao.close();
            
            return diagnostico;
        }

        // Fecha recursos caso não haja resultados
        rs.close();
        stmt.close();
        minhaConexao.close();
        return null;
    }
}
