package model.io;

import java.io.BufferedReader;
import java.io.IOException;

import model.Board;
import model.CellStatus;
import model.Coordinate;
import model.CoordinateFactory;
import model.Craft;
import model.CraftFactory;
import model.Orientation;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;


/**
 * 
 * @author Angel Leon Cerdan
 * CLASE PlayerFile: Jugador a partir de un fichero de texto.
 *
 */

public class PlayerFile implements IPlayer{
	/**
	 * Lector para el fichero
	 */
	private BufferedReader br;
	/**
	 * Nombre del jugador
	 */
	private String name;
	/**
	 * Status del ultimo disparo
	 */
	private CellStatus lastShotStatus=null;
	/**
	 * CONSTRUCTOR DE PLAYERFILE
	 * @param name Nombre del jugador
	 * @param reader Lector a emplear
	 */
	public PlayerFile(String name, BufferedReader reader) {
		if(reader==null) {
			throw new NullPointerException("El bufferedreader apunta a null");	
		}else {
			this.br=reader;
			this.name=name;
		}
		
	}
	/**
	 * ESTE METODO IMPRIME EL ESTADO INTERNO DEL JUGADOR
	 * @return Devuelve el nombre y el tipo de jugador
	 */
	public String getName() {
		return name+" "+"(PlayerFile)";
	}
	/**
	 * ESTE METODO COLOCA LOS BARCOS DE UN JUGADOR
	 * @param b El tablero en el que se colocan las fichas
	 * @throws BattleshipIOException Error entrada salida
	 * @throws OccupiedCoordinateException Coordenada ocupada
	 * @throws InvalidCoordinateException Coordenada invalida
	 * @throws NextToAnotherCraftException Coordenada al lado de otra estructura
	 */
	public void putCrafts(Board b) throws BattleshipIOException, OccupiedCoordinateException, InvalidCoordinateException, NextToAnotherCraftException{
		String linea=null;
		String[] tokens=null;
		String name=null;
		String command=null;
		String orientacion=null;
		Coordinate newCoordinate=null;
		Craft pieza=null;
		
		if(b!=null) {
			try {
				linea=this.br.readLine();
				if(linea!=null){
					while(linea.length()!=0 && !linea.equals("endput") && !linea.equals("exit")){
						tokens=linea.split("\\s+");
						if(tokens.length==6 || tokens.length==5) {
							for(int i=0;i<tokens.length;i++) {
								if(i==0) {
									command=tokens[i];								
								}else if(i==1) {
									name=tokens[i];
								}else if(i==2) {
									orientacion=tokens[i];
								}else if(i==3) {
									if(tokens.length==5) {
										newCoordinate=CoordinateFactory.createCoordinate(Integer.parseInt(tokens[i]),Integer.parseInt(tokens[i+1]));
									}else {
										newCoordinate=CoordinateFactory.createCoordinate(Integer.parseInt(tokens[i]),Integer.parseInt(tokens[i+1]),Integer.parseInt(tokens[i+2]));			
									}	
								}
							}
							if(command.equals("put")) {
								if(orientacion.equals("NORTH") ){
									pieza=CraftFactory.createCraft(name, Orientation.NORTH);	
								}else if(orientacion.equals("SOUTH")) {
									pieza=CraftFactory.createCraft(name,Orientation.SOUTH);
									
								}else if(orientacion.equals("EAST")) {
									pieza=CraftFactory.createCraft(name, Orientation.EAST);
									
								}else if(orientacion.equals("WEST")) {
									pieza=CraftFactory.createCraft(name, Orientation.WEST);
									
								}else {
									throw new BattleshipIOException("Orientación incorrecta.");
								}
								b.addCraft(pieza, newCoordinate);
								
							}else {
								throw new BattleshipIOException("Error en comando.");							
							}	
						}else {
							throw new BattleshipIOException("Error en argumentos.");	
						}
						linea=this.br.readLine();
						if(linea==null) {
							break;
						}
					}
				}
			} catch (IOException e) {
				throw new BattleshipIOException("Error al leer una línea del bufferedreader.");
			} catch (NumberFormatException e) {
				throw new BattleshipIOException("Error en el ParseInt.");		
			}
		}else {
			throw new NullPointerException("El tablero pasado apunta a null.");
		}
	}
	/**
	 * ESTE METODO GENERA UN DISPARO AL JUGADOR
	 * @param b Tablero al que se le ha de disparar
	 * @return newCoordinate Coordenada a la que se ha disparado
	 * @throws BattleshipIOException Error entrada salida
	 * @throws InvalidCoordinateException Coordenada invalida
	 * @throws CoordinateAlreadyHitException Coordenada ya golpeada
	 */
	public Coordinate nextShoot(Board b) throws BattleshipIOException, InvalidCoordinateException, CoordinateAlreadyHitException{
		String linea=null;
        String[] tokens=null;
        String command=null;
        Coordinate newCoordinate=null;
        this.lastShotStatus=null;		
		if(b!=null) {
			try {
				linea=this.br.readLine();
				if(linea!=null) {
					if(linea.length()!=0 && !linea.equals("exit")) {
						tokens=linea.split("\\s+");
						if(tokens.length==3 || tokens.length==4) {
							for(int i=0;i<tokens.length;i++) {
								if(i==0) {
									command=tokens[i];
								}else if(i==1) {
									if(tokens.length==3) {
										newCoordinate=CoordinateFactory.createCoordinate(Integer.parseInt(tokens[i]),Integer.parseInt(tokens[i+1]));									
									}else {
										newCoordinate=CoordinateFactory.createCoordinate(Integer.parseInt(tokens[i]),Integer.parseInt(tokens[i+1]),Integer.parseInt(tokens[i+2]));									
									}								
								}
							}
							if(command.equals("shoot")) {
								this.lastShotStatus=b.hit(newCoordinate);							
							}else {
								
								throw new BattleshipIOException("Error en el comando");
							}						
						}else {
							this.lastShotStatus=null;
							throw new BattleshipIOException("Error en los argumentos.");						
						}
					}	
				}
			}catch(IOException e) {
				throw new BattleshipIOException("Error al leer una línea del bufferedreader");				
			}catch(NumberFormatException e) {
				throw new BattleshipIOException("Error en el ParseInt.");			
			}			
		}else {
			throw new NullPointerException("El tablero apunta a null.");			
		}		
		return newCoordinate;		
	}
	/**
	 * GETTER DE LASTSHOTSTATUS
	 * @return lastShotStatus
	 */
	public CellStatus getLastShotStatus() {
		return lastShotStatus;
		
	}
}
