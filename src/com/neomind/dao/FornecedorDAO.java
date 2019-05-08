package com.neomind.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.neomind.entidade.Fornecedor;
import com.neomind.util.ConnectionFactory;

public class FornecedorDAO {
	private EntityManager em;
	public FornecedorDAO() {
		em = new ConnectionFactory().getConnection();
	}
	
	public String salvar(Fornecedor f) {
		try {
		
			this.em.getTransaction().begin();
			this.em.persist(f);
			this.em.getTransaction().commit();
			return "Fornecedor salvo com sucesso.";		
		
		}catch(Exception e){
			return "Erro ao salvar fornecedor. Mensagem de erro: " + e.getMessage();
			
		}finally {
			this.em.close();
		}
	}
	
	public String atualizar(Fornecedor f,int  id) {
		try {
			if(f != null) {
				Fornecedor fornecedor = this.em.find(Fornecedor.class, id);
				
				fornecedor.setName(f.getName());
				fornecedor.setEmail(f.getEmail());
				fornecedor.setComment(f.getComment());
				fornecedor.setCnpj(f.getCnpj());
				
				this.em.getTransaction().begin();
				this.em.merge(fornecedor);
				this.em.flush();
				this.em.getTransaction().commit();
				return "Fornecedor atualizado com sucesso.";	
			}else {
				return "Nenhum fornecedor encontrado.";
			}
			
		} catch (Exception e) {
			return "Erro ao tentar atualizar fornecedor. Mensagem de erro: " + e.getMessage();
		}finally {
			this.em.close();
		}
	}
	
	public String deletar(int id) {
		try {
			Fornecedor f = this.em.find(Fornecedor.class, id);
			if(f != null) {
				this.em.getTransaction().begin();
				this.em.remove(f);
				this.em.getTransaction().commit();
				return "Fornecedor removido com sucesso.";	
			}else {
				return "Nenhum fornecedor encontrado.";
			}
			
		} catch (Exception e) {
			return "Erro ao tentar remover fornecedor. Mensagem de erro: " + e.getMessage();
		}finally {
			this.em.close();
		}
	}
	
	public Fornecedor buscarFornecedor(int id) {
		return this.em.find(Fornecedor.class, id);
	}
	
	public List<Fornecedor> listarFornecedor(){
		  Query query = em.createQuery("SELECT f FROM Fornecedor f");
          @SuppressWarnings("unchecked")
          List<Fornecedor> fornecedor = query.getResultList();
          return fornecedor;
	}

}
