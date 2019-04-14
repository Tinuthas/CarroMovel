package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CorridaDAO;
import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.Motorista;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO {

	public CorridaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Corrida> getAllCorridasByDate(Calendar start, Calendar end) {
		return em.createQuery("from Corrida c where c.dataCorrida between :dateStart and :dateEnd", Corrida.class)
				.setParameter("dateStart", start).setParameter("dateEnd", end).setMaxResults(30).getResultList();
	}

	@Override
	public List<Corrida> getAllCorridasByMotorista(Motorista motorista) {
		return em.createQuery("from Corrida c where c.motorista like :m", Corrida.class).setParameter("m", motorista)
				.getResultList();
	}

	@Override
	public List<Corrida> getAllCorridasByNamePassageiro(String passageiro) {
		return em.createQuery("from Corrida c where c.passageiro.nome like :p", Corrida.class)
				.setParameter("p", "%" + passageiro + "%").setMaxResults(40).getResultList();
	}

	@Override
	public int getCountCorridaByMotorista(int codigoMotorista, Calendar start, Calendar fim) {
		return em.createQuery(
				"select count(c) from Corrida c where c.motorista.codigo = :motorista and c.dataCorrida between :dateStart and :dateEnd",
				Corrida.class).setParameter("motorista", codigoMotorista).setParameter("dateStart", start)
				.setParameter("dateEnd", fim).getFirstResult();
	}

	@Override
	public List<Corrida> getTopTenCorrida(int codigoPassageiro) {
		return em.createQuery("from Corrida c where c.passageiro.codigo = :p order by c.valorCorrida desc",
				Corrida.class).setParameter("p", codigoPassageiro).setMaxResults(10).getResultList();
	}

	@Override
	public List<Corrida> getAllMotoristaPassageiro(int codigoPassageiro, int codigoMotorista) {
		return em.createQuery("from Corrida c where c.passageiro.codigo = :p and c.motorista.codigo = :m", Corrida.class)
				.setParameter("p", codigoPassageiro)
				.setParameter("m", codigoMotorista)
				.getResultList();
	}

}
