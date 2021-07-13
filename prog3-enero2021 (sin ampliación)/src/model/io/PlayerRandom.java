package model.io;

import java.util.Random;

import model.Board;
import model.CellStatus;
import model.Coordinate;
import model.CoordinateFactory;
import model.Craft;
import model.CraftFactory;
import model.Orientation;
import model.aircraft.Board3D;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;
import model.ship.Board2D;
/**
 * 
 * @author Angel Leon Cerdan
 * CLASE PLAYERRANDOM: Esta clase representa a un jugador aleatorio
 *
 */
public class PlayerRandom implements IPlayer{
	/**
	 * Seed para crear numeros aleatorios
	 */
	private Random random;
	/**
	 * Nombre del jugador aleatorio
	 */
	private String name;
	/**
	 * Status del ultimo disparo
	 */
	private CellStatus lastShotStatus; 
	/**
	 * CONSTRUCTOR DE PLAYERRANDOM
	 * @param name Nombre del jugador
	 * @param seed Semilla a emplear
	 */
	public PlayerRandom(String name, long seed) {
		this.random=new Random(seed);
		this.name=name;
	}
	/**
	 * ESTE METODO EXPONE EL ESTADO INTERNO DEL JUGADOR
	 * @return El nombre y tipo de jugador
	 */
	public String getName() {
		return name+" "+"(PlayerRandom)";
	}
	/**
	 * ESTE METODO COLOCA LAS PIEZAS DE PLAYERRANDOM EN UN TABLERO
	 * @param b El tablero a utilizar
	 */
	public void putCrafts(Board b){
		int contador=0;
		Orientation orientacion=null;
		Craft pieza=null;
		boolean siono=false;
		if(b!=null) {
			orientacion=Orientation.values()[random.nextInt(4)];
			pieza=CraftFactory.createCraft("ship.Battleship", orientacion);
			do {
				try {
					siono=b.addCraft(pieza, genRandomCoordinate(b,Craft.BOUNDING_SQUARE_SIZE));
				}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
					siono=false;
				}
				contador++;
			}while(contador<100 && siono==false);
			contador=0;
			siono=false;
			orientacion=Orientation.values()[random.nextInt(4)];
			pieza=CraftFactory.createCraft("ship.Carrier", orientacion);
			do {			
				try {
					siono=b.addCraft(pieza, genRandomCoordinate(b,Craft.BOUNDING_SQUARE_SIZE));
				}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
					siono=false;
				}
				contador++;
			}while(contador<100 && siono==false);
			contador=0;
			siono=false;
			orientacion=Orientation.values()[random.nextInt(4)];
			pieza=CraftFactory.createCraft("ship.Cruiser", orientacion);
			do {			
				try {
					siono=b.addCraft(pieza, genRandomCoordinate(b,Craft.BOUNDING_SQUARE_SIZE));
				}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
					siono=false;
				}
				contador++;
			}while(contador<100 && siono==false);
			contador=0;
			siono=false;
			orientacion=Orientation.values()[random.nextInt(4)];
			pieza=CraftFactory.createCraft("ship.Destroyer", orientacion);
			do {				
				try {
					siono=b.addCraft(pieza, genRandomCoordinate(b,Craft.BOUNDING_SQUARE_SIZE));
				}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
					siono=false;
				}
				contador++;
			}while(contador<100 && siono==false);
			contador=0;
			siono=false;
			if(b instanceof Board3D) {
				orientacion=Orientation.values()[random.nextInt(4)];
				pieza=CraftFactory.createCraft("aircraft.Bomber", orientacion);
				do {				
					try {
						siono=b.addCraft(pieza, genRandomCoordinate(b,Craft.BOUNDING_SQUARE_SIZE));
					}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
						siono=false;
					}
					contador++;
				}while(contador<100 && siono==false);
				contador=0;
				siono=false;
				orientacion=Orientation.values()[random.nextInt(4)];
				pieza=CraftFactory.createCraft("aircraft.Fighter", orientacion);
				do {				
					try {
						siono=b.addCraft(pieza, genRandomCoordinate(b,Craft.BOUNDING_SQUARE_SIZE));
					}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
						siono=false;
					}
					contador++;
				}while(contador<100 && siono==false);
				contador=0;
				siono=false;
				orientacion=Orientation.values()[random.nextInt(4)];
				pieza=CraftFactory.createCraft("aircraft.Transport", orientacion);
				do {			
					try {
						siono=b.addCraft(pieza, genRandomCoordinate(b,Craft.BOUNDING_SQUARE_SIZE));
					}catch(InvalidCoordinateException | OccupiedCoordinateException | NextToAnotherCraftException e) {
						siono=false;
					}
					contador++;
				}while(contador<100 && siono==false);			
			}	
		}else {
			throw new NullPointerException("El tablero apunta a null.");
		}
	
	}
	/**
	 * ESTE METODO GENERA UN DISPARO A UN TABLERO
	 * @param b El tablero al que hay que disparar
	 * @return newCoordinate Coordenada a la que se dispara
	 * @throws BattleshipIOException Error entrada salida
	 * @throws InvalidCoordinateException Coordenada invalida
	 * @throws CoordinateAlreadyHitException Coordenada ya golpeada
	 */
	public Coordinate nextShoot(Board b) throws BattleshipIOException, InvalidCoordinateException, CoordinateAlreadyHitException{
		Coordinate newCoordinate=null;
		if(b!=null) {
			newCoordinate=genRandomCoordinate(b,0);
			this.lastShotStatus=b.hit(newCoordinate);			
		}else {
			throw new NullPointerException("El tablero apunta a  null.");
		}
		return newCoordinate;		
	}
	/**
	 * ESTE METODO GENERA UN NUMERO ALEATORIO
	 * @param min Rango 1
	 * @param max Rango 2
	 * @return El numero aleatorio
	 */
	private int genRandomInt(int min, int max) {
		return random.nextInt(max-min)+min;
		
	}
	/**
	 * ESTE METODO GENERA UNA COORDENADA ALEATORIA
	 * @param b Tablero a analizar
	 * @param offset Param a utilizar para generar el num aleatorio
	 * @return c La coordenada deseada
	 */
	private Coordinate genRandomCoordinate(Board b, int offset) {
		Coordinate c=null;
		int x,y,z;
		x=genRandomInt(0-offset, b.getSize());
		y=genRandomInt(0-offset, b.getSize());
		if(b instanceof Board2D) {
			c=CoordinateFactory.createCoordinate(x,y);
		}else {
			z=genRandomInt(0-offset, b.getSize());
			c=CoordinateFactory.createCoordinate(x,y,z);	
		}
		return c;
	}
	/**
	 * GETTER DE LASTSHOTSTATUS
	 * @return lastShotStatus
	 */
	public CellStatus getLastShotStatus() {
		return lastShotStatus;
		
	}
}
