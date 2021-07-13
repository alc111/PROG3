package model.io;

import model.Game;
/**
 * CLASE VISUALISERCONSOLE: Esta clase representa un visor del juego por consola
 * @author Angel Leon Cerdan
 *
 */

public class VisualiserConsole implements IVisualiser{
	/**
	 * game:Juego a visualizar
	 */
	private Game game;
	/**
	 * CONSTRUCTOR VISUALISERCONSOLE
	 * @param g El juego a visualizar
	 */
	public VisualiserConsole(Game g) {
		if(g!=null) {
			this.game=g;
		}else {
			throw new NullPointerException("El juego apunta a null");
		}		
	}
	/**
	 * ESTE METODO MUESTRA LA SITUACION DEL JUEGO POR PANTALLA
	 */
	public void show() {
		System.out.println(game.toString());		
	}
	/**
	 * ESTE METODO CIERRA EL VISOR
	 */
	public void close() {
		
	}

}
