package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="pagamento", sequenceName="SQ_T_PAGAMENTO", allocationSize=1)
@Table(name = "T_PAGAMENTO")
public class Pagamento {
	
	@Id
	@Column(name="cd_pagamento")
	@GeneratedValue(generator="pagamento", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="dt_pagamento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataPagamento;
	
	@Column(name="vl_pagamento", nullable=false)
	private double valorPagamento;
	
	@Column(name="ds_forma_pagamento", nullable=false)
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;
	
}
