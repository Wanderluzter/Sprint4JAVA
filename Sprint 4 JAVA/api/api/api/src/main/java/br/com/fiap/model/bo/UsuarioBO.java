package br.com.fiap.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.dao.UsuarioDAO;
import br.com.fiap.model.vo.Usuario;

public class UsuarioBO {

    UsuarioDAO usuarioDAO = null;

    // inserir
    public void inserirBO(Usuario usuario) throws ClassNotFoundException, SQLException {
        
        usuarioDAO = new UsuarioDAO();

        // Aplicação de regras de negócio... (se houver)

        usuarioDAO.inserir(usuario);
    }

    // atualizar
    public void atualizarBO(Usuario usuario) throws ClassNotFoundException, SQLException {
        
        usuarioDAO = new UsuarioDAO();

        // Aplicação de regra de negócio... (se houver)

        usuarioDAO.atualizar(usuario);
    }

    // deletar
    public void deletarBO(String emailUs) throws ClassNotFoundException, SQLException {
        
        usuarioDAO = new UsuarioDAO();

        // Aplicação de regra de negócio... (se houver)

        usuarioDAO.deletar(emailUs);
    }

    // selecionar
    public ArrayList<Usuario> selecionarBO() throws ClassNotFoundException, SQLException {
        
        usuarioDAO = new UsuarioDAO();
        return (ArrayList<Usuario>) usuarioDAO.selecionar();
    }
    
public Usuario selecionarUmBO(String emailUs) throws ClassNotFoundException, SQLException {
        
        usuarioDAO = new UsuarioDAO();
 
        // Aplicação de regra de negócio... (se houver)
        return usuarioDAO.selecionarUm(emailUs);
    }
}
