/*
	Coin.java THIS IS THE ONLY FILE YOU HAND IN
	THERE IS NO MAIN METHOD IN THIS CLASS!
*/
import java.util.Random;
public class Coin {
	private int headCount,tailCount;
	private Random random;

	public Coin(int seed) {
		random = new Random(seed);
		headCount = 0;
		tailCount = 0;
	}
  
	public char flip() {

		int result = random.nextInt(2);

		if(result == 0){
			setTails(getNumTails() + 1);
			return 'T';
		} else {
			setHeads(getNumHeads() + 1);
			return 'H';
		}

	}
  
	public int getNumHeads(){
		return headCount;
	}
  

	public int getNumTails(){
		return tailCount;
	}

	public void setHeads( int h ){
		headCount = h;
	}

	public void setTails( int t ){
		tailCount = t;
	}
  
	//This method resets counters to zero
	public void reset(){
		headCount = 0;
		tailCount = 0;
	}
} // END COIN CLASS