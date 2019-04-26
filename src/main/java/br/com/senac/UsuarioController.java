package br.com.senac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.dominio.Usuario;
import br.com.senac.servico.UsuarioService;


@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public ModelAndView listaUsuarios() {
		ModelAndView mv = new ModelAndView("usuario/paginaUsuario");
		mv.addObject("usuarios", usuarioService.listaUsuarios());
		return mv;
	}
	
	@GetMapping("/adicionar")
	public ModelAndView add(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/paginaAdicionar");
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView inserir(Usuario usuario) {
		usuarioService.inserir(usuario);
		return listaUsuarios();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		usuarioService.excluir(id);
		return listaUsuarios();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("usuario/paginaAlterar");
		mv.addObject("usuario", usuarioService.buscar(id));
		return mv;
	}
	
	@PostMapping
	public ModelAndView alterar(Usuario usuario) {
		usuarioService.alterar(usuario);
		return listaUsuarios();
	}
}