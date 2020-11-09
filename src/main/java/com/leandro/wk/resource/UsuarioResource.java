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
import javax.ws.rs.QueryParam;
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
		Usuario usuarioPesquisado = repository.pesquisarId(id);
		if (usuarioPesquisado == null)
			return Response.status(404).entity("Usuário não encontrado").type(MediaType.TEXT_PLAIN).build();
		return Response.ok(usuarioPesquisado).build();
	}

	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response inserir(Usuario usuario) {
		try {
			repository.inserir(usuario);
			return Response.status(201).build();

		} catch (Exception e) {
			return Response.status(400).entity("Erro ao inserir usuário").build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id") Long id) {
		if (repository.pesquisarId(id) == null)
			return Response.status(404).entity("Usuário não encontrado, por isso não pode ser deletado").build();
		repository.deletar(id);
		return Response.noContent().build();
	}

	@PUT
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(@PathParam("id") Long id, Usuario usuario) {
		if (repository.pesquisarId(id) == null)
			return Response.status(404).entity("Usuário não encontrado, por isso não pode ser atualizado")
					.type(MediaType.TEXT_PLAIN).build();
		return Response.accepted(repository.atualizar(id, usuario)).build();
	}

	@GET
	@Path("/login")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response login(@QueryParam(value = "email") String email, @QueryParam(value = "senha") String senha) {
		Usuario usuarioPesquisado = repository.login(email, senha);
		if (usuarioPesquisado == null)
			return Response.status(404).entity("Usuário não encontrado").type(MediaType.TEXT_PLAIN).build();
		return Response.ok(usuarioPesquisado).build();
	}

}
