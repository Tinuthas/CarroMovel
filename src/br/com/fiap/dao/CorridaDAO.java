package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.Motorista;

public interface CorridaDAO extends GenericDAO<Corrida, Integer> {
	
	List<Corrida> getAllCorridasByDate(Calendar start, Calendar end);
	
	List<Corrida> getAllCorridasByMotorista(Motorista motorista);
	
	List<Corrida> getAllCorridasByNamePassageiro(String passageiro);
	
	int getCountCorridaByMotorista(int codigoMotorista, Calendar start, Calendar fim);
	
	List<Corrida> getTopTenCorrida(int codigoPassageiro);
	
	List<Corrida> getAllMotoristaPassageiro(int codigoPassageiro, int codigoMotorista);
	
}
