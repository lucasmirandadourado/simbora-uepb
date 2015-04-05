package com.model;

/**
 * 
 * @author Lucas Miranda e Bruno Clementino
 *
 */
public class SolicitacaoVagas {
	/**
	 * Armazena respectivamente os pontos de sugestão (0), resposta (1) e
	 * confirmação (2).
	 * 
	 */
	private PontoDeEncontro[] pontoDeEncontro = new PontoDeEncontro[3];

	private String idSugestao;
	private boolean emAndamento = true;// Se a solicitação ainda não foi
										// concluída

	public PontoDeEncontro getPontoDeEncontro(int indice) {
		return pontoDeEncontro[indice];
	}

	public void setPontoDeEncontro(PontoDeEncontro pontoDeEncontro, int indice) {
		this.pontoDeEncontro[indice] = pontoDeEncontro;
	}

	public String getIdSugestao() {
		return idSugestao;
	}

	public void setIdSugestao(String idSugestao) {
		this.idSugestao = idSugestao;
	}

	public boolean isEmAndamento() {
		return emAndamento;
	}

	public void setEmAndamento(boolean emAndamento) {
		this.emAndamento = emAndamento;
	}
}
