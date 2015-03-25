package controller;

import java.util.ArrayList;
import java.util.List;

import com.excessoes.CaronaException;
import com.model.Carona;

public class CaronaController {
	
	List<Carona> caronas = new ArrayList<>();
	Carona carona;

	public String localizarCarona(int idSessao, String origem , String destino) throws Exception{
		
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
		boolean flag = true;//indica se a quantidade de ids � 0
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
		boolean flag = true;//indica se a quantidade de ids � 0 (Serve para auxiliar na formata��o da string de retorno
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
		boolean flag = true;//indica se a quantidade de ids � 0
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
		boolean flag = true;//indica se a quantidade de ids � 0
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
	
	public int cadastrarCarona(Integer idSessao, String origem, String destino, String data, String hora, int qtdDeVagas) throws CaronaException {
//		if (idSessao.equals(null)) {
//			throw new CaronaException("Sess�o inv�lida");
//		}
		carona = new Carona();
			carona.setLocalDeOrigem(origem);
			carona.setLocalDeDestino(destino);
			carona.setData(data);
			carona.setHorarioDeSaida(hora);
			carona.setQtdDeVagas(qtdDeVagas);
		caronas.add(carona);
		carona.setIdCarona(caronas.indexOf(carona));
		return carona.getIdCarona();
		
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
