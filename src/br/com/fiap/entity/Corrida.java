package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CORRIDA")
@SequenceGenerator(name="corrida", sequenceName="SQ_T_CORRIDA", allocationSize=1)
public class Corrida {
	
	@Id
	@Column(name = "cd_corrida")
	@GeneratedValue(generator="corrida", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_origim", length=150)
	private String origim;
	
	@Column(name="ds_destino", length=150)
	private String destino;
	
	@Column(name="dt_corrida")
	@Temporal(TemporalType.DATE)
	private Calendar dataCorrida;
	
	@Column(name="vl_corrida", nullable=false)
	private double valorCorrida;
	
}
