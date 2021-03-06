package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

	Usuario findByNome(String nome);
	Usuario findByEmail(String email);
	Usuario findByEmailAndSenha(String email, String senha);
}
