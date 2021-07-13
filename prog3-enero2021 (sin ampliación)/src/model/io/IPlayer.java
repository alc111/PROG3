package model.io;

import model.Board;
import model.CellStatus;
import model.Coordinate;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;
/**
 * INTERFAZ DE JUGADOR
 * @author Angel Leon Cerdan
 *
 */
public interface IPlayer {
	/**
	 * ESTE METODO MUESTRA EL NOMBRE DEL JUGADOR
	 * @return El nombre y el tipo de jugador
	 */
	public String getName();
	/**
	 * ESTE METODO COLOCA LOS BARCOS DEL JUGADOR EN EL TABLERO
	 * @param b El tablero en el que hay que colocar piezas
	 * @throws BattleshipIOException Error entrada salida
	 * @throws OccupiedCoordinateException Coordenada ocupada
	 * @throws InvalidCoordinateException Coordenada invalida
	 * @throws NextToAnotherCraftException Coordenada al lado de otra estructura
	 */
	public void putCrafts(Board b) throws BattleshipIOException, OccupiedCoordinateException, InvalidCoordinateException, NextToAnotherCraftException;
	/**
	 * ESTE METODO GENERA UN DISPARO A UN TABLERO DETERMINADO
	 * @param b El tablero al que hay que disparar
	 * @return La coordenada golpeada
	 * @throws BattleshipIOException Error entrada salida
	 * @throws InvalidCoordinateException Coordenada invalida
	 * @throws CoordinateAlreadyHitException Coordenada ya golpeada
	 */
	public Coordinate nextShoot(Board b) throws BattleshipIOException, InvalidCoordinateException, CoordinateAlreadyHitException;
	/**
	 * GETTER DE LASTSHOTSTATUS
	 * @return lastShotStatus
	 */
	public CellStatus getLastShotStatus();

}
