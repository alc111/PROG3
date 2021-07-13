package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
/**
 * CLASE BOARD: REPRESENTA EL TABLERO EN EL JUEGO DE HUNDIR LA FLOTA
 * @author Angel Leon Cerdan
 *
 */

public abstract class Board {

	/**
	 * ATRIBUTOS:
	 * -HIT_SYMBOL: Simbolo de una posicion golpeada.
	 */
	public static char HIT_SYMBOL = '•';
	/**
	 * -WATER_SYMBOL: Simbolo de una posicion donde hay agua.
	 */
	public static char WATER_SYMBOL = ' ';
	/**
	 * -NOTSEEN_SYMBOL: Simbolo correspondiente a las posiciones no reveladas.
	 */
	public static char NOTSEEN_SYMBOL = '?';
	/**
	 * -MAX_BOARD_SIZE: Tamaño maximo del tablero.
	 */
	public static int MAX_BOARD_SIZE = 20;
	/**
	 * -MIN_BOARD_SIZE: Tamaño minimo del tablero.
	 */
	public static int MIN_BOARD_SIZE = 5;
	/**
	 * -size: Tamaño del tablero.
	 */
	private int size;
	/**
	 * -numCrafts: Numero de barcos que hay en el tablero.
	 */
	private int numCrafts = 0;
	/**
	 * -destroyedCrafts: Numero de barcos destruidos del tablero.
	 */
	private int destroyedCrafts = 0;
	/**
	 * -seen: Coordenadas reveladas por el adversario.
	 */
	private Set<Coordinate> seen = null;
	/**
	 * -board: Map que relaciona una posicion(key) con un barco(value).
	 */
	private Map<Coordinate, Craft> board = null;
	/**
	 * -BOARD_SEPARATOR: Separador.
	 */
	public static char BOARD_SEPARATOR='|';
	/**
	 * CONSTRUCTOR CLASE BOARD
	 * @param size Tamaño del tablero
	 */
	public Board(int size) {
		if(size<MIN_BOARD_SIZE || size>MAX_BOARD_SIZE) {
			this.size=MIN_BOARD_SIZE;
			throw new IllegalArgumentException("El tamaño pasado está fuera del rango permitido.");
		}else {
			this.size=size;
		}
		board= new HashMap<Coordinate, Craft>();
		seen= new HashSet<Coordinate>();	
	}

	/**
	 * DEVUELVE EL TAMAÑO DEL TABLERO
	 * @return El tamaño.
	 */
	public int getSize() {
		return size;
		
	}

	/**
	 * AÑADE UN BARCO AL TABLERO
	 * @param craft El barco a añadir.
	 * @param position La posicion relativa de dicho barco.
	 * @return True si la operacion se ha completado y false si no.
	 * @throws OccupiedCoordinateException 
	 * @throws InvalidCoordinateException 
	 * @throws NextToAnotherCraftException 
	 */
	public boolean addCraft(Craft craft, Coordinate position) throws OccupiedCoordinateException, InvalidCoordinateException, NextToAnotherCraftException {
		boolean hayError=false;
		boolean incluir=true;
		boolean opCompletada=false;
		boolean errFuera=false;
		boolean errOcupada=false;
		boolean errVecina=false;
		Set<Coordinate> CoordBarco=craft.getAbsolutePositions(position);
		Set<Coordinate> vecinos=this.getNeighborhood(craft,position);
		for(Coordinate c:CoordBarco) {
			if(this.checkCoordinate(c)==false) {
				incluir=false;
				errFuera=true;
			}
		}
		if(errFuera==true) {
			hayError=true;
			throw new InvalidCoordinateException(position);
			
		}
		if(hayError==false) {
			for(Coordinate c2:CoordBarco) {
				if(board.containsKey(c2)==true) {
					incluir=false;
					errOcupada=true;
				}
			}
			if(errOcupada==true) {
				hayError=true;
				throw new OccupiedCoordinateException(position);
				
			}
		}
		if(hayError==false) {
			for(Coordinate c3:vecinos) {
				if(board.containsKey(c3)){
					incluir=false;
					errVecina=true;
				}
			
			}
			if(errVecina==true) {
				throw new NextToAnotherCraftException(position);
			}
		}
		if(incluir==true) {
			for(Coordinate c4:CoordBarco) {
				board.put(c4, craft);
			}
			craft.setPosition(position);
			numCrafts++;
			opCompletada=true;
		}
		return opCompletada;
	}

	/**
	 * DEVUELVE EL BARCO ASOCIADO A UNA POSICION DETERMINADA
	 * @param c La coordenada en la que se posiciona el barco.
	 * @return El barco.
	 */
	public Craft getCraft(Coordinate c) {
		Craft barco=null;
		if(board.containsKey(c)){
			barco=board.get(c);
		}
		return barco;
	}

