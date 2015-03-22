package com.model;

/**
 * <br>
 * O motorista que também pode ser considerado um {@link Caroneiro}. Mas a
 * diferença é que ele têm um Veículo. Para o cadastro do motorista o
 * {@link Caroneiro} deverá cadastrar o veículo, automaticamente o sistema
 * deverá reconhece-lo como um usuário.
 * 
 * @author Bruno Clementino e Lucas Miranda
 *
 */
public class Motorista extends Caroneiro {

	private Veiculo veiculo;

	/**
	 * Metodo contrutor
	 */
	public Motorista() {
		
	}
	
	public Motorista(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
