package model.aircraft;

import model.Orientation;
/**
 * CLASE FIGHTER: REPRESENTA A LA PIEZA FIGHTER
 * @author Angel Leon Cerdan
 *
 */

public class Fighter extends Aircraft{
	/**
	 * CONSTRUCTOR CLASE FIGHTER
	 * @param o Orientacion deseada
	 */

	public Fighter(Orientation o) {
		super(o, '⇄', "Fighter");
		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 1, 1, 1, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	1, 1, 1, 1, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 1, 1, 1, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 1, 1, 1, 1,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 0, 0, 0}}; 
	}
	/**
	 * OBTIENE EL VALOR DE LA PIEZA
	 * @return El valor deseado
	 */
	public int getValue() {
		return 10;
	}

}
