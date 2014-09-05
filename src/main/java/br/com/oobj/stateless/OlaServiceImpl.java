package br.com.oobj.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class OlaServiceImpl implements OlaService {
	
	public String digaOla(String nome) {
		return "Olá, "+nome;
	}
	
	@PostConstruct
	public void aposCriacao() {
		System.out.println("Foi criado... hehe");
	}
	
	@PreDestroy
	public void antesDeDestruir() {
		System.out.println("Vai ser destruído. Se liga...");
	}
}
