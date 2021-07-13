package model.ship;

import model.Orientation;
/**
 * CLASE BATTLESHIP: REPRESENTA LAS PIEZAS DE TIPO BATTLESHIP
 * @author Angel Leon Cerdan
 *
 */

public class Battleship extends Ship{
	/**
	 * CONSTRUCTOR CLASE BATTLESHIP
	 * @param o La orientacion deseada
	 */

	public Battleship(Orientation o) {
		super(o, 'O', "Battleship");
		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0,	
		    	0, 1, 1, 1, 1,	
		    	0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0,	
		    	0, 1, 1, 1, 1,	
		    	0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0}}; 

	}
	/**
	 * OBTIENE EL VALOR DE LA PIEZA
	 * @return El valor deseado
	 */
	public int getValue() {
		return 6;
	}

}
