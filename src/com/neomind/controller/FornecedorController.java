package com.neomind.controller;

import java.util.List;

import com.neomind.dao.FornecedorDAO;
import com.neomind.entidade.Fornecedor;

public class FornecedorController {
	
	private FornecedorDAO fornecedorDao;
	
	public FornecedorController() {
		fornecedorDao = new FornecedorDAO();
	}
	
	public List<Fornecedor> listar() {
		return this.fornecedorDao.listarFornecedor();
	}
	
	public String salvar(Fornecedor fornecedor) {
		return this.fornecedorDao.salvar(fornecedor);
	}
	public String atualizar(Fornecedor fornecedor, int id) {
		return this.fornecedorDao.atualizar(fornecedor, id);
	}
	
	public String deletar(int id) {
		return fornecedorDao.deletar(id);
	}
	
	public Fornecedor buscarFornecedor(int id) {
		return fornecedorDao.buscarFornecedor(id);
	}
	
}
