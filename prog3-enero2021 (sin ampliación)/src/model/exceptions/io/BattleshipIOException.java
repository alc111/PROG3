package model.exceptions.io;

import model.exceptions.BattleshipException;
/**
 * ESTA CLASE REPRESENTA UN ERROR DE ENTRADA/SALIDA EN EL JUEGO
 * @author Angel Leon Cerdan
 *
 */

public class BattleshipIOException extends BattleshipException{
	/**
	 * message: Mensaje origen del error
	 */
	private String message;
	/**
	 * VERSION
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * CONSTRUCTOR DE BATTLESHIPIOEXCEPTION
	 * @param m El mensaje de error
	 */
	
	public BattleshipIOException(String m) {
		this.message=m;
	}
	/**
	 * DEVUELVE EL MENSAJE DE ERROR
	 * @return message El mensaje de error
	 */
	public String getMessage() {
		return message;
	}

}
