package model;

import model.exceptions.CoordinateException;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.io.BattleshipIOException;
import model.io.IPlayer;
import model.io.IVisualiser;
import model.score.CraftScore;
import model.score.HitScore;
/**
 * ESTA CLASE REPRESENTA EL JUEGO DE HUNDIR LA FLOTA 
 * @author Angel Leon Cerdan
 *
 */
public class Game {
	/**
	 * Indica si el juego ha empezado
	 */
	private boolean gameStarted;
	/**
	 * Indica quien es el siguiente jugador que dispara
	 */
	private int nextToShoot;
	/**
	 * Cuenta el numero de disparos efectuados
	 */
	private int shootCounter;
	/**
	 * Representa al jugador 1
	 */
	private IPlayer player1;
	/**
	 * Representa al jugador2
	 */
	private IPlayer player2;
	/**
	 * Representa el tablero del jugador 1
	 */
	private Board board1;
	/**
	 * Representa el tablero del jugador 2
	 */
	private Board board2;
	/**
	 * Primer score CellStatus
	 */
	private HitScore hitScore1;
	/**
	 * Segundo score CellStatus
	 */
	private HitScore hitScore2;
	/**
	 * Primer score Crafts
	 */
	private CraftScore craftScore1;
	/**
	 * Segundo score Crafts
	 */
	private CraftScore craftScore2;
	
	/**
	 * CONSTRUCTOR DE GAME
	 * @param b1 El tablero 1
	 * @param b2 El tablero 2
	 * @param p1 El jugador 1
	 * @param p2 El jugador 2
	 */
	
