

import java.io.Serializable;

public abstract class Threaded extends Fastener implements Serializable{
	
	private static final long serialVersionUID = 7332633766611507613L;
	private String[] diamAndThreadList = {"#8-13", "#8-15", "#8-32", "#10-13", "#10-24", "#10-32", "1/4-20", "5/16-18", "3/8-16", "7/16-14", "1/2-13", "5/8-11", "3/4-10"};
	private String diamAndThread;
	private String[] finishList = {"Plain", "Chrome", "Yellow Zinc", "Zinc", 
			"Hot Dipped Galvanized", "Black Phosphate", "ACQ 1000 Hour", "Lubricated"};
	
	// constructor for threaded
	public Threaded(String diamAndThrd, String mat, String fin, double price, int units) throws IllegalFastener {
		super(mat, fin, price, units);
		setThread(diamAndThrd);
		if(illegalEntry(fin,finishList)) 
			throw new IllegalFastener("This is an invalid Finish.");
	}//end Threaded

	
	private void setThread(String trd) throws IllegalFastener{
		if(illegalEntry(trd, diamAndThreadList)) //checks if trd is in the list for Diameter and Thread.
			throw new IllegalFastener("This is an invalid Thread.");
		diamAndThread = trd;
	}//end setThread
	
	@Override
	public String toString() {
		return diamAndThread + " thread, " + super.toString();
	}
}