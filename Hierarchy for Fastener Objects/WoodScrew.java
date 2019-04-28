
import java.io.Serializable;

public class WoodScrew extends Screw implements Serializable{

	private static final long serialVersionUID = 6103924932815505449L;
	private String[] pointList = {"Double Cut", "Sharp", "Type 17"};
	private String point;
	private double pricePerUnit;
	
	// constructor accessing screw using super.
	public WoodScrew(double lth, String diamAndThrd, String mat, String fin, String hed, String drv, String pt, double price, int units)
			throws IllegalFastener {
		super(lth, diamAndThrd, mat, fin, hed, drv, price, units);
		setPoint(pt);
		pricePerUnit = price;
	}

	private void setPoint(String pt) throws IllegalFastener {		//sets the point type the wood screw
		if(illegalEntry(pt, pointList))
			throw new IllegalFastener("This is an invalid Point.");
		point = pt;
	}//end of setPoint

	@Override
	public String toString() {
		return "Wood Screw, " + point + " point, " + super.toString();
	}
	
	@Override
	public double getOrderCost(int units) {
		double costOfOrder = units*pricePerUnit;
		return costOfOrder;
	}

}