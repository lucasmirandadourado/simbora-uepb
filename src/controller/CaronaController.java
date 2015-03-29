package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.lang.Integer;
import java.util.List;

import com.excessoes.CaronaException;
import com.model.Carona;

public class CaronaController {

	List<Carona> caronas = new ArrayList<>();
	Carona carona;

	public String localizarCarona(String idSessao, String origem, String destino)
			throws Exception {
		if (idSessao == null) {
			throw new CaronaException("Sessão inválida");
		}

		if (origem.equals("-") || origem.equals("()") || origem.equals("!")
				|| origem.equals("!?")) {
			throw new CaronaException("Origem inválida");
		}

		if (destino.equals(".") || destino.equals("()") || destino.equals("!?")) {
			throw new CaronaException("Destino inválido");
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
		boolean flag = true;// indica se a quantidade de ids é 0
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
			}
		}
		  
		return ids + "}";
	}

	private String origemDestinoCarona() {
		String ids = "{";
		boolean flag = true;// indica se a quantidade de ids é 0 (Serve para
							// auxiliar na formatação da string de retorno
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
		boolean flag = true;// indica se a quantidade de ids é 0
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
		boolean flag = true;// indica se a quantidade de ids é 0
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
			throw new CaronaException("Sessão inválida");
		}
		if (!isNumero(idSessao)) {
			throw new CaronaException("Sessão inexistente");
		}
		if (origem == null || origem.isEmpty()) {
			throw new CaronaException("Origem inválida");
		}
		if (destino == null || destino.isEmpty()) {
			throw new CaronaException("Destino inválido");
		}
		if (data == null || data.isEmpty()) {
			throw new CaronaException("Data inválida");
		}
		if (!isData(data)) {
			throw new CaronaException("Data inválida");
		}
		if (hora == null || hora.isEmpty()) {
			throw new CaronaException("Hora inválida");
		}
		if (!isHora(hora)) {
			throw new CaronaException("Hora inválida");
		}
		if (qtdDeVagas == null || qtdDeVagas == "") {
			throw new CaronaException("Vaga inválida");
		}
		try {
			Integer.parseInt(qtdDeVagas);
		} catch (Exception e) {
			throw new CaronaException("Vaga inválida");
		}

		carona = new Carona();
		carona.setLocalDeOrigem(origem);
		carona.setLocalDeDestino(destino);
		carona.setData(data);
		carona.setHorarioDeSaida(hora);
		carona.setQtdDeVagas(qtdDeVagas);
		caronas.add(carona);
		carona.setIdCarona(caronas.indexOf(carona));
		return carona.getIdCarona() + "";

	}

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

	private boolean isNumero(String idSessao) {
		try {
			int id = Integer.parseInt(idSessao);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public String getAtributoCarona(String idCarona, String atributo)
			throws CaronaException {
		if (idCarona == null || idCarona.equals("")) {
			throw new CaronaException("Identificador do carona é inválido");
		}

		if (atributo == null) {
			throw new CaronaException("Atributo inválido");
		}
		if (atributo.equals("")) {
			throw new CaronaException("Atributo inválido");
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
		try {
			Integer.valueOf(atributo);
		} catch (Exception e) {
			throw new CaronaException("Atributo inexistente");
		}

		return "";
	}

	public String getTrajeto(String idCarona) throws CaronaException {
		if (idCarona == null) {
			throw new CaronaException("Trajeto Inválida");
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
			throw new CaronaException("Carona Inválida");
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
}
