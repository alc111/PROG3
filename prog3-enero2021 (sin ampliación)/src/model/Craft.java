package model;

import java.util.HashSet;

import java.util.Set;

import model.exceptions.CoordinateAlreadyHitException;
/**
 * CLASE CRAFT: REPRESENTA TODAS LAS PIEZAS POSIBLES EN EL JUEGO DE HUNDIR LA FLOTA
 * @author Angel Leon Cerdan
 *
 */

public abstract class Craft {

	/**
	 * ATRIBUTOS:
	 * -BOUNDING_SQUARE_SIZE: Tamaño del estado interno del barco.
	 */
	public static int BOUNDING_SQUARE_SIZE = 5;
	/**
	* -HIT_VALUE: Valor que se le da a una coordenada que contiene un barco golpeado.
	*/
	private static int HIT_VALUE = -1;
	/**
	 * -CRAFT_VALUE: Valor que se le da a una coordenada ocupada por un barco.
	 */
	private static int CRAFT_VALUE = 1;
	/**
	 * -symbol: Simbolo del barco.
	 */
	protected char symbol;
	/**
	 * -name: Nombre del barco.
	 */
	protected String name;
	/**
	 * -shape: Matriz que represeta el estado interno del barco.
	 */
	protected int[][] shape;
	/**
	 * -orientation: Orientacion del barco.
	 */
	protected Orientation orientation;
	/**
	 * -position: Posicion relativa del barco.
	 */
	private Coordinate position = null;
	/**
	 * CONSTRUCTOR CLASE CRAFT
	 * @param o Orientacion
	 * @param s Simbolo de la pieza
	 * @param n Nombre pieza
	 */
	public Craft(Orientation o,char s, String n) {
		this.orientation=o;
		this.symbol=s;
		this.name=n;
	}

	/**
	 * DEVUELVE LA POSICION RELATIVA DEL BARCO
	 * @return La coordenada relativa del barco.
	 */
	public Coordinate getPosition() {
		if(position!=null) {
			return this.position.copy();
		}else {
			return position;
		}
		
	}

	/**
	 * FIJA LA POSICION RELATIVA DEL BARCO
	 * @param position La posicion a fijar.
	 */
	public void setPosition(Coordinate position) {
		this.position = position.copy();
	}

	/**
	 * DEVUELVE EL NOMBRE DEL BARCO
	 * @return El nombre buscado.
	 */
	public String getName() {
		return this.name;
		
	}

	/**
	 * DEVUELVE LA ORIENTACION DEL BARCO
	 * @return La orientacion
	 */
	public Orientation getOrientation() {
		return this.orientation;
	}

	/**
	 * DEVUELVE EL SIMBOLO DEL BARCO
	 * @return El simbolo
	 */
	public char getSymbol() {
		return this.symbol;
	}

	/**
	 * DEVUELVE EL ESTADO INTERNO DEL BARCO EN FORMA DE MATRIZ
	 * @return La matriz que representa el estado del barco.
	 */
	public int[][] getShape() {
		return this.shape;
	}

	/**
	 * DEVUELVE UNA POSICION DE LA MATRIZ A PARTIR DE UNA COORDENADA(TRANSFORMA LA COORDENADA EN UN INDICE PARA SHAPE)
	 * @param c La coordenada necesaria para obtener el indice.
	 * @return El indice de shape.
	 */
	public int getShapeIndex(Coordinate c) {
		int index;
		if(c!=null) {
			index = c.get(1)*Craft.BOUNDING_SQUARE_SIZE+c.get(0);
		}else {
			throw new java.lang.NullPointerException("La coordenada pasada apunta a null");
		}
		
		return index;
		
	}

	/**
	 * DEVUELVE LAS POSICIONES REALES(EN BASE AL TABLERO) DEL BARCO
	 * @param c La posicion relativa del barco.
	 * @return Las posiciones reales del barco.
	 */
	public Set<Coordinate> getAbsolutePositions(Coordinate c) {
		Set<Coordinate> absPos = new HashSet<Coordinate>();
		if(c!=null) {
			for(int i=0;i<Craft.BOUNDING_SQUARE_SIZE;i++) {
				for(int j=0;j<Craft.BOUNDING_SQUARE_SIZE;j++) {
					Coordinate c2 = CoordinateFactory.createCoordinate(j,i);
					if(shape[orientation.ordinal()][getShapeIndex(c2)]==Craft.CRAFT_VALUE || shape[orientation.ordinal()][getShapeIndex(c2)]==Craft.HIT_VALUE) {
						absPos.add(c.add(c2));
					}
				}		
			}	
		}else {
			throw new java.lang.NullPointerException("La coordenada recibida apunta a null");
		}
		return absPos;
	}