	public Game(Board b1,Board b2, IPlayer p1, IPlayer p2) {
		if(b1!=null && b2!=null && p1!=null && p2!=null) {
			this.board1=b1;
			this.board2=b2;
			this.player1=p1;
			this.player2=p2;			
			this.hitScore1= new HitScore(p1);
			this.hitScore2= new HitScore(p2);
			this.craftScore1= new CraftScore(p1);
			this.craftScore2=new CraftScore(p2);
			gameStarted=false;
		}else {
			throw new NullPointerException("Alguno de los parámetros apunta a null");
		}
		
	}
	/**
	 * DEVUELVE AL JUGADOR1
	 * @return El jugador 1
	 */
	public IPlayer getPlayer1() {
		return this.player1;
		
	}
	/**
	 * DEVUELVE AL JUGADOR2
	 * @return El jugador 2
	 */
	public IPlayer getPlayer2() {
		return this.player2;
		
	}
	/**
	 * DEVUELVE AL TABLERO 1
	 * @return El tablero 1
	 */
	public Board getBoard1() {
		return this.board1;
		
	}
	/**
	 * DEVUELVE AL TABLERO 2
	 * @return El tablero 2
	 */
	public Board getBoard2() {
		return this.board2;
		
	}
	/**
	 * DEVUELVE AL ULTIMO JUGADOR QUE DISPARO
	 * @return lastplayer El jugador deseado
	 */
	public IPlayer getPlayerLastShoot() {
		IPlayer lastplayer=null;
		if(gameStarted==true) {
			if(shootCounter>0) {
				if(nextToShoot==1) {
					lastplayer=player2;				
				}else {
					lastplayer=player1;				
				}			
			}			
		}			
		return lastplayer;		
	}
	/**
	 * EMPIEZA EL JUEGO DE HUNDIR LA FLOTA
	 */
	public void start() {
		gameStarted=true;
		shootCounter=0;
		nextToShoot=1;
		try {
			player1.putCrafts(board1);
			player2.putCrafts(board2);	
		} catch (BattleshipIOException | CoordinateException e) {
			throw new RuntimeException();
		}
		
		
	}
	/**
	 * INDICA SI EL JUEGO HA FINALIZADO
	 * @return true si ha finalziado y false en caso contrario
	 */
	public boolean gameEnded() {
		boolean endornot=false;
		if(gameStarted==true && (board1.areAllCraftsDestroyed()==true || board2.areAllCraftsDestroyed()==true)) {
			endornot=true;
		}
		return endornot;		
	}
	/**
	 * EFECTUA UNA JUGADA
	 * @return true si se ha podido realizar el movimiento y false en caso contrario
	 */
	public boolean playNext() {
		Coordinate c=null;
		boolean disparar=false;
		Craft barco=null;
		try {
			if(nextToShoot==1) {
				c=player1.nextShoot(board2);				
				if(c!=null) {
					disparar=true;
					nextToShoot=2;
					shootCounter++;
					hitScore1.score(player1.getLastShotStatus());
					if(player1.getLastShotStatus()==CellStatus.DESTROYED) {
						barco=this.board2.getCraft(c);
						craftScore1.score(barco);					
					}
				}
			}else {
				c=player2.nextShoot(board1);
				if(c!=null) {
					disparar=true;
					nextToShoot=1;
					shootCounter++;
					hitScore2.score(player2.getLastShotStatus());
					if(player2.getLastShotStatus()==CellStatus.DESTROYED) {
						barco=this.board1.getCraft(c);
						craftScore2.score(barco);				
					}
				}		
			}
		}catch(BattleshipIOException e) {
			throw new RuntimeException();
			
		}catch(InvalidCoordinateException e) {
			throw new RuntimeException();
		}catch(CoordinateAlreadyHitException e) {
			if(nextToShoot==1) {
				System.out.println("Action by "+player1.getName()+" "+e.getMessage());
				disparar=true;
				nextToShoot=2;
				shootCounter++;				
			}else {
				System.out.println("Action by "+player2.getName()+" "+e.getMessage());	
				disparar=true;
				nextToShoot=1;
				shootCounter++;
			}			
		}
		return disparar;
		
	}
	/**
	 * SE JUEGA A HUNDIR LA FLOTA Y SE MUESTRA LA EVOLUCION DE CADA TABLERO
	 * @param visualiser El visor a emplear para observar el estado del juego
	 */
	public void playGame(IVisualiser visualiser) {
		start();
		visualiser.show();
		do {
			if(playNext()==true) {
				visualiser.show();
			}else {
				break;
			}
		}while(this.gameEnded()==false);
		visualiser.close();		
	}
	/**
	 * DEVUELVE UN STRING QUE MUESTRA LA SITUCION ACTUAL DE LA PARTIDA
	 * @return Devuelve la cadena deseada
	 */
	public String toString() {
		StringBuilder juego= new StringBuilder();
		if(gameStarted==false) {
			juego.append("=== GAME NOT STARTED ===");
			
		}else if(this.gameEnded()==true) {
			juego.append("=== GAME ENDED ===");
			
		}else {
			juego.append("=== ONGOING GAME ===");
			
		}
		juego.append("\n");
		juego.append("=================================="+"\n");
		juego.append(player1.getName()+"\n");
		juego.append("=================================="+"\n");
		juego.append(board1.show(false)+"\n");
		juego.append("=================================="+"\n");
		juego.append(player2.getName()+"\n");
		juego.append("=================================="+"\n");
		juego.append(board2.show(false)+"\n");
		juego.append("=================================="+"\n");
		juego.append("Number of shots: "+Integer.toString(shootCounter));
		if(this.gameEnded()==true) {
			if(board1.areAllCraftsDestroyed()==true) {	
				juego.append("\n");
				juego.append(player2.getName()+" wins");			
			}else if(board2.areAllCraftsDestroyed()==true){
				juego.append("\n");
				juego.append(player1.getName()+" wins");				
			}
		}				
		return juego.toString();
		
	}
	/**
	 * GETTER HITSCORE1
	 * @return hitScore1 Cellstatus
	 */
	public HitScore getHitScorePlayer1() {
		return hitScore1;
	}
	/**
	 * GETTER HITSCORE2
	 * @return hitScore2 CellStatus
	 */
	public HitScore getHitScorePlayer2() {
		return hitScore2;
	}
	/**
	 * GETTER CRAFTSCORE1
	 * @return craftScore1 Crafts
	 */
	public CraftScore getCraftScorePlayer1() {
		return craftScore1;
	}
	/**
	 * GETTER CRAFTSCORE2
	 * @return craftScore2 Crafts
	 */
	public CraftScore getCraftScorePlayer2() {
		return craftScore2;
	}
	/**
	 * IMPRIMER LA INFORMACION REFERENTE A LOS SCORES
	 * @return puntuacion La informacion deseada
	 */
	public String getScoreInfo() {
		StringBuilder puntuacion=new StringBuilder();
		puntuacion.append("Player1"+"\n");
		puntuacion.append("HitScore: "+hitScore1.toString()+"\n");
		puntuacion.append("CraftScore: "+craftScore1.toString()+"\n");
		puntuacion.append("--------------"+"\n");
		puntuacion.append("Player2"+"\n");
		puntuacion.append("HitScore: "+hitScore2.toString()+"\n");
		puntuacion.append("CraftScore: "+craftScore2.toString());
		return puntuacion.toString();
	}
}
