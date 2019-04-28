/*
 * First class in the hierarchy and the most general class
Darko Stanisic - 20074106
 */

import java.io.Serializable;

public abstract class Fastener implements Serializable{

	private static final long serialVersionUID = 1167878093479806017L;
	private String[] materialsList = {"Brass", "Stainless Steel", "Steel"};
	private String material;
	private String[] finishList = {"Plain", "Chrome", "Yellow Zinc", "Zinc", "Bright", 
				"Hot Dipped Galvanized", "Black Phosphate", "ACQ 1000 Hour", "Lubricated"};
	private String finish;
	private double unitPrice;
	private int numberOfUnits;
	
	//constructor for Fastener
	public Fastener(String mat, String fin, double price, int units) throws IllegalFastener {
		if(!(mat instanceof String) || !(fin instanceof String)) //checks if the inputs are null.
			throw new IllegalFastener("Material and Finish cannot be null.");
		setFinishMaterial(fin, mat);
		setUnitPrice(price);
		setNumberOfUnits(units);		
	}
		
	
	private void setNumberOfUnits(int units) throws IllegalFastener{	//sets the number of units for the fastener
		if(units < 1 || units > 10000 || (units != 1 && units % 5 != 0))//checks given conditions
			throw new IllegalFastener("This is an invalid number of Units.");
		numberOfUnits = units;
	}//end setNumberOfUnits

	private void setUnitPrice(double price) throws IllegalFastener {	//sets the unit price for the fastener
		if(price < 0) //only restriction is that must be greater than 0.
			throw new IllegalFastener("This is an invalid price.");
		unitPrice = price;
	}//end setUnitPrice

	private void setFinishMaterial(String fin, String mat) throws IllegalFastener {	//sets finish and material type for fastener
		if((illegalEntry(fin, finishList) || illegalEntry(mat, materialsList)) || //checks if mat and fin are in their respective lists
		((mat.equals(materialsList[0]) || mat.equals(materialsList[1])) && !(fin.equals(finishList[0]))) || //if its Brass or Stainless Steel, must be plain finish
		((fin.equals(finishList[6]) || fin.equals(finishList[7]) || fin.equals(finishList[8])) && !(mat.equals(materialsList[2])))) //only allows Steel finishes if material is Steel
			throw new IllegalFastener("This is an invalid fastener.");
		finish = fin;
		material = mat;
	}//end setFinish

	public boolean illegalEntry(String entry, String[] list) {	//Checks if the entry is in the list of entries and returns false if it is for Strings.
		int length = list.length;
		boolean isInvalid = true;
		for(int i=0; i<length; i++) {
			if(list[i]==entry) {
				isInvalid=false;
			}
		}
		return isInvalid;
	}//end illegalEntry
	
	public boolean illegalEntry(double entry, double[] list) {	//Checks if the entry is in the list of entries and returns false if it is for double.
		int length = list.length;
		boolean isLegal = true;
		for(int i=0; i<length; i++) {
			if(list[i]==entry) {
				isLegal=false;
			}
		}
		return isLegal;	
	}//end illegalEntry
	
	//abstract getOrderCost method
	public abstract double getOrderCost(int units);
	
	@Override
	public String toString() {
		return material + ", with a " + finish + " finish. " + numberOfUnits + " in a unit, $" + unitPrice + " per unit.";
	}
	
}