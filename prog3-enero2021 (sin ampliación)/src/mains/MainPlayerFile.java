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
 * Este programa ejecuta las órdenes de ficheros de entrada para un PlayerFile
 * sin utilizar la clase Game
 *
 */
public class MainPlayerFile {

	public static void main(String[] args) {
		IPlayer player1 = null;
		IPlayer player2 = null;
		Board b1 = new Board2D(6);
		Board b2 = new Board2D(6);
		
		try {
			player1 = PlayerFactory.createPlayer("John","test/files/enero/SubmarinePlayer1.in");
			player2 = PlayerFactory.createPlayer("Mary","test/files/enero/SubmarinePlayer2.in");
		} catch (BattleshipIOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			player1.putCrafts(b1);
			player2.putCrafts(b2);
		} catch (InvalidCoordinateException | NextToAnotherCraftException | OccupiedCoordinateException	| BattleshipIOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// We process all shots by player 1 at board 2
		try {
			Coordinate c;
			do {
				c=player1.nextShoot(b2);
				if (c!=null) {
					System.out.println(c);
					System.out.println(b2.show(false));
					System.out.println("--------------------------------");
				}
			} while(c != null);
		} catch (CoordinateAlreadyHitException | InvalidCoordinateException | BattleshipIOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("=============================");
		
		// We process all shots by player 2 at board 1
		try {
			Coordinate c;
			do {
				c=player2.nextShoot(b1);
				if (c!=null) {
					System.out.println(c);
					System.out.println(b1.show(false));
					System.out.println("--------------------------------");
				}
			} while(c != null);
		} catch (CoordinateAlreadyHitException | InvalidCoordinateException | BattleshipIOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("=============================");
		System.out.println(b1.show(true));
		System.out.println("--------------------------------");
		System.out.println(b2.show(true));
	}
		
}
