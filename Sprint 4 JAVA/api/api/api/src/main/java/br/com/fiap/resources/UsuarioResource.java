package br.com.fiap.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.model.bo.UsuarioBO;
import br.com.fiap.model.vo.Usuario;

@Path("/usuario") // Nome da página
public class UsuarioResource {

    private UsuarioBO usuarioBO = new UsuarioBO();

    // Inserir (POST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroRs(Usuario usuario, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        usuarioBO.inserirBO(usuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder(); // Recebe a informação do front (página)
        builder.path(usuario.getEmailUs()); // Identifica o e-mail do usuário
        return Response.created(builder.build()).build(); // Composição -> caminho (carregar o que foi carregado) - http -> 200
    }

    // Atualizar (PUT)
    @PUT
    @Path("/{emailUs}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizaRs(Usuario usuario, @PathParam("emailUs") String emailUs) throws ClassNotFoundException, SQLException {
        usuario.setEmailUs(emailUs); // Define o e-mail para atualizar o usuário correto
        usuarioBO.atualizarBO(usuario);
        return Response.ok().build();
    }

    // Deletar (DELETE)
    @DELETE
    @Path("/{emailUs}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("emailUs") String emailUs) throws ClassNotFoundException, SQLException {
        usuarioBO.deletarBO(emailUs);
        return Response.ok().build();
    }

    // Consultar (GET)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Usuario> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Usuario>) usuarioBO.selecionarBO();
    }
    
 // Consultar usuário por e-mail (GET)
    @GET
    @Path("/{emailUs}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorEmail(@PathParam("emailUs") String emailUs) throws ClassNotFoundException, SQLException {
        Usuario usuario = usuarioBO.selecionarUmBO(emailUs); // Usa o método na camada BO
        if (usuario != null) {
            return Response.ok(usuario).build(); // Retorna o usuário encontrado com status 200 OK
        } else {
            return Response.status(Response.Status.NOT_FOUND).build(); // Retorna 404 se o usuário não for encontrado
        }
    }
}
