package com.leandro.wk.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.leandro.wk.model.Usuario;

@Stateless
public class UsuarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Usuario> listar() {
		return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
	}

	public void inserir(Usuario usuario) {
		entityManager.persist(usuario);
	}

	public Usuario atualizar(Long id, Usuario usuario) {
		Usuario usuarioNovo = pesquisarId(id);
		usuarioNovo.setEmail(usuario.getEmail());
		usuarioNovo.setNome(usuario.getNome());
		usuarioNovo.setSenha(usuario.getSenha());
		return entityManager.merge(usuarioNovo);
	}

	public Usuario pesquisarId(Long id) {
		return entityManager.find(Usuario.class, id);
	}

	public void deletar(Long id) {
		entityManager.remove(pesquisarId(id));
	}
}
