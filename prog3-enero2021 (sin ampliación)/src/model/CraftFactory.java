package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 
 * @author Angel Leon Cerdan
 * CLASE CRAFTFACTORY: Esta clase representa una fábrica de piezas
 *
 */
public class CraftFactory {
	/**
	 * ESTE METODO CREA PIEZAS DE DISTINTO TIPO
	 * @param type Que clase de pieza
	 * @param orientation Con que orientacion
	 * @return craft La pieza fabricada
	 */
	public static Craft createCraft(String type, Orientation orientation) {
		Object craft=null;
		Class<?> clase=null;
		Constructor<?> constructor=null;

		try {
			clase=Class.forName("model."+type);
			constructor=clase.getConstructor(new Class<?>[] {Orientation.class});
			craft=constructor.newInstance(orientation);
		} catch (ClassNotFoundException|NoSuchMethodException|SecurityException |InstantiationException|IllegalAccessException|IllegalArgumentException|InvocationTargetException e) {
			craft=null;
		}
		return (Craft) craft;
	}

}
