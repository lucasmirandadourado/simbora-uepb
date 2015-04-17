package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.lang.Integer;
import java.util.List;

import com.excessoes.CaronaException;
import com.model.Carona;
import com.model.Sessao;
/**
 * 
 * @author Lucas Miranda e Bruno Clementino
 *
 */
public class CaronaController {

	private static List<Carona> caronas = new ArrayList<Carona>();
	Carona carona;
	List<Sessao> sessao = SessaoController.getSessoes();

	public void zerarSistema() {
		caronas.clear();
	}

	public String localizarCarona(String idSessao, String origem, String destino)
			throws Exception {
		if (idSessao == null) {
			throw new CaronaException("Sess�o inv�lida");
		}

		if (origem.equals("-") || origem.equals("()") || origem.equals("!")
				|| origem.equals("!?")) {
			throw new CaronaException("Origem inv�lida");
		}

		if (destino.equals(".") || destino.equals("()") || destino.equals("!?")) {
			throw new CaronaException("Destino inv�lido");
		}

		if (!origem.isEmpty() && !destino.isEmpty()) {
			return origemDestinoCarona(origem, destino);
		}

		if (origem.isEmpty() && destino.isEmpty()) {
			return origemDestinoCarona();
		}

		if (origem.isEmpty() && !destino.isEmpty()) {
			return destinoCarona(destino);
		}

		if (!origem.isEmpty() && destino.isEmpty()) {
			return origemCarona(origem);
		}
		return "";

	}

	private String origemDestinoCarona(String origem, String destino) {
		String ids = "{";
		boolean flag = true;// indica se a quantidade de ids � 0
		for (Carona carona : caronas) {
			if (carona.getLocalDeOrigem().equals(origem)
					&& carona.getLocalDeDestino().equals(destino)) {
				if (!flag) {
					ids += ",";
				}
				ids += carona.getIdCarona();
				flag = false;
			}
			if (ids.equals("{0") || ids.equals("{0,")) {
				ids = "{";
				flag = true;
			}
		}

		return ids + "}";
	}

	private String origemDestinoCarona() {
		String ids = "{";
		boolean flag = true;// indica se a quantidade de ids � 0 (Serve para
							// auxiliar na formata��o da string de retorno
		for (Carona carona : caronas) {
			if (!flag) {
				ids += ",";
			}
			ids += carona.getIdCarona();
			flag = false;
		}

		return ids + "}";
	}

	private String origemCarona(String origem) {
		String ids = "{";
		boolean flag = true;// indica se a quantidade de ids � 0
		for (Carona carona : caronas) {
			if (carona.getLocalDeOrigem().equals(origem)) {
				if (!flag) {
					ids += ",";
				}
				ids += carona.getIdCarona();
				flag = false;
			}
		}

		return ids + "}";
	}

	private String destinoCarona(String destino) {
		String ids = "{";
		boolean flag = true;// indica se a quantidade de ids � 0
		for (Carona carona : caronas) {
			if (carona.getLocalDeDestino().equals(destino)) {
				if (!flag) {
					ids += ",";
				}
				ids += carona.getIdCarona();
				flag = false;
			}
		}

		return ids + "}";
	}

	public String cadastrarCarona(String idSessao, String origem,
			String destino, String data, String hora, String qtdDeVagas)
			throws CaronaException {
		if (idSessao == null || idSessao.isEmpty()) {
			throw new CaronaException("Sess�o inv�lida");
		}
		if (!SessaoController.hasSessao(idSessao)) {
			throw new CaronaException("Sess�o inexistente");
		}
		if (origem == null || origem.isEmpty()) {
			throw new CaronaException("Origem inv�lida");
		}
		if (destino == null || destino.isEmpty()) {
			throw new CaronaException("Destino inv�lido");
		}
		if (data == null || data.isEmpty()) {
			throw new CaronaException("Data inv�lida");
		}
		if (!isData(data)) {
			throw new CaronaException("Data inv�lida");
		}
		if (hora == null || hora.isEmpty()) {
			throw new CaronaException("Hora inv�lida");
		}
		if (!isHora(hora)) {
			throw new CaronaException("Hora inv�lida");
		}
		if (qtdDeVagas == null || qtdDeVagas == "") {
			throw new CaronaException("Vaga inv�lida");
		}
		try {
			Integer.parseInt(qtdDeVagas);
		} catch (Exception e) {
			throw new CaronaException("Vaga inv�lida");
		}

		carona = new Carona();
		carona.setLocalDeOrigem(origem);
		carona.setLocalDeDestino(destino);
		carona.setData(data);
		carona.setHorarioDeSaida(hora);
		carona.setQtdDeVagas(qtdDeVagas);
		carona.setIdSessao(idSessao);
		caronas.add(carona);
		carona.setIdCarona((caronas.indexOf(carona)) + "");
		return carona.getIdCarona() + "";

	}

