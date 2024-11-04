package br.com.fiap.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.dao.VeiculoDAO;
import br.com.fiap.model.vo.Veiculo;


public class VeiculoBO {

    private VeiculoDAO veiculoDAO = null;

    // Inserir
    public void inserirBO(Veiculo veiculo) throws ClassNotFoundException, SQLException {
        veiculoDAO = new VeiculoDAO();
        
        // Aplicação de regras de negócio... (se houver)

        veiculoDAO.inserir(veiculo);
    }

    // Atualizar
    public void atualizarBO(Veiculo veiculo) throws ClassNotFoundException, SQLException {
        veiculoDAO = new VeiculoDAO();

        // Aplicação de regras de negócio... (se houver)

        veiculoDAO.atualizar(veiculo);
    }

    // Deletar
    public void deletarBO(String placa) throws ClassNotFoundException, SQLException {
        veiculoDAO = new VeiculoDAO();

        // Aplicação de regras de negócio... (se houver)

        veiculoDAO.deletar(placa);
    }

    // Selecionar todos os veículos
    public ArrayList<Veiculo> selecionarBO() throws ClassNotFoundException, SQLException {
        veiculoDAO = new VeiculoDAO();
        return (ArrayList<Veiculo>) veiculoDAO.selecionar();
    }

    // Selecionar um veículo específico
    public Veiculo selecionarUmBO(String placa) throws ClassNotFoundException, SQLException {
        veiculoDAO = new VeiculoDAO();

        // Aplicação de regras de negócio... (se houver)

        return veiculoDAO.selecionarUm(placa);
    }
}
