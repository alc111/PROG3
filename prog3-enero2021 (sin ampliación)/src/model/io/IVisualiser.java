package model.io;
/**
 * INTERFAZ DE VISUALISER
 * @author Angel Leon Cerdan
 *
 */

public interface IVisualiser {
	/**
	 * MUESTRA LA PARTIDA DE FORMA GRAFICA
	 */
	public abstract void show();
	/**
	 * GUARDA EL GIF GENERADO 
	 */
	public abstract void close();
}
