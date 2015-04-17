package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.excessoes.PerfilException;
import com.model.Carona;
import com.model.SolicitacaoVagas;
import com.model.Usuario;

public class PerfilController {
	
	public static List<String> caronasSegurasTranquilas = new ArrayList<>();
	public static List<String> caronasNaoFuncionaram = new ArrayList<>();
	public static List<String> faltaramNasVagas = new ArrayList<>();
	public static List<String> presenteNasVagas = new ArrayList<>();
	
	public String visualizarPerfil(String idSessao, String login) throws PerfilException{
		
		if(login==null || login.trim().isEmpty()){
			throw new PerfilException("Login inválido");
		}
		
		if(idSessao==null || idSessao.trim().isEmpty()){
			throw new PerfilException("Sessão inválida");
		}
		
		for(Usuario usuario : new UsuarioController().usuarios){
			if(usuario.getLogin().equals(login)){
				return usuario.getLogin();
			}
		}
		
		throw new PerfilException("Login inválido");
		
	}
	
	public String getAtributoPerfil(String login, String atributo) throws PerfilException{
		
		for(Usuario usuario : new UsuarioController().usuarios){
			if(usuario.getLogin().equals(login)){
				return getAtributo(login, atributo);
			}
		}
		
		return null;
	}

	private String getAtributo(String login, String atributo) throws PerfilException {
		if(atributo==null || atributo.trim().isEmpty()){
			throw new PerfilException("Atributo inválido");
		}
		if(login==null || login.trim().isEmpty()){
			throw new PerfilException("Login inválido");
		}
		if(atributo.equals("historico de caronas")){
			String caron = "[";
			for(Carona carona : CaronaController.getCaronas()){
				if(carona.getIdSessao().equals(login)){
					caron+=carona.getIdCarona();
				}
			}
			return caron+"]";
		}
		
		if(atributo.equals("historico de vagas em caronas")){
			String caron = "[";
			for(SolicitacaoVagas solicitacaoVagas : SolicitacaoVagasController.solicitacoesVagas){
				if(solicitacaoVagas.getIdSessao().equals(login)){
					caron+=solicitacaoVagas.getIdCarona();
				}
			}
			return caron+"]";
		}
		
		if(atributo.equals("caronas seguras e tranquilas")){
			int caron = 0;
			for(String idCarona : caronasSegurasTranquilas){
				if(CaronaController.ehMotorista(login, idCarona)){
					caron++;
				}
			}
			return caron+"";
		}
		
		if(atributo.equals("caronas que não funcionaram")){
			int caron = 0;
			for(String idCarona : caronasNaoFuncionaram){
				if(CaronaController.ehMotorista(login, idCarona)){
					caron++;
				}
			}
			return caron+"";
		}
		
		if(atributo.equals("faltas em vagas de caronas")){
			int caron = 0;
			for(String idUsuario : faltaramNasVagas){
				if(idUsuario.equals(login) && SolicitacaoVagasController.ehCaroneiro(login)){
					caron++;
				}
			}
			return caron+"";
		}
		
		if(atributo.equals("presenças em vagas de caronas")){
			int caron = 0;
			for(String idUsuario : presenteNasVagas){
				if(idUsuario.equals(login) && SolicitacaoVagasController.ehCaroneiro(login)){
					caron++;
				}
			}
			return caron+"";
		}
		
		return new UsuarioController().getAtributoUsuario(login, atributo);
	}

}
