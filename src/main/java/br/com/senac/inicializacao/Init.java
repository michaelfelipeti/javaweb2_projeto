package br.com.senac.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Perfil;
import br.com.senac.dominio.Usuario;
import br.com.senac.repositorio.PerfilRepositorio;
import br.com.senac.repositorio.UsuarioRepositorio;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	//Chamada de interfaces
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	 @Autowired
	 PerfilRepositorio perfilRepositorio;
	 
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		//Instanciacao, criacao e persistencia
		//Usuario
		Usuario usuario = new Usuario();
		usuario.setNome("nome");
		usuario.setEmail("nome@email.com");
		usuario.setSenha("senha123");
		
		Perfil tecnico = new Perfil();
		tecnico.setNome("tecnico");
		
		Perfil administrador = new Perfil();
		administrador.setNome("administrador");
		
		usuario.setPerfil(administrador);
		
		perfilRepositorio.saveAll(Arrays.asList(tecnico,administrador));
		usuarioRepositorio.save(usuario);
	}
}
