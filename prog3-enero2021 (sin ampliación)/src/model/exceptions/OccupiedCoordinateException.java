package model.exceptions;

import model.Coordinate;
/**
 * CLASE OCCUPIEDCOORDINATEEXCEPTION: ERROR COORDENADA OCUPADA
 * @author Angel Leon Cerdan
 *
 */

public class OccupiedCoordinateException extends CoordinateException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * CONSTRUCTOR CLASE OCCUPIEDCOORDINATEEXCEPTION
	 * @param c Coordenada a analizar
	 */
	public OccupiedCoordinateException(Coordinate c) {
		super(c);
	}
	/**
	 * IMPRIME MENSAJE DE ERROR
	 * @return El mensaje a imprimir
	 */
	public String getMessage() {
		String mensaje="Coordenada ocupada por otro barco.";
		mensaje=super.getMessage()+mensaje;
		return mensaje;
	}

}
