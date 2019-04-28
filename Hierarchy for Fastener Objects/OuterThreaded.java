

import java.io.Serializable;

public abstract class OuterThreaded extends Threaded implements Serializable{

	private static final long serialVersionUID = -406819853919818583L;
	private double length;
	
	// constructor accessing Threaded using super.
	public OuterThreaded(double lth, String diamAndThrd, String mat, String fin, double price, int units) throws IllegalFastener {
		super(diamAndThrd, mat, fin, price, units);
		setLength(lth);
	}

		private boolean illegalLength(double lth) {		//A check if length is valid entry.
			if((lth >= 0.5 && lth <= 6 && lth % 0.25 == 0.0) || // conditions give in instructions.
				(lth >= 6 && lth <= 11 && lth % 0.5 == 0.0) ||
				(lth >= 11 && lth <= 20 && lth % 1 == 0.0)) {
				return false;
			}
		return true;
		}
		
	private void setLength(double lth) throws IllegalFastener{		//sets the length of the fastener
		if(illegalLength(lth)) 
			throw new IllegalFastener("This is an invalid length.");
		length = lth;
	}//end of setLength

	@Override
	public String toString() {
		return length + "\" long, " + super.toString();
	}
}