	@SuppressWarnings("unused")
	private boolean isData(String data) {
		try {
			SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
			formatoData.setLenient(false);
			Date dataFormatada = formatoData.parse(data);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unused")
	private boolean isHora(String data) {
		try {
			SimpleDateFormat formatoData = new SimpleDateFormat("HH:mm");
			formatoData.setLenient(false);
			Date dataFormatada = formatoData.parse(data);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param idCarona
	 * @param atributo
	 * @return
	 * @throws CaronaException
	 */
	public String getAtributoCarona(String idCarona, String atributo)
			throws CaronaException {
		if (idCarona == null || idCarona.equals("")) {
			throw new CaronaException("Identificador do carona � inv�lido");
		}

		if (atributo == null) {
			throw new CaronaException("Atributo inv�lido");
		}
		if (atributo.equals("")) {
			throw new CaronaException("Atributo inv�lido");
		}
		if (!idCaronaExistir(idCarona)) {
			throw new CaronaException("Item inexistente");
		}

		if (atributo.equals("origem")) {
			return caronas.get(Integer.valueOf(idCarona)).getLocalDeOrigem();
		}
		if (atributo.equals("destino")) {
			return caronas.get(Integer.valueOf(idCarona)).getLocalDeDestino();
		}
		if (atributo.equals("data")) {
			return caronas.get(Integer.valueOf(idCarona)).getData();
		}
		if (atributo.equals("vagas")) {
			return caronas.get(Integer.valueOf(idCarona)).getQtdDeVagas() + "";
		}

		throw new CaronaException("Atributo inexistente");
	}

	private boolean idCaronaExistir(String idCarona) {
		for (Carona carona : caronas) {
			if ((carona.getIdCarona().equals(idCarona))) {
				return true;
			}
		}
		return false;
	}

	public String getTrajeto(String idCarona) throws CaronaException {
		if (idCarona == null) {
			throw new CaronaException("Trajeto Inv�lida");
		}
		if (idCarona == "") {
			throw new CaronaException("Trajeto Inexistente");
		}
		try {
			Integer.valueOf(idCarona);
		} catch (Exception e) {
			throw new CaronaException("Trajeto Inexistente");
		}
		return caronas.get(Integer.valueOf(idCarona)).getLocalDeOrigem()
				+ " - "
				+ caronas.get(Integer.valueOf(idCarona)).getLocalDeDestino();
	}

	public String getCarona(String idCarona) throws CaronaException {
		if (idCarona == null || String.valueOf(idCarona) == "") {
			throw new CaronaException("Carona Inv�lida");
		}

		try {
			Integer.valueOf(idCarona);
		} catch (Exception e) {
			throw new CaronaException("Carona Inexistente");
		}
		Carona carona = caronas.get(Integer.valueOf(idCarona));
		return carona.getLocalDeOrigem() + " para "
				+ carona.getLocalDeDestino() + ", no dia " + carona.getData()
				+ ", as " + carona.getHorarioDeSaida();
	}

	public static List<Carona> getCaronas() {
		return caronas;
	}

	public static void setCaronas(List<Carona> caronas) {
		CaronaController.caronas = caronas;
	}

	public Carona getCarona() {
		return carona;
	}

	public void setCarona(Carona carona) {
		this.carona = carona;
	}

	public List<Sessao> getSessao() {
		return sessao;
	}

	public void setSessao(List<Sessao> sessao) {
		this.sessao = sessao;
	}
	
	public void reduzQtdVagas(String idcarona){
		
		for(Carona carona : caronas){
			if(carona.getIdCarona().equals(idcarona)){
				int qtdVagasAtual = Integer.parseInt(carona.getQtdDeVagas()) - 1;
				carona.setQtdDeVagas(qtdVagasAtual+"");
			}
		}
	}
	
	public void aumentaQtdVagas(String idcarona){
		
		for(Carona carona : caronas){
			if(carona.getIdCarona().equals(idcarona)){
				int qtdVagasAtual = Integer.parseInt(carona.getQtdDeVagas()) + 1;
				carona.setQtdDeVagas(qtdVagasAtual+"");
			}
		}
	}
	
	public static boolean ehMotorista(String login, String idCarona){
		for(Carona carona : caronas){
			if(idCarona.equals(carona.getIdCarona() )&& login.equals(carona.getIdSessao())){
				return true;
			}
		}
		
		return false;
	}
	
}
