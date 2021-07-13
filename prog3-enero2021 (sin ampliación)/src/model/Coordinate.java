package model;

import java.util.Arrays;
import java.util.Set;

/**
 * CLASE COORDINATE: REPRESENTA COORDENADAS EN EL JUEGO DE HUNDIR LA FLOTA
 * @author ANGEL LEON CERDAN 74379711B
 */
public abstract class Coordinate {
	/**
	 * ATRIBUTOS:
	 * components->Vector de enteros que contiene el valor numerico de cada coordenada
	 */
	private int[] components;
	/**
	 * CONSTRUCTOR DE LA CLASE COORDINATE
	 * @param dim Tamaño de la coordenada
	 */
	protected Coordinate(int dim) {
		components = new int[dim];
	}

	/**
	 * CONSTRUCTOR DE COPIA 
	 * @param c Objeto de clase Coordinate a replicar
	 */
	protected Coordinate(Coordinate c) {
		components = new int[c.components.length];
		for (int i = 0; i < components.length; i++) {
			components[i] = c.components[i];
		}
	}
	/**
	 * GETTER DE UN COMPONENTE DETERMINADO
	 * @param component Posicion de la coordenada que deseamos obtener
	 * @return Devueve el componente deseado o un -1 para indicar que no ha sido posible encontrarlo
	 */

	public int get(int component) {
		if(component>=0 && component<components.length) {
			return components[component];
		}else {
			throw new java.lang.IllegalArgumentException("Componente fuera de rango.");
		}
	}
	/**
	 * SETTER DE UN COMPONENTE DETERMINADO
	 * @param component Componente al que se le desea actualizar el valor
	 * @param value Valor a introducir en el componente especificado
	 */

	protected void set(int component, int value) {
		if(component>=0 && component<components.length) {
			components[component]=value;
			
		}else {
			throw new java.lang.IllegalArgumentException("Componente fuera de rango.");
			
		}

	}

	/**
	 * ESTA FUNCION OBTIENE UN OBJETO CORRESPONDIENTE A LA SUMA DE OTROS DOS
	 * @param c Recibe uno de los objetos que se busca sumar(el otro es el propio objeto invocador)
	 * @return new_c Devuelve el objeto correspondiente a la suma de los otros dos
	 */
	public Coordinate add(Coordinate c) {
		Coordinate new_c= this.copy();
		if(c!=null) {
			if(this.components.length==c.components.length) {
				for(int i=0;i<components.length;i++) {
					new_c.set(i, new_c.get(i) + c.get(i));
				}
				
			}else {
				for(int i=0;i<2;i++) {
					new_c.set(i, new_c.get(i) + c.get(i));
				}	
			}
		}else {
			throw new java.lang.NullPointerException("La coordenada pasada por parámentro apunta a null.");
			
		}
		return new_c;
		
	}
	/**
	 * ESTA FUNCION OBTIENE UN OBJETO CCORRESPONDIENTE A LA RESTA DE OTROS DOS
	 * @param c Recibe uno de los objetos que se busca restar(el otro es el propio objeto invocador)
	 * @return new_c Devuelve el objeto correspondiente a la resta de los otros dos
	 */
	public Coordinate subtract(Coordinate c) {
		Coordinate new_c= this.copy();
		if(c!=null) {
			if(this.components.length==c.components.length) {
				for(int i=0;i<components.length;i++) {
					new_c.set(i, new_c.get(i) - c.get(i));	
				}
			}else {
				for(int i=0;i<2;i++) {
					new_c.set(i, new_c.get(i) - c.get(i));	
				}
				
			}
		}else {
			throw new java.lang.NullPointerException("La coordenada pasada por parámentro apunta a null.");
		}
		
		return new_c;
		
	}
	/**
	 * EL METODO ADJACENTCOORDINATES CALCULA LAS POSICIONES ADYACENTES A LA COORDENADA INVOCADORA
	 * @return adjCoor Devuelve un vector con las coordenadas buscadas
	 */
	public abstract Set<Coordinate> adjacentCoordinates();
	/**
	 * EL METODO COPY OBTIENE UNA COPIA DEL OBJETO INVOCADOR
	 * @return Devuelve la copia de dicho objeto 
	 */
	public abstract Coordinate copy();
	/**
	 * ESTA FUNCION OBTIENE EL HASH CODE COREESPONDIENTE AL OBJETO INVOCADOR
	 * @return result Devuelve el identificador(Hash Code) del objeto invocador
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(components);
		return result;
	}
	/**
	 * COMPARA DOS OBJETOS DISTINTOS Y ESTABLECE SI SON IGUALES O NO
	 * @param obj Recibe un objeto de la clase Object a comparar con el que ha llamado a la funcion
	 * @return Devuelve un booleano que indica si los dos objetos son iguales(true) o no(false)
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (!Arrays.equals(components, other.components))
			return false;
		return true;
	}
}
	
	


