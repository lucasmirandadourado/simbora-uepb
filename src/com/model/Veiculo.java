package com.model;

/**
 * O sistema permite que seja cadastrado qualquer tipo de {@link Veiculo}.
 * Simbora não garante a segurança dos caroneiros, isso fica por conta do
 * motorista e passageiro. <br>
 * O Veiculo deverá ter: modelo, cor do carro, placa, cidade e dono do carro. Essas
 * informações deveram ser utilizada para dar maior confiança aos coroeiros.
 *
 * @author Lucas Miranda
 *
 */
public class Veiculo {

	String modeloVeiculo, cor, placa, dono, cidade;

	/**
	 * Metodo construtor default
	 */
	public Veiculo() {
		
	}
	
	/**
	 * Metodo construtor.
	 * 
	 * @param modeloVaiculo
	 * @param placa
	 * @param cidade
	 */
	public Veiculo(String modeloVaiculo, String placa, String cidade) {
		this.modeloVeiculo = modeloVaiculo;
		this.placa = placa;
		this.cidade = cidade;
	}
	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
