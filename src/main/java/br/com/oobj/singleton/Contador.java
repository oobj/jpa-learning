package br.com.oobj.singleton;

import javax.ejb.Singleton;

@Singleton
public class Contador {

	private int count;
	
	public void incrementar() { ++count; }
	public void zerar() { count = 0; }
	public int getCount() { return count; }
}
