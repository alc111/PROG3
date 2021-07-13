package model.ship;

import model.Orientation;
/**
 * CLASE DESTROYER: REPRESENTA LAS PIEZAS DE TIPO DESTROYER
 * @author Angel Leon Cerdan
 *
 */

public class Destroyer extends Ship{
	/**
	 * CONSTRUCTOR CLASE DESTROYER
	 * @param o Orientacion deseada
	 */

	public Destroyer(Orientation o) {
		super(o, 'Ω',"Destroyer" );
		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0,	
		    	0, 1, 1, 0, 0,	
		    	0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0,	
		    	0, 1, 1, 0, 0,	
		    	0, 0, 0, 0, 0,
		    	0, 0, 0, 0, 0}};
	}
	/**
	 * OBTIENE EL VALOR DE LA PIEZA
	 * @return El valor deseado
	 */
	public int getValue() {
		return 3;
	}

}
