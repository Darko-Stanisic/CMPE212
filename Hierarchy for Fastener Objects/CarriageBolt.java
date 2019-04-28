
import java.io.Serializable;

public class CarriageBolt extends Bolt implements Serializable{

	private static final long serialVersionUID = -441811824775414635L;
	private double pricePerUnit;
	
	// constructor accessing the bolt class with super
	public CarriageBolt(double lth, String diamAndThrd, String mat, String fin, double price, int units)
			throws IllegalFastener {
		super(lth, diamAndThrd, mat, fin, price, units);
		pricePerUnit = price;
	}
	@Override
	public double getOrderCost(int units) {
		double costOfOrder = units*pricePerUnit;
		return costOfOrder;
	}
	@Override
	public String toString() {
		return "Carriage Bolt, " + super.toString();
	}
}