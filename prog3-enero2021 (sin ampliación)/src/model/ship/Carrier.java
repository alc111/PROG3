package model.ship;

import model.Orientation;
/**
 * CLASE CARRIER: REPRESENTA LA PIEZA DE TIPO CARRIER
 * @author Angel Leon Cerdan
 *
 */

public class Carrier extends Ship{
	/**
	 * CONSTRUCTOR CLASE CARRIER
	 * @param o Orientacion deseada
	 */

	public Carrier(Orientation o) {
		super(o, '®', "Carrier");
		shape = new int[][] {
		      { 0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
		        0, 0, 0, 0, 0,	
		        1, 1, 1, 1, 1,	
		        0, 0, 0, 0, 0,
		        0, 0, 0, 0, 0},
		      { 0, 0, 1, 0, 0,
		        0, 0, 1, 0, 0,	
		        0, 0, 1, 0, 0,	
		        0, 0, 1, 0, 0,
		        0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
		        0, 0, 0, 0, 0,	
		        1, 1, 1, 1, 1,	
		        0, 0, 0, 0, 0,
		        0, 0, 0, 0, 0}}; 
	}
	/**
	 * OBTIENE EL VALOR DE LA PIEZA
	 * @return El valor deseado
	 */
	public int getValue() {
		return 8;
	}

}
