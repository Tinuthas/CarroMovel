package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "pagamento", sequenceName = "SQ_T_PAGAMENTO", allocationSize = 1)
@Table(name = "T_PAGAMENTO")
public class Pagamento {

	@Id
	@Column(name = "cd_pagamento")
	@GeneratedValue(generator = "pagamento", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "dt_pagamento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataPagamento;

	@Column(name = "vl_pagamento", nullable = false)
	private double valorPagamento;

	@Column(name = "ds_forma_pagamento", nullable = false)
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_corrida")
	private Corrida corrida;

	public Pagamento() {
		super();
	}

	public Pagamento(Calendar dataPagamento, double valorPagamento, FormaPagamento formaPagamento) {
		super();
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.formaPagamento = formaPagamento;
	}

	public Pagamento(int codigo, Calendar dataPagamento, double valorPagamento, FormaPagamento formaPagamento) {
		super();
		this.codigo = codigo;
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.formaPagamento = formaPagamento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}

}
