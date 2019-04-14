package br.com.fiap.main;

import javax.persistence.EntityManager;

import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Main {
	
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

	}
	
}