	/**
	 * MISMA FUNCION QUE LA ANTERIOR
	 * @return Same
	 */
	public Set<Coordinate> getAbsolutePositions() {
		Set<Coordinate> absPos = new HashSet<Coordinate>();
		absPos=this.getAbsolutePositions(this.position);
		return absPos;
		
	}

	/**
	 * SIMULA UN DISPARO A UNA COORDENADA DETERMINADA
	 * @param c Coordenada a la que se dispara.
	 * @return Confirma si se ha alcanzado un barco(true) o no(false).
	 * @throws CoordinateAlreadyHitException 
	 */
	public boolean hit(Coordinate c) throws CoordinateAlreadyHitException{
		boolean hit = false;
		boolean acierto = false;
		if(c!=null) {
			if(this.position!=null) {
				int posVector=getShapeIndex(c.subtract(this.getPosition()));
				Set<Coordinate> localizacion = this.getAbsolutePositions();
				for(Coordinate coordenada : localizacion ) {
					if(coordenada.equals(c)) {
						acierto = true;
					}
				}
				if(acierto==true && shape[orientation.ordinal()][posVector]==CRAFT_VALUE) {
					shape[orientation.ordinal()][posVector] = HIT_VALUE;
					hit = true;
				}else if(acierto==true && shape[orientation.ordinal()][posVector]==HIT_VALUE) {
					throw new CoordinateAlreadyHitException(c);
				}
				
			}else {
				throw new NullPointerException("La posicion del barco apunta a nulo.");
			}
			
		}else {
			throw new NullPointerException("La coordenada apunta a nulo.");
		}
		
		
		return hit;
	}

	/**
	 * INDICA SI UN BARCO HA SIDO HUNDIDO
	 * @return Down True si el barco ha sido hundido y false si no.
	 */
	public boolean isShotDown() {
		boolean Down = false;
		int contador=0;
		if(this.position!=null) {
			Set<Coordinate> posAbs = this.getAbsolutePositions();
			for(Coordinate c: posAbs) {
				if(shape[orientation.ordinal()][getShapeIndex(c.subtract(this.getPosition()))]== HIT_VALUE) {
					contador++;
				}
			}
			if(contador==posAbs.size()) {
				Down=true;
			}
		}
		return Down;
	}

	/**
	 * INDICA SI UNA COORDENADA PERTENECE A UN BARCO ALCANZADO POR UN MISIL
	 * @param c La coordenada absoluta.
	 * @return hit Un booleano que confirma si la coordenada pertenece a un barco golpeado(true) o no(false).
	 */
	public boolean isHit(Coordinate c) {
		boolean hit=false;
		if(position!=null) {
			if(shape[orientation.ordinal()][getShapeIndex(c.subtract(this.getPosition()))]==HIT_VALUE) {
				hit=true;
			}
		}else {
			throw new NullPointerException("La coordenada pasada como parámetro apunta a null.");
		}
		return hit;
	}

	/**
	 * IMPRIME EL ESTADO INTERNO DEL BARCO
	 * @return barco Devuelve el string esperado.
	 */
	public String toString() {
		int espacioTotal=BOUNDING_SQUARE_SIZE+2;
		StringBuilder barco = new StringBuilder();
		barco.append(this.name+" ("+this.orientation+")"+"\n");
		for(int i=0;i<espacioTotal;i++) {
			if(i==0) {
				barco.append(" ");
			}else if(i==espacioTotal-1){
				barco.append("\n");
			}else {
				barco.append("-");
			}
		}
		for(int i=0;i<BOUNDING_SQUARE_SIZE;i++) {
			for(int j=0;j<espacioTotal;j++) {
				Coordinate c = CoordinateFactory.createCoordinate(j-1,i);
				if(j==0) {
					barco.append("|");
				}else if(j==espacioTotal-1){
					barco.append("|"+"\n");
				}else {
					if(shape[orientation.ordinal()][getShapeIndex(c)]==0) {
						barco.append(Board.WATER_SYMBOL);
					}else if(shape[orientation.ordinal()][getShapeIndex(c)]==CRAFT_VALUE) {
						barco.append(symbol);
						
					}else {
						barco.append(Board.HIT_SYMBOL);
					}
				}
			}
		}
		for(int i=0;i<espacioTotal;i++) {
			if(i==0 || i==espacioTotal-1) {
				if(i==0) {
					barco.append(" ");
				}
			}else{
				barco.append("-");
			}
		}
		return barco.toString();	
	}
	/**
	 * OBTIENE EL VALOR DE LA PIEZA
	 * @return El valor buscado
	 */
	public abstract int getValue();
}