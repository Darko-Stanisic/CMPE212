public class Pizza implements java.io.Serializable {
	/**
	 * This class is used for the constructors, as well as to override equal, clone and toString
	 * 
	 * @param size		The size of the pizza
	 * @param cheese	The amount of cheese on the pizza
	 * @param pineapple Whethere there is pineapple on the pizza
	 * @param greenPepper Whether there are greenpeppers on the pizza
	 * @param ham		Whether there is ham on the pizza
	 * @param cost		The cost of the pizza, a double to represents cents as well
	 * @throws Illegal Pizza
	 * 
	 *  @author Darko Stanisic
	 */
	private static final long serialVersionUID=1L;
	
	LegalPizzaChoices.Size size;
	LegalPizzaChoices.Cheese cheese;
	LegalPizzaChoices.Topping pineapple;
	LegalPizzaChoices.Topping greenPepper;
	LegalPizzaChoices.Topping ham;
	public double cost;
	
	public Pizza(LegalPizzaChoices.Size sz,
	LegalPizzaChoices.Cheese chz,
	LegalPizzaChoices.Topping pine,
	LegalPizzaChoices.Topping gp,
	LegalPizzaChoices.Topping h) throws IllegalPizza{
		if(chz==null || pine==null || sz==null || gp==null || h==null) throw new IllegalPizza("You cannot order that type of pizza.");
		if((pine == LegalPizzaChoices.Topping.Single || gp == LegalPizzaChoices.Topping.Single) && h == LegalPizzaChoices.Topping.None)
			throw new IllegalPizza("You cannot order that type of pizza.");
		else {
				size = sz;
				cheese = chz;
				pineapple = pine;
				greenPepper = gp;
				ham = h;
				cost = getCost();
			}
		} //end of constructor
/**
 * The default pizza order small pizza with single cheese
 */
	public Pizza() {								//default constructor
		size = LegalPizzaChoices.Size.Small;
		cheese = LegalPizzaChoices.Cheese.Single;
		pineapple = LegalPizzaChoices.Topping.None;
		greenPepper = LegalPizzaChoices.Topping.None;
		ham = LegalPizzaChoices.Topping.Single;
		cost = 8.50;
	}//end of default constructor
/**
 * Accessor that figures out the cost of the pizza ordered
 * @return cost
 */
	public double getCost() {
		if(size == LegalPizzaChoices.Size.Small)
			cost=7.00;
		else if(size == LegalPizzaChoices.Size.Medium)
			cost=9.00;
		else 						//size == LegalPizzaChoices.Size.Large
			cost=11.00;
		if(cheese == LegalPizzaChoices.Cheese.Double)
			cost+=1.50;
		else if(cheese == LegalPizzaChoices.Cheese.Triple)
			cost+=3.00;
		if(pineapple == LegalPizzaChoices.Topping.Single)
			cost+=1.50;
		if(greenPepper == LegalPizzaChoices.Topping.Single)
			cost+=1.50;
		if(ham == LegalPizzaChoices.Topping.Single)
			cost+=1.50;	
	return cost;
}
/**
 * creates the string of what pizza is ordered
 * @return pizzaString	the string that is returned with what has been ordered
 */
@Override
public String toString() {
	String pizzaString = size + " pizza, " + cheese + " cheese";
	if (!(pineapple.equals(LegalPizzaChoices.Topping.Single) || greenPepper.equals(LegalPizzaChoices.Topping.Single) || ham.equals(LegalPizzaChoices.Topping.Single)))
		pizzaString += ".";
	else
		pizzaString += ",";
	if(pineapple.equals(LegalPizzaChoices.Topping.Single)) {
		pizzaString += " pineapple";
		if (greenPepper.equals(LegalPizzaChoices.Topping.None) && ham.equals(LegalPizzaChoices.Topping.None))
			pizzaString += ".";
		else
			pizzaString += ",";
	}
	if(greenPepper.equals(LegalPizzaChoices.Topping.Single)) {
		pizzaString += " green pepper";
		if(ham.equals(LegalPizzaChoices.Topping.None))
			pizzaString += ".";
		else
			pizzaString += ",";
	}
	if(ham.equals(LegalPizzaChoices.Topping.Single))
		pizzaString += " ham.";
	pizzaString += " Cost: $" + String.format("%.2f", cost) + " each.";
	return pizzaString;
}
/**
 * checks to see if equal
 * 
 * @param pizza	 the pizza object given
 * @return boolean depending on if it is equal or not
 */
@Override
public boolean equals(Object pizza) {
	if (!(pizza instanceof Pizza))
		return false;
	Pizza compPiz = (Pizza) pizza;
	if (this.size.equals(compPiz.size) && this.cheese.equals(compPiz.cheese) && 
			this.pineapple.equals(compPiz.pineapple) && this.greenPepper.equals(compPiz.greenPepper) 
			&& this.ham.equals(compPiz.ham)) {
		return true;
	}
	else 
		return false;
}
/**
 * creates clone
 * 
 * @return pizzaClone a clone of the pizza
 */
@Override
public Pizza clone() {
	Pizza pizzaClone = null;
	try {
		pizzaClone = new Pizza(this.size,this.cheese,this.pineapple,this.greenPepper,this.ham);
	} catch (IllegalPizza e) {
		System.out.println(e.getMessage());
		System.exit(0);
	}
	return pizzaClone;	
}
}
	