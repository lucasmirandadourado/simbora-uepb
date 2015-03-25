package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.excessoes.CaronaException;
import com.model.Carona;

public class CaronaController {
	
	List<Carona> caronas = new ArrayList<>();
	Carona carona;

	public String localizarCarona(String idSessao, String origem , String destino) throws Exception{
		if (idSessao==null) {
			throw new CaronaException("Sessão inválida");
		}
		
		if(!origem.isEmpty() && !destino.isEmpty()){
			return origemDestinoCarona(origem, destino);
		}
		
		if(origem.isEmpty() && destino.isEmpty()){
			return origemDestinoCarona();
		}
		
		if(origem.isEmpty()){
			return destinoCarona(destino);
		}
		
		if(destino.isEmpty()){
			return origemCarona(origem);
		}
		
		return "";
		 
	}
	
	private String origemDestinoCarona(String origem , String destino){
		String ids = "{";
		boolean flag = true;//indica se a quantidade de ids é 0
		for(Carona carona : caronas){
			if(carona.getLocalDeOrigem().equals(origem) && carona.getLocalDeDestino().equals(destino)){
				if(!flag){
					ids+=",";
				}
				ids+=carona.getIdCarona();
				flag = false;
			}
		}
		
		return ids+"}";
	}
	
	private String origemDestinoCarona(){
		String ids = "{";
		boolean flag = true;//indica se a quantidade de ids é 0 (Serve para auxiliar na formatação da string de retorno
		for(Carona carona : caronas){
				if(!flag){
					ids+=",";
				}
				ids+=carona.getIdCarona();
				flag=false;
		}
		
		return ids+"}";
	}
	
	private String origemCarona(String origem){
		String ids = "{";
		boolean flag = true;//indica se a quantidade de ids é 0
		for(Carona carona : caronas){
			if(carona.getLocalDeOrigem().equals(origem)){
				if(!flag){
					ids+=",";
				}
				ids+=carona.getIdCarona();
				flag=false;
			}
		}
		
		return ids+"}";
	}
	
	private String destinoCarona(String destino){
		String ids = "{";
		boolean flag = true;//indica se a quantidade de ids é 0
		for(Carona carona : caronas){
			if(carona.getLocalDeDestino().equals(destino)){
				if(!flag){
					ids+=",";
				}
				ids+=carona.getIdCarona();
				flag=false;
			}
		}
		
		return ids+"}";
	}
	
	public String cadastrarCarona(String idSessao, String origem, String destino, String data, String hora, Integer qtdDeVagas) throws CaronaException {
		if (idSessao==null || idSessao.isEmpty()) {
			throw new CaronaException("Sessão inválida");
		}
		if(!isNumero(idSessao)){
			throw new CaronaException("Sessão inexistente");
		}
		if(origem==null || origem.isEmpty()){
			throw new CaronaException("Origem inválida");
		}
		if(destino==null || destino.isEmpty()){
			throw new CaronaException("Destino inválido");
		}
		if(data==null || data.isEmpty()){
			throw new CaronaException("Data inválida");
		}
		if(!isData(data)){
			throw new CaronaException("Data inválida");
		}
		if(hora == null || hora.isEmpty()){
			throw new CaronaException("Hora inválida");
		}
		if(!isHora(hora)){
			throw new CaronaException("Hora inválida");
		}
		if (qtdDeVagas == null) {
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
		return carona.getIdCarona()+"";
		
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
	
	private boolean isNumero(String idSessao){
		try {
			int id = Integer.parseInt(idSessao);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public String getAtributoCarona(int idCarona, String atributo){
		if(atributo.equals("origem")){
			return caronas.get(idCarona).getLocalDeOrigem();
		}
		if(atributo.equals("destino")){
			return caronas.get(idCarona).getLocalDeDestino();
		}
		if(atributo.equals("data")){
			return caronas.get(idCarona).getData();
		}
		if(atributo.equals("vagas")){
			return caronas.get(idCarona).getQtdDeVagas()+"";
		}
		return "";
	}
	
	public String getTrajeto(int idCarona){
		return caronas.get(idCarona).getLocalDeOrigem()+ " - "+ caronas.get(idCarona).getLocalDeDestino();
	}
	
	public String getCarona(int idCarona){
		Carona carona = caronas.get(idCarona);
		return carona.getLocalDeOrigem()+" para "+
				carona.getLocalDeDestino()+", no dia "+
				carona.getData()+", as "+
				carona.getHorarioDeSaida();
	}
}
