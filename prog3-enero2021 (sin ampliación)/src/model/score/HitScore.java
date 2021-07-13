package model.score;

import model.CellStatus;

import model.io.IPlayer;
/**
 * CLASE HITSCORE
 * @author fnaf1234etc
 */
public class HitScore extends Score<CellStatus>{
	/**
	 * CONSTRUCTOR DE HITSCORE
	 * @param player El jugador a añadir
	 */
	public HitScore(IPlayer player) {
		super(player);	
	}
	/**
	 * AUMENTA EL SCORE INTERNO
	 * @param sc El status de una celda
	 */
	public void score(CellStatus sc) {
		if(sc==CellStatus.HIT || sc==CellStatus.DESTROYED) {
			this.score++;
		}		
	}
}
