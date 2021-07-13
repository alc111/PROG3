package model.io;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import model.Game;
/**
 * CLASE VISUALISERFACTORY: Esta clase representa una fábrica de visores
 * @author Angel Leon Cerdan
 *
 */

public class VisualiserFactory {
	/**
	 * ESTE METODO CREA EL VISOR DESEADO
	 * @param n Tipo de visor a generar
	 * @param g El juego a visualizar
	 * @return El visor pedido
	 */
	public static IVisualiser createVisualiser(String n, Game g) {
		Class<?> clase=null;
		Constructor<?> constructor=null;
		Object visualiser;
		try {
			clase=Class.forName("model.io.Visualiser"+n);
			constructor=clase.getConstructor(new Class<?>[] {Game.class});
			visualiser=constructor.newInstance(g);
		} catch (ClassNotFoundException|NoSuchMethodException|SecurityException |InstantiationException|IllegalAccessException|IllegalArgumentException|InvocationTargetException e) {
			visualiser=null;
		}
		return (IVisualiser) visualiser;
		
	}

}
