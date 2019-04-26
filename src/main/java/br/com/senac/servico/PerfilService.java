package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Perfil;
import br.com.senac.repositorio.PerfilRepositorio;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepositorio repoCol;

	public Perfil buscar(Integer id) {
		Optional<Perfil> objCategoria = repoCol.findById(id);
		return objCategoria.orElseThrow(() -> new ObjectNotFoundException(
				"Perfil não encontrado! Id: " + id + ", Tipo: " + Perfil.class.getName()));
	}

	public Perfil inserir(Perfil objPerfil) {
		objPerfil.setId(null);
		return repoCol.save(objPerfil);
	}

	public Perfil alterar(Perfil objPerfil) {

		Perfil objPerfilEncontrado = buscar(objPerfil.getId());
		objPerfilEncontrado.setNome(objPerfil.getNome());

		return repoCol.save(objPerfilEncontrado);
	}

	public void excluir(Integer id) {
		repoCol.deleteById(id);
	}

	public List<Perfil> listaPerfis() {
		return repoCol.findAll();
	}
}
