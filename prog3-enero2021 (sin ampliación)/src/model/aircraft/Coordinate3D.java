package model.aircraft;

import java.util.HashSet;

import java.util.Set;

import model.Coordinate;
import model.CoordinateFactory;
/**
 * CLASE COORDINATE3D: REPRESENTA LAS COORDENADAS QUE POSEEN 3 DIMENSIONES
 * @author Angel Leon Cerdan
 *
 */

public class Coordinate3D extends Coordinate{
	/**
	 * CONSTRUCTOR CLASE COORDINATE3D
	 * @param x Componente 1
	 * @param y Componente 2
	 * @param z Componente 3
	 */
	public Coordinate3D(int x, int y, int z) {
		super(3);
		set(0,x);
		set(1,y);
		set(2,z);
	}
	/**
	 * CONSTRUCTOR DE COPIA CLASE COORDINATE3D
	 * @param c Coordenada a copiar
	 */
	public Coordinate3D(Coordinate3D c) {
		super(c);
	}
	/**
	 * EL METODO COPY OBTIENE UNA COPIA DEL OBJETO INVOCADOR
	 * @return Devuelve la copia de dicho objeto 
	 */
	public  Coordinate copy() {
		return new Coordinate3D(this);
	}
	/**
	 * EL METODO ADJACENTCOORDINATES CALCULA LAS POSICIONES ADYACENTES A LA COORDENADA INVOCADORA
	 * @return adjCoor Devuelve un vector con las coordenadas buscadas
	 */
	public Set<Coordinate> adjacentCoordinates() {
		Set<Coordinate> adjCoor= new HashSet<Coordinate>();
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1)-1,this.get(2)));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0),this.get(1)-1,this.get(2)));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1)-1,this.get(2)));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1),this.get(2)));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1),this.get(2)));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1)+1,this.get(2)));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0),this.get(1)+1,this.get(2)));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1)+1,this.get(2)));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1)-1,this.get(2)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0),this.get(1)-1,this.get(2)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1)-1,this.get(2)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1),this.get(2)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1),this.get(2)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1)+1,this.get(2)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0),this.get(1)+1,this.get(2)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1)+1,this.get(2)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0),this.get(1),this.get(2)-1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1)-1,this.get(2)+1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0),this.get(1)-1,this.get(2)+1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1)-1,this.get(2)+1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1),this.get(2)+1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1),this.get(2)+1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)-1,this.get(1)+1,this.get(2)+1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0),this.get(1)+1,this.get(2)+1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0)+1,this.get(1)+1,this.get(2)+1));
		adjCoor.add(CoordinateFactory.createCoordinate(this.get(0),this.get(1),this.get(2)+1));
		return adjCoor;
	}
	/**
	 * PERMITE IMPRIMIR EN PANTALLA UN OBJETO DE LA CLASE COORDINATE
	 * @return concatenacion Devuelve los atributos del objeto en forma de string(de la manera que prefiramos) listos para imprimir
	 */
	public String toString() {
		StringBuilder concatenacion= new StringBuilder();
		concatenacion.append("(");
		for(int i=0;i<3;i++) {
				concatenacion.append(get(i));
			if(i<2) {
				concatenacion.append(", ");
			}
		}
		concatenacion.append(")");
		return concatenacion.toString();
	
	}
}
