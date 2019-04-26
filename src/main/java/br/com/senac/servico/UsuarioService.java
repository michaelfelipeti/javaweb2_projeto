package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.dominio.Usuario;
import br.com.senac.repositorio.UsuarioRepositorio;
import br.com.senac.servico.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio repoUsu;
	
	public Usuario buscar(Integer id) {
		/* */ Optional<Usuario> objUsuario = repoUsu.findById(id);
		return objUsuario.orElseThrow(() -> new ObjectNotFoundException(
				"Usuario não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario inserir(Usuario objUsuario) {
		objUsuario.setId(null);
		return repoUsu.save(objUsuario);
	}
	
	public Usuario alterar(Usuario objUsuario) {
		
		Usuario objUsuarioEncontrado = buscar(objUsuario.getId());
		objUsuarioEncontrado.setNome(objUsuario.getNome());
		
		return repoUsu.save(objUsuarioEncontrado);
	}
	
	public void excluir(Integer id) {
		repoUsu.deleteById(id);
	}
	
	public List<Usuario> listaUsuarios(){
		return repoUsu.findAll();
	}
}