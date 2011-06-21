import java.awt.Point;
import java.util.ArrayList;

/**
 * This is an abstract class that all shapes (discs, squares, jewels) extend; Each shape has a position
 * and methods to get and set its x and y coordinates;
 * @author Yulia
 *
 */
public class Shape {
	int x;
	int y;
	Point position; // this represents the lower left corner of the shape (aka start (0,0));
	
	/**
	 * The constructor takes two integers 
	 * @param X- the x coordinate; 
	 * @param Y- the y coordinate
	 * and creates a point with them; 
	 */
	public Shape(int X, int Y ){
		x= X;
		y = Y;
		position = new Point(X,Y);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int X){
		x=X;
		position = new Point(X,getY());
	}
	public void setY(int Y){
		y=Y;
		position = new Point(getX(),Y);
	}
	
	public Point getPosition(){
		return position; 
	}
	
	public ArrayList<Point> getPointsWithin(){
		return null;
	}

}
