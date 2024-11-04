package br.com.fiap.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.model.dao.ServicoDAO;
import br.com.fiap.model.vo.Servico;


public class ServicoBO {

    private ServicoDAO servicoDAO = null;

    // Inserir
    public void inserirBO(Servico servico) throws ClassNotFoundException, SQLException {
        servicoDAO = new ServicoDAO();

        // Aplicação de regras de negócio... (se houver)

        servicoDAO.inserir(servico);
    }

    // Atualizar
    public void atualizarBO(Servico servico) throws ClassNotFoundException, SQLException {
        servicoDAO = new ServicoDAO();

        // Aplicação de regras de negócio... (se houver)

        servicoDAO.atualizar(servico);
    }

    // Deletar
    public void deletarBO(String nmServico) throws ClassNotFoundException, SQLException {
        servicoDAO = new ServicoDAO();

        // Aplicação de regras de negócio... (se houver)

        servicoDAO.deletar(nmServico);
    }

    // Selecionar todos os serviços
    public ArrayList<Servico> selecionarBO() throws ClassNotFoundException, SQLException {
        servicoDAO = new ServicoDAO();
        return (ArrayList<Servico>) servicoDAO.selecionar();
    }

    // Selecionar um serviço específico
    public Servico selecionarUmBO(int idServico) throws ClassNotFoundException, SQLException {
        servicoDAO = new ServicoDAO();

        // Aplicação de regras de negócio... (se houver)

        return servicoDAO.selecionarUm(idServico);
    }
}
