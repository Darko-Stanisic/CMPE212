/*Screw Class extends OuterThreaded
 * private fields include head and drive
*/
import java.io.Serializable;

public abstract class Screw extends OuterThreaded implements Serializable{

	private static final long serialVersionUID = -4416101118194048198L;
	private String[] headList = {"Bugle", "Flat", "Oval", "Pan", "Round"};
	private String head;
	private String[] driveList = {"6-Lobe", "Philips", "Slotted", "Square"};
	private String drive;
	
	// constructor accessing outerThreaded using super. 
	public Screw(double lth, String diamAndThrd, String mat, String fin, String hed, String drv, double price, int units) throws IllegalFastener {
		super(lth, diamAndThrd, mat, fin, price, units);
		setDrive(drv);
		setHead(hed);
	}

	private void setDrive(String drv) throws IllegalFastener {	//sets the drive type for the screw
			if(illegalEntry(drv, driveList)) //is drv in the list of accepted drive types
				throw new IllegalFastener("This is an invalid drive.");
			drive = drv;
		}//end setDrive
		
	private void setHead(String hd) throws IllegalFastener{		//sets the head type for the screw
		if(illegalEntry(hd, headList)) 	//is hd in the list of accepted head types
			throw new IllegalFastener("This is an invalid head.");
		head = hd;
	}//end setHead


	@Override
	public String toString() {
		return head + " head, " + drive + " drive, " + super.toString();
	}
}