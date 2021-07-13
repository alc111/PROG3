package model;
/**
 * 
 * @author Angel Leon Cerdan
 * ENUM CELLSTATUS:
 * Este enumerado contiene los posibles estados a la hora de realizar una simulacion de disparo(WATER si se dispara al agua, HIT si golpeas un barco y DESTROYED si se destruye un barco).
 *
 */

public enum CellStatus {
	/**
	 * COMPONENTES:
	 * -WATER: Si el punto golpeado es agua.
	 * -HIT: Si el punto golpeado corresponde a un barco.
	 * -DESTROYED: Si el punto golpeado corresponde a un barco y ademas lo destruye.
	 */
	WATER,HIT,DESTROYED
}
