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

import br.com.fiap.model.bo.DiagnosticoBO;
import br.com.fiap.model.vo.Diagnostico;



@Path("/diagnostico")
public class DiagnosticoResource {

    private DiagnosticoBO diagnosticoBO = new DiagnosticoBO();

    // Inserir (POST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroDiagnostico(Diagnostico diagnostico, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        diagnosticoBO.inserirBO(diagnostico);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(diagnostico.getIdDiag())); // Assume que "id_diag" é o identificador único do diagnóstico
        return Response.created(builder.build()).build();
    }

    // Atualizar (PUT)
    @PUT
    @Path("/{idDiag}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizaDiagnostico(Diagnostico diagnostico, @PathParam("idDiag") int idDiag) throws ClassNotFoundException, SQLException {
        diagnostico.setIdDiag(idDiag);
        diagnosticoBO.atualizarBO(diagnostico);
        return Response.ok().build();
    }

    // Deletar (DELETE)
    @DELETE
    @Path("/{idDiag}")
    public Response deletarDiagnostico(@PathParam("idDiag") int idDiag) throws ClassNotFoundException, SQLException {
        diagnosticoBO.deletarBO(idDiag);
        return Response.ok().build();
    }

    // Consultar todos (GET)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Diagnostico> selecionarDiagnosticos() throws ClassNotFoundException, SQLException {
        return (ArrayList<Diagnostico>) diagnosticoBO.selecionarBO();
    }

    // Consultar por ID (GET)
    @GET
    @Path("/{idDiag}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam("idDiag") int idDiag) throws ClassNotFoundException, SQLException {
        Diagnostico diagnostico = diagnosticoBO.selecionarUmBO(idDiag);
        if (diagnostico != null) {
            return Response.ok(diagnostico).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
