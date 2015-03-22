package com.model;

/**
 * <br>
 * O motorista que tamb�m pode ser considerado um {@link Caroneiro}. Mas a
 * diferen�a � que ele t�m um Ve�culo. Para o cadastro do motorista o
 * {@link Caroneiro} dever� cadastrar o ve�culo, automaticamente o sistema
 * dever� reconhece-lo como um usu�rio.
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
