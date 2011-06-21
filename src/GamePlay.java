import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
/**
 * This si the class responsible for actually implementing the game play, 
 * using Shape objects in a space described by teh Game view;
 * @author Yulia
 *
 */

public class GamePlay {
	gameView view;
	boolean movev;
	boolean moveh; 
	ArrayList<Disk> disks; 
	Boolean motion;
	/**
	 * Construts a set up to be played in; 
	 * @param newview a Gameview, describing the board; 
	 */
	public GamePlay(gameView newview){
		view = newview;
		movev = false; 
		moveh = false; 
		disks = new ArrayList<Disk>(); // disks that can be launched in this game; 
		motion = false; // keeps track of the movement of the disks; 
	}
	/**
	 * Adds a disk to the disks that can be used in the game; 
	 * @param newdisk
	 */
	public void addDisk(Disk newdisk){
		disks.add(newdisk);
	}
	
	/**
	 * Allows the user to flick a disk vertically up; 
	 * @param disk - disk to be thrown; 
	 * @param speed - the initial speed the disk will be launched with; 
	 */
	public void flick(final Disk disk, double speed){
		movev = true;
		Timestamp ts = new Timestamp ( System.currentTimeMillis (  )  );
		while (movev == true){
			Timestamp ns = new Timestamp ( System.currentTimeMillis (  )  );
			int time = (ns.getSeconds()-ts.getSeconds());
			if(time>0){// this makes sure that the loop is not run ever nanosecond 
				disk.setY(disk.getY()+(int) Math.ceil((speed*(time)-.5*9.8 *(time)*(time))));
				System.out.println((int) Math.ceil((speed*(time)-.5*9.8 *time*time)));
				speed = -9.8 *time+ speed;	
				motion = true; 
			
				if(disk.hit(view.getSquares())!= null){// checks if disk hit a square
					movev = false;
					motion = false; 
					view.addSquare(disk);
					disks.remove(disk);
					System.out.print("you hit a square! Try again!");
					
					
				}
				else if(disk.hit(view.getJewels())!= null){// checks if disk hit a Jewel
					movev = false;
					motion = false; 
					view.jewels.remove(disk.hit(view.getJewels()));
					System.out.print("Yaay! You hit a jewel!");	
					if(view.getJewels().isEmpty()){
						System.out.print("No More Jewels!You win!");
						disks.remove(disk);
						
					}
					
				}
				else if(disk.getY()>= view.getHeight()){// check if disk went out of bounds
					movev= false; 
					motion = false; 
					System.out.print("Out of bounds! Play Again!");
					disks.remove(disk);
					
				}
				else if(disk.getY()<0){// checks if disk hit the ground
					movev= false; 
					motion = false; 
					System.out.print("You hit the ground");
					disks.remove(disk);
					
				}		
					
				
				
			}
					
		}
	}
	/**
	 * This method is to move the disk horizontally; 
	 * @param disk - disk to be moved; 
	 * @param speed - speed with wich we move the disk; 
	 */
	public void moveHor(Disk disk, double speed){
		moveh = true;
		Timestamp ts = new Timestamp ( System.currentTimeMillis (  ) );
		while (moveh == true){
			Timestamp ns = new Timestamp ( System.currentTimeMillis (  )  );
			int time = (ns.getSeconds()-ts.getSeconds());
			if(time>0){
				disk.setX(disk.getX()+(int) Math.ceil(speed)*time);	
			if(disk.hit(view.getSquares())!= null){
				moveh = false;
				motion= false; 
				view.addSquare(disk);
				disks.remove(disk);
				System.out.print("you hit a square! Try again!");	
				
			}
			if(disk.hit(view.getJewels())!= null){
				moveh = false;
				motion= false;
				view.jewels.remove(disk.hit(view.getJewels()));
				disks.remove(disk);
				System.out.print("Yaay! You hit a jewel!");	
				if(view.getJewels().isEmpty()){
					System.out.print("No More Jewels!You win!");
				}
				
			}
			if(disk.getX()>= view.getWidth()){
				moveh= false; 
				motion= false;
				System.out.print("Out of bounds! Play Again!");
				disks.remove(disk);
			}
			
					
		}
		}
		
	}
	/**
	 * 
	 * @return - returns whether there is a disk in play or not; 
	 */
	public boolean gamePlaying(){
		return motion; 
	}
	
	

}
