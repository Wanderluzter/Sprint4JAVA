package br.com.fiap.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.dao.OficinaDAO;
import br.com.fiap.model.vo.Oficina;


public class OficinaBO {

    private OficinaDAO oficinaDAO = null;

    // Inserir
    public void inserirBO(Oficina oficina) throws ClassNotFoundException, SQLException {
        oficinaDAO = new OficinaDAO();

        // Aplicação de regras de negócio... (se houver)

        oficinaDAO.inserir(oficina);
    }

    // Atualizar
    public void atualizarBO(Oficina oficina) throws ClassNotFoundException, SQLException {
        oficinaDAO = new OficinaDAO();

        // Aplicação de regras de negócio... (se houver)

        oficinaDAO.atualizar(oficina);
    }

    // Deletar
    public void deletarBO(String cnpj) throws ClassNotFoundException, SQLException {
        oficinaDAO = new OficinaDAO();

        // Aplicação de regras de negócio... (se houver)

        oficinaDAO.deletar(cnpj);
    }

    // Selecionar todas as oficinas
    public ArrayList<Oficina> selecionarBO() throws ClassNotFoundException, SQLException {
        oficinaDAO = new OficinaDAO();
        return (ArrayList<Oficina>) oficinaDAO.selecionar();
    }

    // Selecionar uma oficina específica
    public Oficina selecionarUmBO(String cnpj) throws ClassNotFoundException, SQLException {
        oficinaDAO = new OficinaDAO();

        // Aplicação de regras de negócio... (se houver)

        return oficinaDAO.selecionarUm(cnpj);
    }
}
