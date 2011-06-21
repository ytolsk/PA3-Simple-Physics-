import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the main method for the game; 
 * It allows a player to set up a board and play the game; 
 * @author Yulia
 *
 */
public class Play {

	/**Takes input from user; 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Shape> sqrs = new ArrayList<Shape>();
		ArrayList<Shape> jews = new ArrayList<Shape>();
		
		gameView view = new gameView(0,0,sqrs,jews);
		
		
		System.out.println("How wide would you like your board to be?");
		Scanner scan = new Scanner(System.in);
		view.setWidth(scan.nextInt());
		System.out.println("Board width is now "+ view.getWidth());
		System.out.println("How high would you like your board to be?");
		view.setHeight(scan.nextInt());
		System.out.println("Board now has height " +view.getHeight());
		System.out.println("HOw many obstacles would you like?");
		int i =0;
		int max= scan.nextInt();
		while(  i< max ){
			int x= new Random().nextInt(view.getWidth());
			int y= new Random().nextInt(view.getHeight());
			Square sq = new Square(x,y,1);
			if(!view.getSquares().contains(sq)){
				view.addSquare(sq);
				System.out.println("square added at " + sq.getPosition() );
				i+=1;
			}		
			
		}
		System.out.println("HOw many jewels would you like?");
		int j=0;
		int m = scan.nextInt();
		while( j < m ){
			int x= new Random().nextInt(view.getWidth());
			int y= new Random().nextInt(view.getHeight());
			Square sq = new Square(x,y,1);
			if(!view.getSquares().contains(sq) && !view.getJewels().contains(sq)){
				view.addJewel(sq);
				System.out.println("jewel added at " + sq.getPosition());
				j+=1;
			}
		}
		GamePlay game = new GamePlay(view);
		System.out.println("How many disks would you like?");
		int disknum = scan.nextInt();
		for(int k=0; k < disknum;k++){
			game.addDisk(new Disk(1));
		}
		
		for(int k=0; k < disknum;k++){
			System.out.println("To start you will need to flick a disk up. You can later move it sideways, by typing in a new horizontal velocity.");
			System.out.println("Enter your initial vertical velocity.");		
			Disk d = game.disks.get(0);
			game.flick(d, scan.nextInt());
			if( game.gamePlaying()){
				System.out.println("Horizontal now!");
				game.moveHor(d,scan.nextInt());
			}
			if(game.disks.isEmpty()){
				System.out.println("Sorry! No more Disks! You lost!");
				break;
			}
			
			
		}
		
		
		
		
		

	}

}
