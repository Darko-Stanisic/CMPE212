

import java.io.Serializable;

public class CommonNail extends Nail implements Serializable{

	private static final long serialVersionUID = 8706890604705876422L;
	private double pricePerUnit;
	private String[] finishList = {"Bright", "Hot Dipped Galvanized"};	//can only be finish values for Common Nail
	
	//constructor accessing nail with super
	public CommonNail(String sz, double lth, double gge, String fin, double price, int units) throws IllegalFastener {
		super(fin, price, units, lth, sz, gge);
		pricePerUnit = price;
		if(illegalEntry(fin, finishList))
			throw new IllegalFastener("This is an invalid Finish.");
	}
	
	@Override
	public double getOrderCost(int units) {
		double costOfOrder = units*pricePerUnit;
		return costOfOrder;
	}
	
	@Override
	public String toString() {
		return "Common Nail," + super.toString();
	}
	
}