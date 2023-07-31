package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.model.Clientes;
import com.proyecto.model.Maquinas;
import com.proyecto.model.Marca;
import com.proyecto.model.Usuarios;
import com.proyecto.repository.IClientesRepository;
import com.proyecto.repository.IMaquinasRepository;
import com.proyecto.repository.IMarcaRepository;
import com.proyecto.repository.IUsuariosRepository;

@Controller
public class ProyectoController {

	@Autowired
	private IMaquinasRepository remaq;
	@Autowired
	private IMarcaRepository remar;
	@Autowired
	private IUsuariosRepository reusu;
	@Autowired
	private IClientesRepository recli;

////////////////////////////////////////////LISTAR DATOS//////////////////////////////////
	@GetMapping("/principal")
	public String paginaPrincipal() {
		return "principal";
	}

	@GetMapping("/registro/Usuario")
	public String pagRegistro(Model model) {
		model.addAttribute("usua", new Usuarios());
		return "registro";
	}

	@GetMapping("/listadocli")
	public String listadoCli(Model model) {
		model.addAttribute("lstClientes", recli.findAll());
		return "listado-clientes";
	}

	@GetMapping("/listadoMaq")
	public String listadoMaq(Model model) {
		model.addAttribute("lstMaquinas", remaq.findAll());
		return "listado-maquinas";
	}

	@GetMapping("/listadoMar")
	public String listadoMar(Model model) {
		model.addAttribute("lstMarcas", remar.findAll());
		return "listado-marcas";
	}

	@GetMapping("/listadoUsu")
	public String listadoUsu(Model model) {
		model.addAttribute("lstUsuarios", reusu.findAll());
		return "listado-usuarios";
	}

//////////////////////////////ABRIR PAGINAS DATOS DEL LISTADO//////////////////////////////
	@PostMapping("/Cliente/Editar")
	public String editarCliente(@ModelAttribute Clientes c, Model model) {
		model.addAttribute("cliente", recli.findById(c.getId_cliente()));
		return "mantenimiento-clientes";
	}

	@PostMapping("/Usuarios/Editar")
	public String editarUsuario(@ModelAttribute Usuarios u, Model model) {
		model.addAttribute("usuario", reusu.findById(u.getId_usuarios()));
		return "mantenimiento-usuarios";
	}

	@PostMapping("/Marcas/Editar")
	public String editarMarca(@ModelAttribute Marca m, Model model) {
		model.addAttribute("marca", remar.findById(m.getId_marca()));
		return "mantenimiento-marcas";
	}

	@PostMapping("/Maquinas/Editar")
	public String editarMaquina(@ModelAttribute Maquinas ma, Model model) {
		model.addAttribute("maquina", remaq.findById(ma.getId_maquina()));
		model.addAttribute("lstMarcas", remar.findAll());
		return "mantenimiento-maquinas";
	}

/////////////////////////////////////LOGIN Y REPORTES///////////////////////////////////////
	@GetMapping("/")
	public String cargarLogin(Model model) {
		model.addAttribute("usuarios", new Usuarios());
		return "login";
	}

	@PostMapping("/")
	public String iniciarSesion(Model model, @ModelAttribute Usuarios usuario) {
		// System.out.println(usuario);
		Usuarios u = reusu.findByUsuarioAndClave(usuario.getUsuario(), usuario.getClave());
		System.out.println(u);
		// validacion del inicio de sesion
		if (u == null) {
			model.addAttribute("clasemensaje", "alert alert-danger");
			model.addAttribute("mensaje", "Error en contraseña o correo");
			return "login";
		} else {
			model.addAttribute("u", u);
			return "Principal";
		}
		
	}
	
