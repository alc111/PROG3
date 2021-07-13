package model.aircraft;

import model.Orientation;
/**
 * CLASE BOMBER: REPRESENTA LAS PIEZAS DE TIPO BOMBER
 * @author Angel Leon Cerdan
 *
 */

public class Bomber extends Aircraft{
	/**
	 * CONSTRUCTOR CLASE BOMBER
	 * @param o Orientacion deseada
	 */

	public Bomber(Orientation o) {
		super(o, '⇶', "Bomber");
		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	1, 1, 1, 1, 1,	
		    	1, 0, 1, 0, 1,
		    	0, 0, 1, 0, 0},
		      { 0, 1, 1, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	1, 1, 1, 1, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 1, 1, 0, 0},
		      { 0, 0, 1, 0, 0,
		    	1, 0, 1, 0, 1,	
		    	1, 1, 1, 1, 1,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 1, 1, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 1, 1, 1, 1,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 1, 0}}; 
	}
	/**
	 * OBTIENE EL VALOR DE LA PIEZA
	 * @return El valor deseado
	 */
	public int getValue() {
		return 15;
	}

}
