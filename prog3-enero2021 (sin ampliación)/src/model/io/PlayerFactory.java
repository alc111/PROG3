package model.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import model.exceptions.io.BattleshipIOException;

/**
 * CLASE PLAYERFACTORY: Esta clase representa una fabrica de jugadores
 * @author Angel Leon Cerdan
 *
 */
public class PlayerFactory {
	/**
	 * ESTE METODO CREA EL JUGADOR DESEADO
	 * @param name Nombre del jugador
	 * @param s Fichero a analizar o seed
	 * @return El jugador buscado
	 * @throws BattleshipIOException Error entrada salida
	 */
	public static IPlayer createPlayer(String name, String s) throws BattleshipIOException {
		IPlayer jugador=null;
		BufferedReader lector=null;
		if(s.contains(".") || s.contains("\\") || s.contains("/")) {
			try {
				lector=new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				throw new BattleshipIOException("Fichero especificado no encontrado");
			}
			jugador= new PlayerFile(name,lector);
			
		}else if(isLong(s)) {
			jugador= new PlayerRandom(name,Long.parseLong(s));			
		}		
		return jugador;
	}
	/**
	 * COMPRUEBA SI UN STRING ES TRANSFORMABLE EN UN LONG
	 * @param s El string a analizar
	 * @return True si es tranformable y false en caso contrario
	 */
	private static boolean isLong(String s) {
		try {
			Long.parseLong(s);			
		}catch(NumberFormatException e) {
			return false;			
		}		
		return true;		
	}

}