	@GetMapping("/reportes")
	public String cargarReportes() {
		return "reportes";
	}

//////////////////////////////MANTENIMIENTOS DE LISTADOS/////////////////////////////////////
	@PostMapping("/registro")
	public String registrarCuenta(@ModelAttribute Usuarios usuario, Model model) {
		model.addAttribute("usua", new Usuarios());
		System.out.println(usuario);

		try {
			reusu.save(usuario);
			model.addAttribute("mensaje", "Usuario Registrado");
			model.addAttribute("clasemensaje", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("clasemensaje", "alert alert-danger");
			model.addAttribute("mensaje", "Error al ingresar Usuario o Contraseña");
		}
		model.addAttribute("lstUsuarios", reusu.findAll());
		return "registro";
	}

	@PostMapping("/clientes/actualizar")
	public String actualizarCliente(@ModelAttribute Clientes cliente, Model model) {
		model.addAttribute("cliente", recli.findById(cliente.getId_cliente()));
		System.out.println(cliente);

		try {
			recli.save(cliente);
			model.addAttribute("mensaje", "Cliente Registrado");
			model.addAttribute("clasemensaje", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("clasemensaje", "alert alert-danger");
			model.addAttribute("mensaje", "Error al Actualizar");
		}
		return "mantenimiento-clientes";

	}

	@PostMapping("/maquinas/actualizar")
	public String actualizarMaquina(@ModelAttribute Maquinas maquina, Model model) {
		model.addAttribute("maquina", recli.findById(maquina.getId_maquina()));
		System.out.println(maquina);

		try {
			remaq.save(maquina);
			model.addAttribute("mensaje", "Maquina Registrada");
			model.addAttribute("clasemensaje", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("clasemensaje", "alert alert-danger");
			model.addAttribute("mensaje", "Error al Actualizar");
		}
		model.addAttribute("maquina", remaq.findById(maquina.getId_maquina()));
		model.addAttribute("lstMarcas", remar.findAll());
		return "mantenimiento-maquinas";

	}

	@PostMapping("/marcas/actualizar")
	public String actualizarMarca(@ModelAttribute Marca marca, Model model) {
		model.addAttribute("marca", remar.findById(marca.getId_marca()));
		System.out.println(marca);

		try {
			remar.save(marca);
			model.addAttribute("mensaje", "Marca Registrada");
			model.addAttribute("clasemensaje", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("clasemensaje", "alert alert-danger");
			model.addAttribute("mensaje", "Error al Actualizar");
		}
		model.addAttribute("marca", remar.findById(marca.getId_marca()));
		return "mantenimiento-marcas";

	}

	@PostMapping("/usuarios/actualizar")
	public String ActualizarUsuario(@ModelAttribute Usuarios usuario, Model model) {
		model.addAttribute("usuario", reusu.findById(usuario.getId_usuarios()));
		System.out.println(usuario);

		try {
			reusu.save(usuario);
			model.addAttribute("mensaje", "Usuario Registrado");
			model.addAttribute("clasemensaje", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("clasemensaje", "alert alert-danger");
			model.addAttribute("mensaje", "Error al Registrar");
		}
		model.addAttribute("usuario", reusu.findById(usuario.getId_usuarios()));
		return "mantenimiento-usuarios";
	}

/////////////////////////////////////ABRIR PAGINAS DE DATOS NUEVOS////////////////////////////
	@GetMapping("/cliente/nuevo")
	public String AbrirMantCliente(@ModelAttribute Clientes cliente, Model model) {
		model.addAttribute("cliente", new Clientes());
		return "mantenimiento-clientes";
	}
	
	@GetMapping("/maquina/nuevo")
	public String AbrirMantMaquina(@ModelAttribute Maquinas maquina, Model model) {
		model.addAttribute("maquina", new Maquinas());
		model.addAttribute("lstMarcas", remar.findAll());
		return "mantenimiento-maquinas";
	}
	
	@GetMapping("/marca/nuevo")
	public String AbrirMantMarca(@ModelAttribute Marca marca, Model model) {
		model.addAttribute("marca", new Marca());
		return "mantenimiento-marcas";
	}
	
	@GetMapping("/usuario/nuevo")
	public String AbrirMantMarca(@ModelAttribute Usuarios usuario, Model model) {
		model.addAttribute("usuario", new Usuarios());
		return "mantenimiento-usuarios";
	}


}
