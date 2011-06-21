import java.awt.Point;
import java.util.ArrayList;

/**
 * A disk is a type of shape. The Shape position field, refers to the center of the disk. 
 * It also has a radius, and a horizontal and vertical speed. A disk can be flicked vertically and horizontally; 
 * @author Yulia
 *
 */
public class Disk extends Shape {
	int radius; 
	int horvel;
	int vervel; 
	/**
	 * The disk constructor, uses the Shape constructor;  The disks always starts at  (0,0);
	 * 
	 * @param R the radius of the disk;
	 */
	public Disk( int R){
		super (0,0);
		radius = R;
		horvel = 0;
		vervel =0;
	}
	
	/**
	 * The area taken up by the disk, is treated as though it is a square (for simplicity);
	 * @return all the points contained in the disk
	 */
	@Override
	public ArrayList<Point> getPointsWithin(){
		ArrayList<Point> mypoints = new ArrayList<Point>();
				for(int x= getX(); x<= Math.ceil(getX()+2*radius); x++){
			for(int y= getY(); y<= Math.ceil(getY()+2*radius); y++){
				mypoints.add(new Point(x,y));
			}			
		}		
		return mypoints; 
	}
	
	/**
	 * This represent the  vertical speed; 
	 * @param Speed an integer for the initial speed the disk is flicked with; 
	 */
	public void setVertical(int Speed){
		vervel = Speed;
	}
	
	/**
	 * The horizontal movement, stops vertical movement and sets a speed for the horizontal; 
	 * @param Speed an integer representing the horizontal speed; 
	 */
	public void setHorizontal(int Speed){
		vervel =0;
		horvel = Speed; 
	}
	
	public Shape hit(ArrayList<Shape> squares){
		Shape hit = null; 
		for (Shape square: squares) {
			for(Point p: square.getPointsWithin()){
				if(this.getPointsWithin().contains(p)){
					hit =square;
					vervel =0;
					horvel=0;
				}
			}
		}
		
		return hit;
	}

	
	
	
	

}
