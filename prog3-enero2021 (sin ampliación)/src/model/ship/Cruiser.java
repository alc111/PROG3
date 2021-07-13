package model.ship;

import model.Orientation;
/**
 * CLASE CRUISER: REPRESENTA LAS PIEZAS DE TIPO CRUISER
 * @author Angel Leon Cerdan
 *
 */

public class Cruiser extends Ship{
	/**
	 * CONSTRUCTOR CLASE CRUISER
	 * @param o Orientacion deseada
	 */

	public Cruiser(Orientation o) {
		super(o, 'Ø',"Cruiser");
		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0,	
		    	0, 1, 1, 1, 0,	
		    	0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0,	
		    	0, 1, 1, 1, 0,	
		    	0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0}};
	}
	/**
	 * OBTIENE EL VALOR DE LA PIEZA
	 * @return El valor deseado
	 */
	public int getValue() {
		return 5;
	}

}
