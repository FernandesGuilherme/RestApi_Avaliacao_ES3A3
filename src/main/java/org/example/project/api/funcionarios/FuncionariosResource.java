package org.example.project.api.funcionarios;

//Class que recebe requisições HTTP

import jakarta.ws.rs.*;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//CRUDE - Create - Read - Update - Delete

@Path("funcionarios")
public class FuncionariosResource {

    private static FuncionarioRepositoy funcionarioRepositoy = new FuncionarioRepositoy();

    @POST
    @Consumes(MediaType.APPLICATION_JSON) // Informa o que consome
    @Produces(MediaType.APPLICATION_JSON) // Informa que o método produz algo em Jason

    public  Response create (FuncionarioRequest Request){ //Metodo para criar um novo funcionario
        Funcionarios funcionarios = new Funcionarios(Request.CPF, Request.nome, Request.email, Request.codigo_departamento);
        funcionarioRepositoy.save(funcionarios);

        return Response.status(Response.Status.CREATED).entity(new FuncionarioResponse(funcionarios.getId(), funcionarios.getCPF(), funcionarios.getNome(),
                funcionarios.getEmail(), funcionarios.getCodigo_departamento())).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index (){

        List <FuncionarioResponse> funcionarioResponses = funcionarioRepositoy.getAll().stream()
                .map(FuncionarioResponse::new).collect(Collectors.toList());

        return Response.status(Status.OK).entity(funcionarioResponses).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show (@PathParam("id") int id){
        Funcionarios fun = funcionarioRepositoy.getById(id);

        if (fun == null){
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.status(Status.OK)
                .entity(new FuncionarioResponse(fun))
                .build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response update(@PathParam("id") int id, FuncionarioRequest request) {
        Funcionarios fun = funcionarioRepositoy.getById(id);

        if (fun == null){
            return Response.status(Status.NOT_FOUND).build();
        }
        Funcionarios newFuncionario = new Funcionarios(id, request.CPF, request.nome, request.email,
                request.codigo_departamento);

        funcionarioRepositoy.update(newFuncionario);
        return Response.status(Status.OK).entity(new FuncionarioResponse(newFuncionario)).build();
    }

    @DELETE
    @Path("id")
    public Response delete (@PathParam("id") int id) {
        Funcionarios fun = funcionarioRepositoy.getById(id);
        if (fun == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        funcionarioRepositoy.delete(fun);
        return Response.status(Status.NO_CONTENT).build();
    }
}
