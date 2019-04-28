
import java.io.Serializable;

public abstract class Bolt extends OuterThreaded implements Serializable{
	
	private static final long serialVersionUID = -1406310192869784029L;
	private String[] finishList = {"Plain", "Chrome", "Yellow Zinc", "Zinc", "Hot Dipped Galvanized"};
	
	// constructor accessing the outerThreaded class with super.
	public Bolt(double lth, String diamAndThrd, String mat, String fin, double price, int units) throws IllegalFastener {
		super(lth, diamAndThrd, mat, fin, price, units);
		if(illegalEntry(fin,finishList))
			throw new IllegalFastener("This is an invalid Finish.");
	}

}