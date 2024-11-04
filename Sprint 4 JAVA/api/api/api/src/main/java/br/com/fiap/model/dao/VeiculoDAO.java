package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.model.vo.Veiculo;

public class VeiculoDAO {

    private Connection minhaConexao;

    public VeiculoDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Veiculo veiculo) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "INSERT INTO VEICULO (PLACA, MODELO, MARCA, ANO, COR, APELIDO, QUILOMETRAGEM, EMAILDONO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getMarca());
            stmt.setInt(4, veiculo.getAno());
            stmt.setString(5, veiculo.getCor());
            stmt.setString(6, veiculo.getApelido());
            stmt.setDouble(7, veiculo.getQuilometragem());
            stmt.setString(8, veiculo.getEmailDono());
            stmt.execute();
            return "Veículo cadastrado com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Delete
    public String deletar(String placa) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement("DELETE FROM VEICULO WHERE PLACA = ?");
            stmt.setString(1, placa);
            stmt.execute();
            return "Veículo deletado com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Update
    public String atualizar(Veiculo veiculo) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = minhaConexao.prepareStatement(
                "UPDATE VEICULO SET MODELO = ?, MARCA = ?, ANO = ?, COR = ?, APELIDO = ?, QUILOMETRAGEM = ?, EMAILDONO = ? WHERE PLACA = ?");
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getMarca());
            stmt.setInt(3, veiculo.getAno());
            stmt.setString(4, veiculo.getCor());
            stmt.setString(5, veiculo.getApelido());
            stmt.setDouble(6, veiculo.getQuilometragem());
            stmt.setString(7, veiculo.getEmailDono());
            stmt.setString(8, veiculo.getPlaca());
            stmt.executeUpdate();
            return "Veículo atualizado com sucesso!";
        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    // Select
    public List<Veiculo> selecionar() throws SQLException {
        List<Veiculo> listaVeiculos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = minhaConexao.prepareStatement("SELECT * FROM VEICULO");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(rs.getString("PLACA"));
                veiculo.setModelo(rs.getString("MODELO"));
                veiculo.setMarca(rs.getString("MARCA"));
                veiculo.setAno(rs.getInt("ANO"));
                veiculo.setCor(rs.getString("COR"));
                veiculo.setApelido(rs.getString("APELIDO"));
                veiculo.setQuilometragem(rs.getDouble("QUILOMETRAGEM"));
                veiculo.setEmailDono(rs.getString("EMAILDONO"));
                listaVeiculos.add(veiculo);
            }
            return listaVeiculos;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null) minhaConexao.close();
        }
    }

    public Veiculo selecionarUm(String placa) throws SQLException {
        // Prepara a consulta SQL
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM VEICULO WHERE PLACA = ?");
        stmt.setString(1, placa); // Define a placa na consulta

        // Executa a consulta e obtém o ResultSet
        ResultSet rs = stmt.executeQuery();

        // Processa o resultado, se houver
        if (rs.next()) {
            Veiculo veiculo = new Veiculo();
            veiculo.setPlaca(rs.getString("PLACA")); // Preenche a placa
            veiculo.setModelo(rs.getString("MODELO")); // Preenche o modelo
            veiculo.setMarca(rs.getString("MARCA")); // Preenche a marca
            veiculo.setAno(rs.getInt("ANO")); // Preenche o ano
            veiculo.setCor(rs.getString("COR")); // Preenche a cor
            veiculo.setApelido(rs.getString("APELIDO")); // Preenche o apelido
            veiculo.setQuilometragem(rs.getDouble("QUILOMETRAGEM")); // Preenche a quilometragem
            veiculo.setEmailDono(rs.getString("EMAIL_DONO")); // Preenche o email do dono

            // Fecha recursos
            rs.close();
            stmt.close();
            minhaConexao.close();

            return veiculo; // Retorna o objeto Veiculo encontrado
        }

        // Fecha recursos caso não haja resultados
        rs.close();
        stmt.close();
        minhaConexao.close();
        return null; // Retorna null se não encontrar o veículo
    }

}
