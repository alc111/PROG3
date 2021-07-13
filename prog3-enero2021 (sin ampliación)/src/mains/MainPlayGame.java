package mains;

import model.Board;
import model.Coordinate;
import model.Game;
import model.aircraft.Board3D;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;
import model.io.IPlayer;
import model.io.IVisualiser;
import model.io.PlayerFactory;
import model.io.PlayerRandom;
import model.io.VisualiserConsole;
import model.io.VisualiserFactory;
import model.io.VisualiserGIF;
import model.ship.Board2D;
import model.ship.Coordinate2D;

/**
 * Aquí hay dos métodos, uno para una partida en 2D con submarinos (main2D())
 * y otro para una partida en 3D con drones (main3D())
 * Se usa la clase Game para jugar la partida.
 * 
 * Puedes ejecutar uno u otro invocándolo desde main()
 *
 */
public class MainPlayGame {

	public static void main(String[] args) {
		 main2D(args);
		//main3D(args);
	}

	public static void main2D(String[] args) {		
		try {
			IPlayer player1 = PlayerFactory.createPlayer("John","test/files/enero/SubmarinePlayer1.in");
			IPlayer player2 = PlayerFactory.createPlayer("Mary","test/files/enero/SubmarinePlayer2.in");
			Board b1 = new Board2D(6);
			Board b2 = new Board2D(6);
			
			Game game = new Game(b1, b2, player1, player2);

			IVisualiser visualiser = VisualiserFactory.createVisualiser("Console", game);
			
			game.playGame(visualiser);
			
			System.out.println("Done");
		} catch (BattleshipIOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main3D(String[] args) {		
		try {
			IPlayer player1 = PlayerFactory.createPlayer("John","test/files/enero/DronPlayer1.in");
			IPlayer player2 = PlayerFactory.createPlayer("Mary","test/files/enero/DronPlayer2.in");
			Board b1 = new Board3D(6);
			Board b2 = new Board3D(6);
			
			Game game = new Game(b1, b2, player1, player2);

			IVisualiser visualiser = VisualiserFactory.createVisualiser("Console", game);
			
			game.playGame(visualiser);
			
			System.out.println("Done");
		} catch (BattleshipIOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
