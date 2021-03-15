package org.example.project.api.projeto;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("projetos")
public class ProjetoResource {

    private static ProjetoRepository projetoRepository = new ProjetoRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response create(ProjetoRequest Request) {
        Projeto projetos = new Projeto(Request.codigo, Request.titulo, Request.data_Inicio, Request.data_fim);
        projetoRepository.save(projetos);

        return Response.status(Response.Status.CREATED).entity(new ProjetoResponse(projetos.getId(), projetos.getTitulo(), projetos.getData_Inicio(),
                projetos.getData_fim())).build();

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index (){

        List <ProjetoResponse> projetoResponses = projetoRepository.getAll().stream()
                .map(ProjetoResponse::new).collect(Collectors.toList());

        return Response.status(Status.OK).entity(projetoResponses).build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show (@PathParam("id") int id){
        Projeto proj = projetoRepository.getById(id);

        if (proj == null){
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.status(Status.OK)
                .entity(new ProjetoResponse(proj))
                .build();
    }
    /*



    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response update(@PathParam("id") int id, ProjetoRequest request) {
        Projeto proj = projetoRepository.getById(id);

        if (proj == null){
            return Response.status(Status.NOT_FOUND).build();
        }
        Projeto newProjeto = new Projeto(id, request.codigo, request.titulo, request.data_Inicio,
                request.data_fim);

        projetoRepository.update(newProjeto);
        return Response.status(Status.OK).entity(new ProjetoResponse(newProjeto)).build();
    }
    @DELETE
    @Path("id")
    public Response delete (@PathParam("id") int id) {
        Projeto proj = projetoRepository.getById(id);
        if (proj == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        projetoRepository.delete(proj);
        return Response.status(Status.NO_CONTENT).build();
    }
}





*/

}

