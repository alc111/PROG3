package model.score;

import java.util.SortedSet;

import java.util.TreeSet;

import model.exceptions.score.EmptyRankingException;
/**
 * CLASE RANKING
 * @author fnaf1234etc
 *
 * @param <ScoreType>  El score ha de basarse en status o crafts
 */
public class Ranking <ScoreType extends Score<?>>{
	/**
	 * scoreSet
	 */
	private SortedSet<ScoreType> scoreSet;
	/**
	 * CONSTRUCTOR DE RANKING
	 */
	public Ranking() {
		scoreSet=new TreeSet<>();	
	}
	/**
	 * AÑADIR PUNTUACION AL RANKING
	 * @param st El score a añadir
	 */
	public void addScore(ScoreType st) {
		scoreSet.add(st);	
	}
	/**
	 * GETTER DE SCORESET
	 * @return scoreSet El conjunto de scores
	 */
	public SortedSet<ScoreType> getSortedRanking(){
		return scoreSet;
	}
	/**
	 * DECIDE EL TOP 1 DEL RANKING
	 * @return winner El ganador
	 * @throws EmptyRankingException El ranking esta vacio
	 */
	public ScoreType getWinner() throws EmptyRankingException {
		ScoreType winner=null;
		if(scoreSet.isEmpty()) {
			throw new EmptyRankingException();	
		}else {
			winner=scoreSet.first();		
		}
		return winner;
		
	}

}
