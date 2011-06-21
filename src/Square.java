import java.awt.Point;
import java.util.ArrayList;

/**
 * A square is a type of Shape, that cannot be flung; On top of the usual position coordinates, it has a 'side' field.
 * @author Yulia
 *
 */
public class Square extends Shape{

	int side; 
	
	/**
	 * Uses the Shape constructor
	 * @param X an integer that sets the x coordinate; 
	 * @param Y an integer that sets the x coordinate; 
	 * @param Side an integer that sets the size of the side of the square; 
	 */
	public Square(int X, int Y, int Side){
		super(X,Y);
		side = Side; 
	}
	
	/**
	 * 
	 * @return all the points withing the square; 
	 */
	@Override
	public ArrayList<Point> getPointsWithin(){
		ArrayList<Point> mypoints = new ArrayList<Point>();
		for (int x = getX(); x<= getX()+side; x++){
			for (int y = getY(); y <= getY()+side; y++){
				mypoints.add(new Point(x, y));
			}
		}
		return mypoints; 
	}
}