	/**
	 * INDICA SI UNA COORDENADA SE ENCUENTRA EN EL VECTOR DE POSICIONES REVELADAS POR EL ADVERSARIO
	 * @param c La coordenada a analizar
	 * @return True si se encuentra en el vector y false en caso contrario.
	 */
	public boolean isSeen(Coordinate c) {
		boolean isSeen=false;
		for(Coordinate c2:seen) {
			if(c2.equals(c)) {
				isSeen=true;
			}
		}
		return isSeen;
		
	}

	/**
	 * SIMULA EL DISPARO DE UN MISIL A UNA COORDENADA DETERMINADA
	 * @param c La posicion a la que se busca disparar.
	 * @return estado El estado de la posicion a la que se dispara.
	 * @throws InvalidCoordinateException 
	 * @throws CoordinateAlreadyHitException 
	 */
	public CellStatus hit(Coordinate c) throws InvalidCoordinateException, CoordinateAlreadyHitException {
		CellStatus estado=null;
		boolean DentroTablero=true;
		if(this.checkCoordinate(c)==false) {
			estado=CellStatus.WATER;
			DentroTablero=false;
			throw new InvalidCoordinateException(c);
		}else {
			if(board.containsKey(c)==false) {
				estado=CellStatus.WATER;
			}else {
				board.get(c).hit(c);
				if(board.get(c).isShotDown()==true) {
					estado=CellStatus.DESTROYED;	
					destroyedCrafts++;
					for(Coordinate c2:this.getNeighborhood(board.get(c))) {
						seen.add(c2.copy());
					}					
				}else {
					estado=CellStatus.HIT;
					seen.add(c.copy());
				}
			}
			if(DentroTablero==true) {
				seen.add(c.copy());
			}	
			
		}
		
		return estado;
	}

	/**
	 * INDICA SI TODOS LOS BARCOS HAN SIDO DESTRUIDOS
	 * @return True si han sido destruidos y false en caso contrario.
	 */
	public boolean areAllCraftsDestroyed() {
		boolean destruidos=false;
		if(numCrafts==destroyedCrafts) {
			destruidos=true;
		}
		return destruidos;
	}

	/**
	 * OBTIENE LAS COORDENADAS VECINAS DE UN BARCO DETERMINADO
	 * @param ship El barco del que se quieren extraer las coordenadas vecinas.
	 * @param position La posicion relativa del barco.
	 * @return Un vector con las coordenadas vecinas.
	 */
	public Set<Coordinate> getNeighborhood(Craft ship, Coordinate position) {
		Set<Coordinate> vecinos=new HashSet<Coordinate>();
		if(ship!=null && position!=null) {
			Set<Coordinate> coordBarco=ship.getAbsolutePositions(position);
			Set<Coordinate> adjCoord=new HashSet<Coordinate>();
			boolean esbarco=false;
			for(Coordinate c:coordBarco) {
				adjCoord=c.adjacentCoordinates();
				for(Coordinate c2:adjCoord) {
					for(Coordinate c3:coordBarco) {
						if(c3.equals(c2)==true) {
							esbarco=true;
						}
					}
					if(esbarco==false && this.checkCoordinate(c2)==true) {
						vecinos.add(c2);
					}
					esbarco=false;
				}	
			}
			
		}else {
			throw new NullPointerException("Alguno de los parámetros pasados apunta a NULL.");
		}
		
		return vecinos;
		
	}
	/**
	 * MISMA FUNCION QUE EL ANTERIOR METODO
	 * @param ship Same
	 * @return Same
	 */
	public Set<Coordinate> getNeighborhood(Craft ship) {
		Set<Coordinate> vecinos= new HashSet<Coordinate>();
		if(ship.getPosition()!=null) {
			vecinos=this.getNeighborhood(ship, ship.getPosition());
		}else {
			throw new NullPointerException("La posición del barco apunta a null.");
		}
		return vecinos;
	}
	/**
	 * COMPRUEBA QUE UNA COORDENADA ESTA DENTRO DEL TABLERO
	 * @param c Coordenada a analizar
	 * @return Si está dentro o fuera
	 */
	abstract public boolean checkCoordinate(Coordinate c);
	/**
	 * MUESTRA LA SITUACIÓN ACTUAL DEL TABLERO
	 * @param unveil Indica si deseas visualizar el tablero de una forma u otra
	 * @return El tablero
	 */
	public abstract String show(boolean unveil);

	/**
	 * IMPRIME EL CONTENIDO MAS DESTACABLE DEL TABLERO
	 * @return info Devuelve el string esperado.
	 */
	public String toString() {
		StringBuilder info= new StringBuilder();
		info.append("Board "+this.size+"; "+"crafts: "+this.numCrafts+"; "+"destroyed: "+this.destroyedCrafts);
		return info.toString();
	}

}