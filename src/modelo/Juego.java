package modelo;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador ganador;
	private String palabra;
	private String acertados;
	private int vidas;
	
	public Juego(Jugador jugador1, Jugador jugador2, String palabra) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.ganador = null;
		this.palabra = palabra;
		 setAcertados();
		this.vidas = 7;
	}



	public Jugador getJugador1() {
		return jugador1;
	}



	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}



	public Jugador getJugador2() {
		return jugador2;
	}



	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}



	public Jugador getGanador() {
		return ganador;
	}



	public void setGanador(Jugador ganador) {
		this.ganador = ganador;
	}



	public String getPalabra() {
		return palabra;
	}



	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}



	public String getAcertados() {
		return acertados;
	}

	
	public void setAcertados() {
		char[] vectorLetras=palabra.toCharArray();
    	for(int i=0; i<vectorLetras.length; i++) {
    		if(vectorLetras[i]!=' ') 
    			vectorLetras[i]='-';
    		}
    	
    	this.acertados = String.copyValueOf(vectorLetras); 
	}
	
	

	public int getVidas() {
		return vidas;
	}



	public void setVidas(int vidas) {
		this.vidas = vidas;
	}


   
    public boolean insertarLetra(char c) {
    	boolean retorno = false;
    	List<Integer> posiciones = posicionesDeLaLetra(c);
        if(posiciones.isEmpty()) {
        	retorno = false;
        }else {
        	char[] vectorAcertados = acertados.toCharArray();
        	for(int i = 0; i < posiciones.size(); i++) {
        		vectorAcertados[posiciones.get(i)]=c;
        	}
        	acertados = String.copyValueOf(vectorAcertados);
        	retorno = true;
         }
     	return retorno;
  }
    
    public List<Integer> posicionesDeLaLetra(char c) {
    	List<Integer> posiciones = new ArrayList<Integer>();
    	for(int i=0; i<palabra.length(); i++) {
    		if(palabra.charAt(i)==c)
    			posiciones.add(i);
    	}
    	return posiciones;	
    }



	@Override
	public String toString() {
		return "Juego [jugador1=" + jugador1 + ", jugador2=" + jugador2 + ", ganador=" + ganador + ", palabra="
				+ palabra + ", acertados=" + acertados + ", vidas=" + vidas + "]";
	}




}
	
	