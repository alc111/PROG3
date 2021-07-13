package model.exceptions;

import model.Coordinate;
/**
 * ESTA CLASE REPRESENTA UN ERROR EN LAS COORDENADAS
 * @author Angel Leon Cerdan
 *
 */

public abstract class CoordinateException extends BattleshipException{
	/**
	 * VERSION
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * UNA COORDENADA
	 */
	private Coordinate c;
	/**
	 * CONSTRUCTOR CLASE BATTLESHIPEXCEPTION
	 * @param c Coordenada a analizar
	 */
	public CoordinateException(Coordinate c) {
		this.c=c;
	}
	/**
	 * IMPRIME EL MENSAJE DE ERROR
	 * @return El mensaje
	 */
	public String getMessage() {
		StringBuilder mensaje=new StringBuilder();
		mensaje.append("Error en coordenada ");
		mensaje.append(c.toString());
		mensaje.append(":");		
		return mensaje.toString();
	}
	

}
