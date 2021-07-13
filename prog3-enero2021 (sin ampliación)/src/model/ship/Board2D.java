package model.ship;

import model.Board;
import model.Coordinate;
import model.CoordinateFactory;
/**
 * 
 * @author Angel Leon Cerdan 74379711B
 * CLASS BOARD2D:
 * Representa el tablero 2D en el juego de hundir la flota.
 */

public class Board2D extends Board {
	/**
	 * CONSTRUCTOR DE LA CLASE BOARD2D
	 * @param size El tamaño del tablero.
	 */
	public Board2D(int size) {
		super(size);
	}
	/**
	 * INDICA SI UNA COORDENADA ESTA DENTRO DEL TABLERO
	 * @param c La coordenada a analizar.
	 * @return CoordOK True si la coordenada esta dentro del tablero y false si esta fuera.
	 */
	@Override
	public boolean checkCoordinate(Coordinate c) {
		boolean CoordOK=true;
		if(c instanceof Coordinate2D) {
			if((c.get(0)<0 || c.get(0)>this.getSize()-1)||(c.get(1)<0 || c.get(1)>this.getSize()-1)) {
				CoordOK=false;
			}
		}else {
			throw new IllegalArgumentException("La coordenada c no es del tipo 2D.");
		}
		return CoordOK;
		
	}
	/**
	 * DEVUELVE UN STRING CON EL ESTADO DEL TABLERO
	 * @param unveil Indica si se quiere ver el tablero completo(true) o de forma parcial(false).
	 * @return El estado buscado.
	 */
	@Override
	public String show(boolean unveil) {
		StringBuilder tablero= new StringBuilder();;
		if(unveil==true) {
			for(int i=0;i<this.getSize();i++) {
				for(int j=0;j<this.getSize();j++) {
					Coordinate c= CoordinateFactory.createCoordinate(j,i);
					if(this.getCraft(c)==null) {
						tablero.append(Board2D.WATER_SYMBOL);
					}else if(this.getCraft(c)!=null && this.isSeen(c)){
						tablero.append(Board2D.HIT_SYMBOL);	
					}else {
						tablero.append(this.getCraft(c).getSymbol());
					}
					if(j==this.getSize()-1 && i!=this.getSize()-1) {
						tablero.append("\n");
					}
				}
				
			}
		}else {
			for(int i=0;i<this.getSize();i++) {
				for(int j=0;j<this.getSize();j++) {
					Coordinate c2= CoordinateFactory.createCoordinate(j,i);
					if(this.getCraft(c2)==null && this.isSeen(c2)) {
						tablero.append(Board2D.WATER_SYMBOL);
						
					}else if(this.getCraft(c2)!=null && this.isSeen(c2) && this.getCraft(c2).isShotDown()==false) {
						tablero.append(Board2D.HIT_SYMBOL);
						
					}else if(this.getCraft(c2)!=null && this.isSeen(c2) && this.getCraft(c2).isShotDown()==true){
						tablero.append(this.getCraft(c2).getSymbol());
					}else {
						tablero.append(Board2D.NOTSEEN_SYMBOL);
					}
					if(j==this.getSize()-1 && i!=this.getSize()-1) {
						tablero.append("\n");
					}
				}
			}
			
			
		}
		return tablero.toString();
	}

}
