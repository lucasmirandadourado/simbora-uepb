package com.model;

/**
 * Classe que define o local de origem, local de destino, data da carona,
 * horário de saída e a quantidade de vaga no carro.
 * 
 * @author Lucas Miranda
 * @author Bruno José Clementino
 *
 */
public class Carona {

	private String localDeOrigem;
	private String localDeDestino;
	private String data;
	private String horarioDeSaida;
	private int qtdDeVagas;
	
	private int idCarona;

	/**
	 * Método construtor default.
	 */
	public Carona() {
		// TODO Auto-generated constructor stub
	}

	public String getLocalDeOrigem() {
		return localDeOrigem;
	}

	public void setLocalDeOrigem(String localDeOrigem) {
		this.localDeOrigem = localDeOrigem;
	}

	public String getLocalDeDestino() {
		return localDeDestino;
	}

	public void setLocalDeDestino(String localDeDestino) {
		this.localDeDestino = localDeDestino;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorarioDeSaida() {
		return horarioDeSaida;
	}

	public void setHorarioDeSaida(String horarioDeSaida) {
		this.horarioDeSaida = horarioDeSaida;
	}

	public int getQtdDeVagas() {
		return qtdDeVagas;
	}

	public void setQtdDeVagas(int qtdDeVagas) {
		this.qtdDeVagas = qtdDeVagas;
	}
	
	public int getIdCarona() {
		return idCarona;
	}

	public void setIdCarona(int idCarona) {
		this.idCarona = idCarona;
	}
}
