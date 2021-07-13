package model.aircraft;

import model.Craft;
import model.Orientation;
/**
 * CLASE AIRCRAFT: REPRESENTA LOS AVIONES EN EL JUEGO DE HUNDIR LA FLOTA
 * @author Angel Leon Cerdan
 *
 */

public abstract class Aircraft extends Craft{
	/**
	 * CONSTRUCTOR CLASE AIRCRAFT
	 * @param o Orientacion
	 * @param s Simbolo avion
	 * @param n Nombre avion
	 */

	public Aircraft(Orientation o, char s, String n) {
		super(o, s, n);
	}
}
