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

import br.com.fiap.model.bo.PecaBO;
import br.com.fiap.model.vo.Peca;


@Path("/peca")
public class PecaResource {

    private PecaBO pecaBO = new PecaBO();

    // Inserir (POST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroPeca(Peca peca, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        pecaBO.inserirBO(peca);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(peca.getIdPeca())); // Assume que "idPeca" é o identificador único da peça
        return Response.created(builder.build()).build();
    }

    // Atualizar (PUT)
    @PUT
    @Path("/{idPeca}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizaPeca(Peca peca, @PathParam("idPeca") int idPeca) throws ClassNotFoundException, SQLException {
        peca.setIdPeca(idPeca);
        pecaBO.atualizarBO(peca);
        return Response.ok().build();
    }

    // Deletar (DELETE)
    @DELETE
    @Path("/{idPeca}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarPeca(@PathParam("idPeca") int idPeca) throws ClassNotFoundException, SQLException {
        pecaBO.deletarBO(idPeca);
        return Response.ok().build();
    }

    // Consultar todos (GET)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Peca> selecionarPecas() throws ClassNotFoundException, SQLException {
        return (ArrayList<Peca>) pecaBO.selecionarBO();
    }

    // Consultar por ID (GET)
    @GET
    @Path("/{idPeca}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam("idPeca") int idPeca) throws ClassNotFoundException, SQLException {
        Peca peca = pecaBO.selecionarUmBO(idPeca);
        if (peca != null) {
            return Response.ok(peca).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
