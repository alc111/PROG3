package model.exceptions.score;

import model.exceptions.BattleshipException;
/**
 * CLASE EMPTYRANKINGEXCEPTION
 * @author fnaf1234etc
 *
 */
public class EmptyRankingException extends BattleshipException{

	/**
	 * LA ID
	 */
	private static final long serialVersionUID = 1L;	
	
	/**
	 * OBTIENE EL MENSAJE DE ERROR
	 * @return mensaje El mensaje de error
	 */
	public String getMessage() {
		String mensaje="Ranking vacío";
		return mensaje;
	}
	


}