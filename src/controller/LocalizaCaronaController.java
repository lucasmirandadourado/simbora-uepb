package controller;

import java.util.ArrayList;
import java.util.List;

import com.model.Carona;

public class LocalizaCaronaController {

	List<Carona> caronas = new ArrayList<Carona>();
	UsuarioController usuarios = new UsuarioController();
	int sessao;
	
	private void criarUsuario() {
		usuarios = new UsuarioController();
	}
	
	private int abrirSessao(String login, String senha) {
		sessao = usuarios.abrirSessao(login, senha);
		return sessao;
	}
	
	private String localizarCarona(String origem, String destino) {
		for (Carona carona: caronas) {
			if(carona.getLocalDeOrigem().equals(origem) && carona.getLocalDeDestino().equals(destino)){
				return carona.getLocalDeOrigem() + " " + carona.getLocalDeDestino() + " " + carona.getData() 
						+ " " + carona.getHorarioDeSaida() + " " + carona.getQtdDeVagas();
			}
		}		
		return null;
	}
	
	private void cadastrarCarona(String origem, String destino, String data, String hora, int vagas) {
		Carona carona = new Carona();
			carona.setLocalDeOrigem(origem);
			carona.setLocalDeDestino(destino);
			carona.setData(data);
			carona.setHorarioDeSaida(hora);
			carona.setQtdDeVagas(vagas);
		caronas.add(carona);
		
	}

	
	
}
