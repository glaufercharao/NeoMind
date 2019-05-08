package com.neomind.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.neomind.controller.FornecedorController;
import com.neomind.entidade.Fornecedor;

@Path("/fornecedor")
public class FornecedorService {
	
	private FornecedorController fornecedorController ; 
	
	@PostConstruct
	private void init() {
		this.fornecedorController = new FornecedorController();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fornecedor> listaFornecedor(){
		return this.fornecedorController.listar();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addFornecedor(Fornecedor f) {
		System.out.print(f.getName());
		return this.fornecedorController.salvar(f);
	}
	
	
	@PUT
	@Path("/editar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String editarFornecedor(Fornecedor f, @PathParam("id") int id) {
		return this.fornecedorController.atualizar(f, id);	
	}
	
	@GET
	@Path("/buscar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Fornecedor buscar(@PathParam("id") int id) {
		return this.fornecedorController.buscarFornecedor(id);	
	}
	
	@DELETE
	@Path("/remover/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerFornecedor(@PathParam("id") int id) {
		return this.fornecedorController.deletar(id);
	}

}
