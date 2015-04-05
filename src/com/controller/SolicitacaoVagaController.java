/**
 * 
 */
package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.excessoes.CaronaException;
import com.model.PontoDeEncontro;
import com.model.SolicitacaoVagas;

/**
 * 
 * @author Lucas Miranda e Bruno Clementino
 *
 */
public class SolicitacaoVagaController {

	// US04
	/**
	 * Quando o caroneiro aceitar, deve-se atualizar a quantidade de vagas do carro.
	 * @param idSessao
	 * @param idSolicitacao
	 */
	
	List<SolicitacaoVagas> solicitacoes = new ArrayList<>();
	SolicitacaoVagas solicitacaoVagas;
	PontoDeEncontro pontoDeEncontro;
	
	public String sugerirPontoEncontro(String idSessao, String idCarona, String pontos) throws Exception {
		
		if(pontos==null || pontos.isEmpty()){
			throw new Exception("Ponto Inválido");
		}
		pontoDeEncontro = new PontoDeEncontro();
		pontoDeEncontro.setIdCarona(idCarona);
		pontoDeEncontro.setPontos(pontos);
		pontoDeEncontro.setIdSessao(idSessao);
		
		solicitacaoVagas = new SolicitacaoVagas();
		solicitacaoVagas.setPontoDeEncontro(pontoDeEncontro, 0);//0 indica que esse ponto é o sugerido pelo caroneiro
		
		solicitacoes.add(solicitacaoVagas);
		solicitacaoVagas.setIdSugestao(solicitacoes.indexOf(solicitacaoVagas)+"");//Para gerar o id da solicitação

		return solicitacaoVagas.getIdSugestao();
	}
	
	public String responderSugestaoPontoEncontro(String idSessao,
			String idCarona, String idSugestao, String pontos) throws Exception {
		
		if(pontos==null || pontos.isEmpty()){
			throw new Exception("Ponto Inválido");
		}
		
		pontoDeEncontro = new PontoDeEncontro();
		pontoDeEncontro.setIdCarona(idCarona);
		pontoDeEncontro.setPontos(pontos);
		pontoDeEncontro.setIdSessao(idSessao);
		
		for(SolicitacaoVagas solicitacao : solicitacoes){
			solicitacaoVagas = solicitacao;
			if(solicitacao.getIdSugestao().equals(idSugestao)){
				solicitacaoVagas.setPontoDeEncontro(pontoDeEncontro, 1);//1 indica que esse ponto é resposta do motorista
			}
		}
		
		

		return "";
	}
	
	public String solicitarVagaPontoEncontro(String idSessao, String idCarona, String ponto) {
		
		pontoDeEncontro = new PontoDeEncontro();
		pontoDeEncontro.setIdCarona(idCarona);
		pontoDeEncontro.setPontos(ponto);
		pontoDeEncontro.setIdSessao(idSessao);
		
		PontoDeEncontro encontro;
		for(SolicitacaoVagas solicitacao : solicitacoes){
			encontro = solicitacao.getPontoDeEncontro(0);
			if(encontro.getIdSessao().equals(idSessao) && encontro.getIdCarona().equals(idCarona)){
				solicitacao.setPontoDeEncontro(pontoDeEncontro, 2);//2 indica que esse ponto é a confirmação do encontro pelo caroneiro
				return solicitacao.getIdSugestao();
			}
		}
		
		return "";
	}
	
	public String getAtributoSolicitacao(String idSolicitacao, String atributo) throws CaronaException {
		for(SolicitacaoVagas solicitacao : solicitacoes){
			if(solicitacao.getIdSugestao().equals(idSolicitacao)){
				//return new CaronaController().getAtributoCarona(encontro.getIdCarona(), atributo);
				return getAtributo(solicitacao, atributo);
			}
		}
		return "";
	}
	private String getAtributo(SolicitacaoVagas solicitacao, String atributo) {
		PontoDeEncontro encontro = solicitacao.getPontoDeEncontro(2);
		try {
			return new CaronaController().getAtributoCarona(encontro.getIdCarona(), atributo);
		} catch (Exception e) {}
		
		if(atributo.equals("Dono da carona")){
			encontro = solicitacao.getPontoDeEncontro(1);
			return new UsuarioController().getAtributoUsuario(encontro.getIdSessao(), "nome");
		}
		
		if(atributo.equals("Dono da solicitacao")){
			encontro = solicitacao.getPontoDeEncontro(0);
			return new UsuarioController().getAtributoUsuario(encontro.getIdSessao(), "nome");
		}
		
		if(atributo.equals("Ponto de Encontro")){
			encontro = solicitacao.getPontoDeEncontro(2);
			return encontro.getPontos();//retorna apenas o ponto de encontro marcado
		}
		
		return "";
	}

	public void aceitarSolicitacaoPontoEncontro(String idSessao, String idSolicitacao) throws Exception { 
		
		for(SolicitacaoVagas solicitacao : solicitacoes){
			
			if(solicitacao.getIdSugestao().equals(idSolicitacao) && solicitacao.isEmAndamento()){
				PontoDeEncontro encontro = solicitacao.getPontoDeEncontro(2);
				new CaronaController().reduzQtdVagas(encontro.getIdCarona());
				solicitacao.setEmAndamento(false);
				return;
			}
		}
		throw new Exception("Solicitação inexistente");
		
	}
	
	public void desistirRequisicao(String idSessao, String idCarona, String idSolicitacao) throws Exception{
		for(SolicitacaoVagas solicitacao : solicitacoes){
			
			if(solicitacao.getIdSugestao().equals(idSolicitacao) && !solicitacao.isEmAndamento()){
				PontoDeEncontro encontro = solicitacao.getPontoDeEncontro(2);
				new CaronaController().aumentaQtdVagas(encontro.getIdCarona());
				solicitacao.setEmAndamento(true);
				return;
			}
		}
		throw new Exception("Solicitação inexistente");
	}
	
	
	

	
	

}