package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PagamentoDAO;
import br.com.fiap.entity.Pagamento;

public class PagamentoDAOImpl extends GenericDAOImpl<Pagamento, Integer> implements PagamentoDAO {

	public PagamentoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double sumPagamentoByPassageiro(int passageiro) {
		return em.createQuery("select sum(p.valorPagamento) from Pagamento p where p.corrida.passageiro.codigo = :passageiro", Pagamento.class)
				.setParameter("passageiro", passageiro)
				.getFirstResult();
	}

}
