package model.io;

import java.awt.Color;
import java.io.File;

import model.Board;
import model.Game;
import model.exceptions.io.BattleshipIOException;
import model.io.gif.AnimatedGIF;
import model.io.gif.FrameGIF;
/**
 * CLASE VISUALISERGIF: Esta clase representa un visor de la partida en forma de GIF
 * @author Angel Leon Cerdan
 *
 */
public class VisualiserGIF implements IVisualiser{
	/**
	 * EL JUEGO A MOSTRAR 
	 */
	private Game game;
	/**
	 * EL GIF GENERADO
	 */
	private AnimatedGIF agif;
	
	/**
	 * CONSTRUCTOR VISUALISERGIF
	 * @param g El juego a analizar
	 */
	public VisualiserGIF(Game g) {
		if(g!=null) {
			this.game=g;
			agif= new AnimatedGIF();			
		}else {
			throw new NullPointerException("El juego apunta a null.");
		}
		
	}
	/**
	 * ESTE METODO GENERA FRAMES PARA CONSTRUIR EL GIF DESEADO A PARTIR DEL JUEGO
	 */
	public void show() {
		Board tablero1=null;
		Board tablero2=null;
		String board1=null;
		String board2=null;
		FrameGIF frame=null;
		tablero1= game.getBoard1();
		tablero2=game.getBoard2();
		board1=tablero1.show(false);
		board2=tablero2.show(false);
		String[] tokens=board1.split("\n");
		String[] tokens2=board2.split("\n");
		int w=tokens[0].length();
		int h=tokens.length;		
		frame = new FrameGIF(w, h*2+1);
		try {
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(tokens[i].charAt(j)==Board.NOTSEEN_SYMBOL) {
						frame.printSquare(j, i, Color.LIGHT_GRAY);						
					}else if(tokens[i].charAt(j)==Board.WATER_SYMBOL){
						frame.printSquare(j, i, Color.BLUE);						
					}else if(tokens[i].charAt(j)==Board.HIT_SYMBOL) {
						frame.printSquare(j, i, Color.RED);
					}else if(tokens[i].charAt(j)==Board.BOARD_SEPARATOR){
						frame.printSquare(j, i, Color.ORANGE);					
					}else {
						frame.printSquare(j, i, Color.RED);					
					}
				}		
			}
			for(int i=0;i<w;i++) {
				frame.printSquare(i, h, Color.DARK_GRAY);
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(tokens2[i].charAt(j)==Board.NOTSEEN_SYMBOL) {
						frame.printSquare(j, i+h+1, Color.LIGHT_GRAY);					
					}else if(tokens2[i].charAt(j)==Board.WATER_SYMBOL){
						frame.printSquare(j, i+h+1, Color.BLUE);						
					}else if(tokens2[i].charAt(j)==Board.HIT_SYMBOL) {
						frame.printSquare(j, i+h+1, Color.RED);
					}else if(tokens2[i].charAt(j)==Board.BOARD_SEPARATOR){
						frame.printSquare(j, i+h+1, Color.ORANGE);					
					}else {
						frame.printSquare(j, i+h+1, Color.RED);					
					}
				}
			}			
			agif.addFrame(frame);
		}catch(BattleshipIOException e) {
			throw new RuntimeException();		
		}
			
	}

	/**
	 * ESTE METODO GUARDA EL GIF GENERADO
	 */
	public void close(){
		try {
			agif.saveFile(new File("files/output.gif"));
		} catch (BattleshipIOException e) {
			throw new RuntimeException();
		}		
	}

}
