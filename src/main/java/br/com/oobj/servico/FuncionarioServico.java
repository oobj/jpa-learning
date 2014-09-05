package br.com.oobj.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.oobj.entidade.Funcionario;

@Stateless
public class FuncionarioServico {

	@PersistenceContext
	private EntityManager em;

	public FuncionarioServico(EntityManager em) {
		this.em = em;
	}
	
	@Deprecated
	public FuncionarioServico() {
		this.em = em;
	}
	
	public Funcionario criarFuncionario(int id, String nome, double salario) {
		Funcionario funcionario = new Funcionario(id, nome, salario);
		
		em.persist(funcionario);
		
		return funcionario;
	}
	
	public Funcionario consultarFuncionario(int id) {
		return em.find(Funcionario.class, id);
	}
	
	public List<Funcionario> consultarFuncionarios() {
		TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f", 
				Funcionario.class);
		
		return query.getResultList();
	}
	
	public Funcionario aumentarSalario(int id, double aumento) {
		Funcionario funcionario = consultarFuncionario(id);
		
		if (funcionario != null) {
			funcionario.setSalario(funcionario.getSalario() + aumento);
		}
		
		return funcionario;
	}
	
	public void excluirFuncionario(int id) {
		Funcionario funcionario = consultarFuncionario(id);
		
		if (funcionario != null) {
			em.remove(funcionario);
		}
	}
}
