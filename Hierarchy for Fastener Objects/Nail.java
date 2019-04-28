
import java.io.Serializable;

public abstract class Nail extends Fastener implements Serializable{

	private static final long serialVersionUID = -3718288316826916306L;
	private double[] listLength = {2, 2.5, 3, 3.25, 3.5, 6};
	private double length;
	private String[] listSize = {"6D", "8D", "10D", "12D", "16D", "60D"};
	private String size;
	private double[] listGauge = {2, 8, 9, 10.25, 11.5};
	private double gauge;
	
	//constructor accessing Fastener using super.
	public Nail(String fin, double price, int units, double lth, String sz, double gge) throws IllegalFastener {
		super("Steel", fin, price, units);
		setLength(lth);
		setSize(sz);
		setGauge(gge);
	}

	private void setGauge(double gau) throws IllegalFastener{	//sets the gauge for the nail
		if(illegalEntry(gau, listGauge)) //test if gau is in the list of acceptable gauges
			throw new IllegalFastener("This is an invalid gauge.");
		gauge = gau;
	}//end setGauge

	private void setSize(String sz) throws IllegalFastener{	//sets the size for the nail
		if(illegalEntry(sz, listSize)) //test if sz is in the list of acceptable sizes
			throw new IllegalFastener("This is an invalid size.");
		size = sz;
	}//end setSize

	//mutator for the length attribute.
	private void setLength(double lth) throws IllegalFastener{
		if(illegalEntry(lth, listLength)) //ensures the input is in the accepted list of inputs.
			throw new IllegalFastener("This is an invalid length.");
		length = lth;
	}//end setLength
	
	@Override
	public String toString() {
		return size + " size, " + length + "\" long, " + gauge + " gauge, " + super.toString();
	}
}