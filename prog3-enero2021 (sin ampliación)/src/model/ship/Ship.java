package model.ship;

import model.Craft;
import model.Orientation;

/**
 * 
 * @author Angel Leon Cerdan 74379711B
 * CLASS SHIP:
 * Esta clase representa barcos en el juego de hundir la flota.
 *
 *
 */

public abstract class Ship extends Craft {
	/**
	 * CONSTRUCTOR DE SHIP
	 * @param o Orientacion del barco.
	 * @param s Simbolo del barco
	 * @param n Nombre del barco
	 */
	public Ship(Orientation o,char s, String n) {
		super(o,s,n);
		
	}
}
