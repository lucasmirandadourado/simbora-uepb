package com.model;

public class SolicitacaoVagas {
	
	private PontoDeEncontro[] pontoDeEncontro = new PontoDeEncontro[3];//Armazena respectivamente os pontos de sugest�o, resposta e confirma��o
	
	private String idSugestao;
	private boolean emAndamento = true;//Se a solicita��o ainda n�o foi concluida
	
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
