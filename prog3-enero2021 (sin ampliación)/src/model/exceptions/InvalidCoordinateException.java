package model.exceptions;

import model.Coordinate;
/**
 * CLASE INVALIDCOORDINATEEXCEPTION: COORDENADA FUERA DEL TABLERO
 * @author Angel Leon Cerdadn
 *
 */

public class InvalidCoordinateException extends CoordinateException{
	/**
	 * VERSION
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * CONSTRUCTOR DE INVALIDCOORDINATEEXCEPTION
	 * @param c Coordenada a analizar
	 */
	public InvalidCoordinateException(Coordinate c) {
		super(c);
	}
	/**
	 * IMPRIME EL MENSAJE DE ERROR
	 * @return El mensaje a imprimir
	 */
	public String getMessage() {
		String mensaje="Coordenada introducida inválida.";
		mensaje=super.getMessage()+mensaje;
		return mensaje;
	}

}
