package br.com.fiap.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.dao.PecaDAO;
import br.com.fiap.model.vo.Peca;


public class PecaBO {

    private PecaDAO pecaDAO = null;

    // Inserir
    public void inserirBO(Peca peca) throws ClassNotFoundException, SQLException {
        pecaDAO = new PecaDAO();
        
        // Aplicação de regras de negócio... (se houver)

        pecaDAO.inserir(peca);
    }

    // Atualizar
    public void atualizarBO(Peca peca) throws ClassNotFoundException, SQLException {
        pecaDAO = new PecaDAO();

        // Aplicação de regras de negócio... (se houver)

        pecaDAO.atualizar(peca);
    }

    // Deletar
    public void deletarBO(int idPeca) throws ClassNotFoundException, SQLException {
        pecaDAO = new PecaDAO();

        // Aplicação de regras de negócio... (se houver)

        pecaDAO.deletar(idPeca);
    }

    // Selecionar todas as peças
    public ArrayList<Peca> selecionarBO() throws ClassNotFoundException, SQLException {
        pecaDAO = new PecaDAO();
        return (ArrayList<Peca>) pecaDAO.selecionar();
    }
    
    // Selecionar uma peça específica
    public Peca selecionarUmBO(int codigoPeca) throws ClassNotFoundException, SQLException {
        pecaDAO = new PecaDAO();

        // Aplicação de regras de negócio... (se houver)

        return pecaDAO.selecionarUm(codigoPeca);
    }
}
