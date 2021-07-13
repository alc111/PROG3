package model.exceptions;

import model.Coordinate;
/**
 * CLASE NEXTTOANOTHERCRAFTEXCEPTION: ERROR BARCO EN POSICIONES VECINAS
 * @author Angel Leon Cerdan
 *
 */

public class NextToAnotherCraftException extends CoordinateException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * CONSTRUCTOR CLASE NEXTTOANOTHERCRAFTEXCEPTION
	 * @param c Coordenada a analizar
	 */
	public NextToAnotherCraftException(Coordinate c) {
		super(c);
	}
	/**
	 * IMPRIME EL MENSAJE DE ERROR
	 * @return Mensaje a imprimir
	 */
	public String getMessage() {
		String mensaje="Hay un barco en coordenadas vecinas.";
		mensaje=super.getMessage()+mensaje;
		return mensaje;
	}
}
