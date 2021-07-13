package model.exceptions;

import model.Coordinate;
/**
 * CLASE CoordinateAlreadyHitException: ERROR COORDENADA GOLPEADA
 * @author Angel Leon Cerdan
 *
 */

public class CoordinateAlreadyHitException extends CoordinateException{
	/**
	 * VERSION
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * CONSTRUCTOR CLASE COORDINAEALREADYHITEXCEPTION
	 * @param c Coordenada a analizar.
	 */
	public CoordinateAlreadyHitException(Coordinate c) {
		super(c);
	}
	/**
	 * IMPRIME EL MENSAJE DE ERROR
	 * @return El mensaje
	 */
	public String getMessage() {
		String mensaje="Coordenada ya golpeada.";
		mensaje=super.getMessage()+mensaje;
		return mensaje;
	}

}
