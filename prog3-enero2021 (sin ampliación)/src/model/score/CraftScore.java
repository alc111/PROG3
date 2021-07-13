package model.score;

import model.Craft;

import model.io.IPlayer;
/**
 * CLASE CRAFTSCORE
 * @author fnaf1234etc
 */
public class CraftScore extends Score<Craft>{
	/**
	 * CONSTRUCTOR CRAFTSCORE
	 * @param player El jugador a añadir
	 */
	public CraftScore(IPlayer player) {
		super(player);
	}
	/**
	 * AUMENTA EL SCORE INTERNO
	 * @param sc El craft destruido
	 */
	public void score(Craft sc) {
		this.score=this.score+sc.getValue();	
	}

}
