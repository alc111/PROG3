package model.score;

import model.io.IPlayer;
/**
 * CLASE SCORE
 * @author fnaf1234etc
 *
 * @param <T> Tipo generico
 */
public abstract class Score<T> implements Comparable<Score<T>> {
	/**
	 * score
	 */
	protected int score;
	/**
	 * jugador
	 */
	private IPlayer player;
	/**
	 * CONSTRUCTOR DE SCORE
	 * @param player El jugador a añadir
	 */
	public Score(IPlayer player) {
		if(player!=null) {
			this.player=player;
			score=0;		
		}else {
			throw new NullPointerException();
		}		
	}
	/**
	 * GETTER DE SCORE
	 * @return score El score deseado
	 */
	public int getScore() {
		return score;
	}
	/**
	 * COMPARADOR
	 * @param other Un score a comparar con this
	 * @return numero Positivo si this mayor, negativo si this menor
	 */
	public int compareTo(Score<T> other) {
		int numero;
		if(this.getScore()>other.getScore()){
			numero=-1;				
		}else if(this.getScore()<other.getScore()){
			numero=1;		
		}else {
			numero=this.player.getName().compareTo(other.player.getName());	
		}
		return numero;
	}
	/**
	 * IMPRIME EL SCORE
	 * @return El estado del score
	 */
	public String toString() {
		return player.getName()+": "+score;
	}
	/**
	 * AUMENTA EL SCORE
	 * @param sc Parametro de tipo generico
	 */
	public abstract void score(T sc);

}
