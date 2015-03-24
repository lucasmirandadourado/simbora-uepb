package controller;

import java.util.ArrayList;
import java.util.List;

import com.model.Carona;

public class LocalizaCaronaController {

	List<Carona> caronas = new ArrayList<Carona>();
	UsuarioController usuarios = new UsuarioController();
	int sessao;
	
	public List<Carona> localizarCarona(int sessao, String origem, String destino) {
		List<Carona> listaCaronas = new ArrayList<Carona>();
		for (Carona carona: caronas) {
			if(carona.getLocalDeOrigem().equals(origem) && carona.getLocalDeDestino().equals(destino)){
				listaCaronas.add(carona);
			}
		}		
		return listaCaronas;
	}
	
	public void cadastrarCarona(String origem, String destino, String data, String hora, int vagas) {
		Carona carona = new Carona();
			carona.setLocalDeOrigem(origem);
			carona.setLocalDeDestino(destino);
			carona.setData(data);
			carona.setHorarioDeSaida(hora);
			carona.setQtdDeVagas(vagas);
		caronas.add(carona);
		
	}

}
