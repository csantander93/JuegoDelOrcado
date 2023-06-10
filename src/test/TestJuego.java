package test;

import modelo.Juego;
import modelo.Jugador;
import java.util.Scanner;

public class TestJuego {

	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese nombre de jugador 1");
		String j1 = scan.nextLine();
		
		System.out.println("Ingrese nombre de jugador 2");
		String j2 = scan.nextLine();
		
		Jugador jugador1=new Jugador(j1);
		Jugador jugador2=new Jugador(j2);
		
		System.out.println("Ingrese palabra del juego");
		String palabra = scan.nextLine();
		Juego juego = new Juego(jugador1, jugador2, palabra);
		juguemosOrcado(juego);
		
		
		

	}
	
	
	public static void juguemosOrcado(Juego juego1){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\n\n"+juego1.getJugador2().getNombre()+" te toca adivinar !!!\n\n");
	   
	   do {
		  
		   mostrarProceso(juego1);
		   System.out.println("\nIngrese letra");
		   char letra = scan.next().charAt(0);
		   boolean proceso = juego1.insertarLetra(letra);
		   
		   if(!proceso) {
			   System.out.println("\n\n-- Letra incorrecta, pierdes 1 vida --");
			   juego1.setVidas(juego1.getVidas()-1);
		   }else
			   System.out.println("\n\n-- ACERTASTE !!! --\n");
		   
		   if(juego1.getVidas()==0 || juego1.getPalabra().equals(juego1.getAcertados())){
		   
		     if(juego1.getVidas()==0) {
			   juego1.setGanador(juego1.getJugador1());
		     }else if(juego1.getPalabra().equals(juego1.getAcertados())) {
			   juego1.setGanador(juego1.getJugador2());
			   System.out.println("LA PALABRA FUE ACERTADA\nLA PALABRA ES : "+juego1.getAcertados());
		     }
		    mostrarGanador(juego1);
		   }	   
	   }while(juego1.getVidas() > 0 && !juego1.getPalabra().equals(juego1.getAcertados()));
	   
	   
	
	}
	
	public static void mostrarProceso(Juego juego) {
		System.out.println("\n-----------poceso de juego--------\n");
		System.out.println(juego.getAcertados()+"              vidas:"+juego.getVidas());
		System.out.println("\n-----------------------------------\n\n\n\n");
	}
	
	public static void mostrarGanador(Juego juego) {
		System.out.println("\n\nFELICIDADES "+ juego.getGanador().getNombre()+" GANASTE LA PARTIDA !!!!!!!!!");
	}

}






















