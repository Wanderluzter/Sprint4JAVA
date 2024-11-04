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

import br.com.fiap.model.bo.ServicoBO;
import br.com.fiap.model.vo.Servico;



@Path("/servico")
public class ServicoResource {

    private ServicoBO servicoBO = new ServicoBO();

    // Inserir (POST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroServico(Servico servico, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        servicoBO.inserirBO(servico);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(servico.getNomeServ())); // Assume que "idServico" é o identificador único do serviço
        return Response.created(builder.build()).build();
    }

    // Atualizar (PUT)
    @PUT
    @Path("/{idServico}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizaServico(Servico servico, @PathParam("idServico") String nmServico) throws ClassNotFoundException, SQLException {
        servico.setNomeServ(nmServico);
        servicoBO.atualizarBO(servico);
        return Response.ok().build();
    }

    // Deletar (DELETE)
    @DELETE
    @Path("/{idServico}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarServico(@PathParam("idServico") String nmServico) throws ClassNotFoundException, SQLException {
        servicoBO.deletarBO(nmServico);
        return Response.ok().build();
    }

    // Consultar todos (GET)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Servico> selecionarServicos() throws ClassNotFoundException, SQLException {
        return (ArrayList<Servico>) servicoBO.selecionarBO();
    }

    // Consultar por ID (GET)
    @GET
    @Path("/{idServico}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorId(@PathParam("idServico") int idServico) throws ClassNotFoundException, SQLException {
        Servico servico = servicoBO.selecionarUmBO(idServico);
        if (servico != null) {
            return Response.ok(servico).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
