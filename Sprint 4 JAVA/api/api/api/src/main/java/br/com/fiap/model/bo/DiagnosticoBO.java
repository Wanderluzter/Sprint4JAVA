package br.com.fiap.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.dao.DiagnosticoDAO;
import br.com.fiap.model.vo.Diagnostico;

public class DiagnosticoBO {

    private DiagnosticoDAO diagnosticoDAO = null;

    // Inserir
    public void inserirBO(Diagnostico diagnostico) throws ClassNotFoundException, SQLException {
        diagnosticoDAO = new DiagnosticoDAO();

        // Aplicação de regras de negócio... (se houver)

        diagnosticoDAO.inserir(diagnostico);
    }

    // Atualizar
    public void atualizarBO(Diagnostico diagnostico) throws ClassNotFoundException, SQLException {
        diagnosticoDAO = new DiagnosticoDAO();

        // Aplicação de regras de negócio... (se houver)

        diagnosticoDAO.atualizar(diagnostico);
    }

    // Deletar
    public void deletarBO(int idDiag) throws ClassNotFoundException, SQLException {
        diagnosticoDAO = new DiagnosticoDAO();

        // Aplicação de regras de negócio... (se houver)

        diagnosticoDAO.deletar(idDiag);
    }

    // Selecionar todos os diagnósticos
    public ArrayList<Diagnostico> selecionarBO() throws ClassNotFoundException, SQLException {
        diagnosticoDAO = new DiagnosticoDAO();
        return (ArrayList<Diagnostico>) diagnosticoDAO.selecionar();
    }

    // Selecionar um diagnóstico específico
    public Diagnostico selecionarUmBO(int idDiag) throws ClassNotFoundException, SQLException {
        diagnosticoDAO = new DiagnosticoDAO();

        // Aplicação de regras de negócio... (se houver)

        return diagnosticoDAO.selecionarUm(idDiag);
    }
}
