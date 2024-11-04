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

import br.com.fiap.model.bo.OficinaBO;
import br.com.fiap.model.vo.Oficina;



@Path("/oficina")
public class OficinaResource {

    private OficinaBO oficinaBO = new OficinaBO();

    // Inserir (POST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroOficina(Oficina oficina, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        oficinaBO.inserirBO(oficina);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(oficina.getEmailOf()); // Assume que "emailOf" é o identificador único da oficina
        return Response.created(builder.build()).build();
    }

    // Atualizar (PUT)
    @PUT
    @Path("/{emailOf}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizaOficina(Oficina oficina, @PathParam("emailOf") String emailOf) throws ClassNotFoundException, SQLException {
        oficina.setEmailOf(emailOf);
        oficinaBO.atualizarBO(oficina);
        return Response.ok().build();
    }

    // Deletar (DELETE)
    @DELETE
    @Path("/{emailOf}")
    public Response deletarOficina(@PathParam("emailOf") String emailOf) throws ClassNotFoundException, SQLException {
        oficinaBO.deletarBO(emailOf);
        return Response.ok().build();
    }

    // Consultar todos (GET)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Oficina> selecionarOficinas() throws ClassNotFoundException, SQLException {
        return (ArrayList<Oficina>) oficinaBO.selecionarBO();
    }

    // Consultar por ID (GET)
    @GET
    @Path("/{emailOf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam("emailOf") String emailOf) throws ClassNotFoundException, SQLException {
        Oficina oficina = oficinaBO.selecionarUmBO(emailOf);
        if (oficina != null) {
            return Response.ok(oficina).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
