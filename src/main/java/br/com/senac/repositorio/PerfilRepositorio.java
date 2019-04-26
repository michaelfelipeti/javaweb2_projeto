package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Perfil;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Integer>{
	
	Perfil findByNome(String nome);
}
