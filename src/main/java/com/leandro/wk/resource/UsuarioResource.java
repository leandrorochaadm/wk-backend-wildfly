package com.leandro.wk.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.leandro.wk.model.Usuario;
import com.leandro.wk.repository.UsuarioRepository;

@Path("usuarios")
public class UsuarioResource {

	@Inject
	private UsuarioRepository repository;

	@GET
	@Path("/")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		return Response.ok(repository.listar()).build();
	}

	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response pesquisarId(@PathParam("id") Long id) {
		return Response.ok(repository.pesquisarId(id)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(Usuario usuario) {

		// TODO: melhorar esse tratamento de erro, apresentar motivo do erro para o
		// usuario
		try {
			repository.inserir(usuario);
			return Response.status(201).build();

		} catch (Exception e) {
			return Response.status(500).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response deletar(@PathParam("id") Long id) {
		repository.deletar(id);
		return Response.status(202).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(@PathParam("id") Long id, Usuario usuario) {
		repository.atualizar(id, usuario);
		return Response.status(202).build();
	}

}
