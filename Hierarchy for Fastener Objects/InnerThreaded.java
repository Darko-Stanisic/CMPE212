import java.io.Serializable;

public abstract class InnerThreaded extends Threaded implements Serializable{

	private static final long serialVersionUID = -8987853647475963356L;

	//constructor accessing Threaded using super
	public InnerThreaded(String diamAndThrd, String mat, String fin, double price, int units) throws IllegalFastener {
		super(diamAndThrd, mat, fin, price, units);
	}

}