import java.awt.Point;
import java.util.ArrayList;

/**
 * This class represents a playing board for the game; 
 * @author Yulia
 *
 */
public class gameView {
	
	int width; 
	int height;
	ArrayList<Shape> squares;
	ArrayList<Shape> jewels; 
	
	/**
	 * Builds a new board
	 * @param Width - width of board
	 * @param Height - height of board
	 * @param Squares - number of obstacle squares
	 * @param Jewels - number of jewels; 
	 */
	
	public gameView(int Width, int Height, ArrayList<Shape> Squares, ArrayList<Shape> Jewels){
		width = Width;
		height = Height; 
		squares = Squares;
		jewels = Jewels; 
	}
	
	/**
	 * 
	 * @return width of board
	 */
	public int getWidth(){
		return width;
	}
	/**
	 * 
	 * @return - returns height of board
	 */
	public int getHeight(){
		return height; 
	}
	/**
	 * Sets the width of board
	 * @param w - desired width; 
	 */
	public void setWidth(int w){
		width=w;
	}
	/**
	 * sets height of board; 
	 * @param h desired height; 
	 */
	public void setHeight(int h){
		height=h; 
	}
	/**
	 * 
	 * @return - all the squares (or stuck disks) of the game;
	 */
	public ArrayList<Shape> getSquares(){
		return squares;
	}
	/**
	 * Adds more obstacle squares
	 * @param newsquare - square desired to be added
	 */
	public void addSquare(Shape newsquare){
		squares.add(newsquare);
	}
	/**
	 * 
	 * @return - all the jewels of the game; 
	 */
	public ArrayList<Shape> getJewels(){
		return jewels; 
	}
	/**
	 * Adds another jewel; 
	 * @param newjew
	 */
	public void addJewel(Shape newjew){
		squares.add(newjew);
	}

}
