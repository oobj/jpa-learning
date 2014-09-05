package br.com.oobj.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.oobj.entidade.Funcionario;
import br.com.oobj.servico.FuncionarioServico;

public class FuncionarioMain {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FuncionarioPU");
		EntityManager em = factory.createEntityManager();
		FuncionarioServico dao = new FuncionarioServico(em);

		em.getTransaction().begin();
		Funcionario funcionario = dao.criarFuncionario(123, "Átilla", 1000.0);
		em.getTransaction().commit();
		System.out.println(funcionario.getNome() + " salvo!");
		
		em.getTransaction().begin();
		funcionario = dao.aumentarSalario(123, 600.0);
		em.getTransaction().commit();
		System.out.println(funcionario.getNome() + " tem o salário de " + funcionario.getSalario());
		
		funcionario = dao.consultarFuncionario(123);
		System.out.println(funcionario.getNome() + " localizado!");
		
		List<Funcionario> funcionarios = dao.consultarFuncionarios();
		for (Funcionario f : funcionarios) {
			System.out.println(f.getNome() + " localizado!");
		}
		
		em.getTransaction().begin();
		dao.excluirFuncionario(123);
		em.getTransaction().commit();
		System.out.println("Funcionário excluído!");
		
		em.close();
		factory.close();
	}
}
