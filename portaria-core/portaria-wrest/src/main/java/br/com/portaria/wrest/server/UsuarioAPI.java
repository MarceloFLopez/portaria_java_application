package br.com.portaria.wrest.server;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.portaria.domain.Usuario;
import br.com.portaria.wbusiness.UsuarioBO;

@Path("usuarioapi")
public class UsuarioAPI {
	
	@Inject
	private UsuarioBO usuarioBO;

	/**
	 * API example, Usuario class
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listAll")
	public List<Usuario> listAll() throws Exception {
		return usuarioBO.listAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("findColumnModel/{value}")
	public Usuario findColumnModel(@PathParam("value") String value) throws Exception {
		return usuarioBO.findColumnName(value);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("findId/{id}")
	public Usuario findId(@PathParam("id") String id) throws Exception {
		return usuarioBO.findId(new Long(id) );
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("salvar/{t}")
	public void salvar(Usuario t) throws Exception {
		usuarioBO.salvar(t);
	}

	@GET
	@DELETE
	@Path("remove/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String remove(@PathParam("id") Long id) throws Exception {
		usuarioBO.remove(usuarioBO.findId(new Long(id)));
		return "Removido com sucesso!";
	}
	
}

