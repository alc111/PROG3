package model.ship;

import java.util.HashSet;

import java.util.Set;

import model.Coordinate;
import model.CoordinateFactory;
/**
 * 
 * @author Angel Leon Cerdan
 * CLASE COORDINATE2D: Representa las coordenadas que poseen 2 dimensiones.
 *
 */

public class Coordinate2D extends Coordinate{
	/**
	 * CONSTRUCTOR CLASE COORDINATE2D
	 * @param x Componente 1
	 * @param y Componente 2
	 */
	public Coordinate2D(int x, int y) {
		super(2);
		set(0,x);
		set(1,y);
	}
	/**
	 * CONSTRUCTOR COPIA CLASE COORDINATE2D
	 * @param c Se le pasa la coordenada a copiar
	 */
	public Coordinate2D(Coordinate2D c ) {
		super(c);
	}
		
		
	/**
	 * EL METODO COPY OBTIENE UNA COPIA DEL OBJETO INVOCADOR
	 * @return Devuelve la copia de dicho objeto 
	 */
	public  Coordinate copy() {
		return new Coordinate2D(this);
	}
	/**
	 * EL METODO ADJACENTCOORDINATES CALCULA LAS POSICIONES ADYACENTES A LA COORDENADA INVOCADORA
	 * @return adjCoor Devuelve un vector con las coordenadas buscadas
	 */
	public Set<Coordinate> adjacentCoordinates(){
		Set<Coordinate> adjCoor= new HashSet<Coordinate>();
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0),this.get(1)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1)));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1)));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1)+1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0),this.get(1)+1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1)+1));
		return adjCoor;
	}
	
	/**
	 * PERMITE IMPRIMIR EN PANTALLA UN OBJETO DE LA CLASE COORDINATE
	 * @return concatenacion Devuelve los atributos del objeto en forma de string(de la manera que prefiramos) listos para imprimir
	 */
	public String toString() {
		StringBuilder concatenacion= new StringBuilder();
		concatenacion.append("(");
		for(int i=0;i<2;i++) {
					concatenacion.append(get(i));
			if(i==0) {
				concatenacion.append(", ");
			}
		}
		concatenacion.append(")");
		return concatenacion.toString();
	
	}
}
