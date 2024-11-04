package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.model.vo.Servico;

public class ServicoDAO {

    private Connection minhaConexao;

    public ServicoDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Servico servico) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "INSERT INTO SERVICO (NOME_SERV, DURACAO_SERV, VALOR_SERV) VALUES (?, ?, ?)");
            stmt.setString(1, servico.getNomeServ());
            stmt.setInt(2, servico.getDuracaoServ());
            stmt.setDouble(3, servico.getValorServ());
            stmt.execute();
            return "Serviço cadastrado com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Delete
    public String deletar(String nmServico) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement("DELETE FROM SERVICO WHERE NOME_SERV = ?");
            stmt.setString(1, nmServico);
            stmt.execute();
            return "Serviço deletado com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Update
    public String atualizar(Servico servico) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "UPDATE SERVICO SET DURACAO_SERV = ?, VALOR_SERV = ? WHERE NOME_SERV = ?");
            stmt.setInt(1, servico.getDuracaoServ());
            stmt.setDouble(2, servico.getValorServ());
            stmt.setString(3, servico.getNomeServ());
            stmt.executeUpdate();
            return "Serviço atualizado com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Select
    public List<Servico> selecionar() throws SQLException {
        List<Servico> listaServicos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = minhaConexao.prepareStatement("SELECT * FROM SERVICO");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Servico servico = new Servico();
                servico.setNomeServ(rs.getString("NOME_SERV"));
                servico.setDuracaoServ(rs.getInt("DURACAO_SERV"));
                servico.setValorServ(rs.getDouble("VALOR_SERV"));
                listaServicos.add(servico);
            }
            return listaServicos;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    public Servico selecionarUm(int idServico) throws SQLException {
        // Prepara a consulta SQL
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM SERVICO WHERE ID_SERVICO = ?");
        stmt.setInt(1, idServico);  // Ajusta para usar o tipo inteiro para idServico

        // Executa a consulta e obtém o ResultSet
        ResultSet rs = stmt.executeQuery();

        // Processa o resultado, se houver
        if (rs.next()) {
            Servico servico = new Servico();
            servico.setNomeServ(rs.getString("NOME_SERV")); // Preenche nomeServ
            servico.setDuracaoServ(rs.getInt("DURACAO_SERV")); // Preenche duracaoServ
            servico.setValorServ(rs.getDouble("VALOR_SERV")); // Preenche valorServ

            // Fecha recursos
            rs.close();
            stmt.close();
            minhaConexao.close();

            return servico; // Retorna o objeto Servico encontrado
        }

        // Fecha recursos caso não haja resultados
        rs.close();
        stmt.close();
        minhaConexao.close();
        return null; // Retorna null se não encontrar o serviço
    }

}
