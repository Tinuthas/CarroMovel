package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_CORRIDA")
@SequenceGenerator(name = "corrida", sequenceName = "SQ_T_CORRIDA", allocationSize = 1)
public class Corrida {

	@Id
	@Column(name = "cd_corrida")
	@GeneratedValue(generator = "corrida", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_origim", length = 150)
	private String origim;

	@Column(name = "ds_destino", length = 150)
	private String destino;

	@Column(name = "dt_corrida")
	@Temporal(TemporalType.DATE)
	private Calendar dataCorrida;

	@Column(name = "vl_corrida", nullable = false)
	private double valorCorrida;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_passageiro")
	private Passageiro passageiro;

	@OneToOne(mappedBy = "corrida")
	private Pagamento pagamento;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_motorista")
	private Motorista motorista;

	public Corrida() {
		super();
	}

	public Corrida(String origim, String destino, Calendar dataCorrida, double valorCorrida) {
		super();
		this.origim = origim;
		this.destino = destino;
		this.dataCorrida = dataCorrida;
		this.valorCorrida = valorCorrida;
	}
	
	public Corrida(int codigo, String origim, String destino, Calendar dataCorrida, double valorCorrida) {
		super();
		this.codigo = codigo;
		this.origim = origim;
		this.destino = destino;
		this.dataCorrida = dataCorrida;
		this.valorCorrida = valorCorrida;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getOrigim() {
		return origim;
	}

	public void setOrigim(String origim) {
		this.origim = origim;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Calendar getDataCorrida() {
		return dataCorrida;
	}

	public void setDataCorrida(Calendar dataCorrida) {
		this.dataCorrida = dataCorrida;
	}

	public double getValorCorrida() {
		return valorCorrida;
	}

	public void setValorCorrida(double valorCorrida) {
		this.valorCorrida = valorCorrida;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	

}
