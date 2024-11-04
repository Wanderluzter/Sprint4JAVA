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

import br.com.fiap.model.bo.VeiculoBO;
import br.com.fiap.model.vo.Veiculo;


@Path("/veiculo")
public class VeiculoResource {

    private VeiculoBO veiculoBO = new VeiculoBO();

    // Inserir (POST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroVeiculo(Veiculo veiculo, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        veiculoBO.inserirBO(veiculo);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(veiculo.getPlaca()); // Assume que "placa" é o identificador único do veículo
        return Response.created(builder.build()).build();
    }

    // Atualizar (PUT)
    @PUT
    @Path("/{placa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizaVeiculo(Veiculo veiculo, @PathParam("placa") String placa) throws ClassNotFoundException, SQLException {
        veiculo.setPlaca(placa);
        veiculoBO.atualizarBO(veiculo);
        return Response.ok().build();
    }

    // Deletar (DELETE)
    @DELETE
    @Path("/{placa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarVeiculo(@PathParam("placa") String placa) throws ClassNotFoundException, SQLException {
        veiculoBO.deletarBO(placa);
        return Response.ok().build();
    }

    // Consultar todos (GET)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Veiculo> selecionarVeiculos() throws ClassNotFoundException, SQLException {
        return (ArrayList<Veiculo>) veiculoBO.selecionarBO();
    }

    // Consultar por placa (GET)
    @GET
    @Path("/{placa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorPlaca(@PathParam("placa") String placa) throws ClassNotFoundException, SQLException {
        Veiculo veiculo = veiculoBO.selecionarUmBO(placa);
        if (veiculo != null) {
            return Response.ok(veiculo).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
