package model;

import model.aircraft.Coordinate3D;

import model.ship.Coordinate2D;
/**
 * CLASE COORDINATEFACTORY: ES CAPAZ DE CREAR COORDENADAS DE DISTINTO TIPO
 * @author root
 *
 */

public class CoordinateFactory {
	/**
	 * CREA LA COORDENADA DESEADA
	 * @param coords Recibe las componentes de la coordenada
	 * @return Devuelve la coordenada buscada
	 */
	public static Coordinate createCoordinate(int... coords) {
		Coordinate coord=null;
		if(coords.length<2 || coords.length>3) {
			throw new java.lang.IllegalArgumentException("Número icorrecto de argumentos.");
			
		}else {
			if(coords.length==2) {
				coord= new Coordinate2D(coords[0],coords[1]);
			}else {
				coord= new Coordinate3D(coords[0],coords[1],coords[2]);
				
			}	
		}
		return coord;
	}
	
}
