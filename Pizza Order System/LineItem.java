
public class LineItem implements java.io.Serializable,Comparable<LineItem> {
	/**
	 * @param pizza	    	the object pizza
	 * @param numPizza	    the number of pizzas
	 * 
	 * @author Darko Stanisic
	 */
	private static final long serialVersionUID = 1L;
	
	private final Pizza pizza;
	private int numPizza;
/**
 * Check to see if illegal pizza is created
 * @param numPiz
 * @param piz
 * @throws IllegalPizza
 */
	public LineItem(int numPiz,Pizza piz) throws IllegalPizza {
		if(piz == null)
			throw new IllegalPizza("You cannot order that type of pizza.");
		pizza = piz;
		if (numPiz >= 1 && numPiz <= 100)
			numPizza = numPiz;
		else
			throw new IllegalPizza("You cannnot order that many pizzas.");
	}
	//default constructor
	/**
	 * Checks to see if a null pizza is created which is not allowed 
	 * 
	 * @param piz
	 * @throws IllegalPizza
	 */
	public LineItem(Pizza piz) throws IllegalPizza {
		if (piz == null)
			throw new IllegalPizza("That is not a pizza you can order.");
		pizza = piz;
		numPizza = 1;
	}
	/**
	 * Accessor that gets the Pizza
	 * 
	 * @return pizza	the object
	 */
	public Pizza getPizza() {
		return pizza;
	}
	/**
	 * Accessor that gets the number
	 * 
	 * @return numpizza	the number of pizzas
	 */
	public int getNumber() {
		return numPizza;
	}
	/**
	 * Checks to see the number of pizzas ordered and if not allowed
	 * 
	 * @param num
	 * @throws IllegalPizza
	 */
	public void setNumber(int num) throws IllegalPizza {
		if (num >= 1 && num <= 100)
			numPizza = num;
		else
			throw new IllegalPizza("You cannot order that many pizzas.");
		return;
	}
	/**Gets the cost of the pizza based on the cost model given
	 * 
	 * @return
	 */
	public double getCost() {
		double cost = pizza.getCost()*numPizza;
		if (numPizza >= 10 && numPizza <= 20)
			cost = cost*0.95;
		if (numPizza > 20)
			cost = cost*0.90;
		cost = (double) Math.round(cost*1000)/1000;
		return cost;
	}
	/**
	 * Overrides toString 
	 * 
	 * @return orderString
	 */
	@Override
	public String toString() {
		String orderString = null;
		if (numPizza<10)
			orderString = " " + numPizza + " " + pizza.toString();
		else
			orderString = numPizza + " " + pizza.toString();
		return orderString;
	}
	/**Compares the price of the pizza
	 * 
	 * @param order The order that is being made 
	 * @return costDiff		the difference in cost
	 */
	public int compareTo(LineItem order) {
		double costDiff = order.getCost() - this.getCost();
		if (Math.abs(costDiff) < 1)
			return 0;
		return (int) costDiff;
	}
}
