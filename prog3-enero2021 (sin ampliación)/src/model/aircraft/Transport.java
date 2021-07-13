package model.aircraft;

import model.Orientation;
/**
 * CLASE TRANSPORT: REPRESENTA LAS PIEZAS TRANSPORT
 * @author Angel Leon Cerdan
 *
 */

public class Transport extends Aircraft{
	/**
	 * CONSTRUCTOR DE TRANSPORT
	 * @param o Orientacion deseada
	 */

	public Transport(Orientation o) {
		super(o, '⇋', "Transport");
		shape = new int[][] {
		      { 0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 1, 1, 1, 0,	
		    	1, 0, 1, 0, 1,
		    	0, 0, 1, 0, 0},
		      { 0, 1, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	1, 1, 1, 1, 1,	
		    	0, 0, 1, 0, 0,
		    	0, 1, 0, 0, 0},
		      { 0, 0, 1, 0, 0,
		    	1, 0, 1, 0, 1,	
		    	0, 1, 1, 1, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 1, 0,
		    	0, 0, 1, 0, 0,	
		    	1, 1, 1, 1, 1,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 0, 1, 0}};
	}
	/**
	 * OBTIENE EL VALOR DE LA PIEZA
	 * @return El valor deseado
	 */
	public int getValue() {
		return 18;
	}

}
