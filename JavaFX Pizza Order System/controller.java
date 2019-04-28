//Name: Darko Stanisic 				StudentID:20074106
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 
public class controller {
	
	public String sizeofPizza = null;
	public String toppingchoice = null;
	public String cheeseChoice = null;
	public int quant= 0;			//quantity of pizzas
	public float totalCost = 0;		//totalCost of full order once submitted
	
	@FXML
	private ImageView pizzaimage;
	
	@FXML
	private RadioButton small;
	
	@FXML
	private RadioButton medium;
	
	@FXML
	private RadioButton large;
	
	@FXML
	private ChoiceBox<String> cheeseOptions = new ChoiceBox<>();
	private ObservableList<String> cheeseBox = FXCollections.observableArrayList("Single","Double","Triple");
	
	@FXML 
	private Spinner<Integer> quantitychoice;
	
	@FXML
	private Button order;
	
	@FXML
	private Button submitOrder;
	
	@FXML
	private TextArea summary;
	
	@FXML
	private TextArea display;
	
	@FXML
	private ToggleGroup radioToggle;
	
	@FXML
	private CheckBox ham;
	
	@FXML
	private CheckBox pineapple;
	
	@FXML
	private CheckBox greenPepper;
	
	@FXML
	public void initialize() {
		summary.setEditable(false);					//Cannot edit summary text area
		display.setEditable(false);					//Cannot edit display text area
		cheeseOptions.setItems(cheeseBox);
		quantitychoice.valueProperty().addListener((observableValue, oldVal, newVal) ->
    	{											//when quantity spinner changes, update the display (which shows cost)
    		final float cost = gettingthecost();
    		display.setText(String.format( "$%.2f", cost));
    	});
		cheeseOptions.valueProperty().addListener((observableValue, oldVal, newVal) ->
    	{											//when cheese options changes, update the display (which shows cost)
    		final float cost = gettingthecost();
    		display.setText(String.format( "$%.2f", cost));
    	});
	}

@FXML 
private void handleDisplayButtonAction(ActionEvent event) {
	if(!(ham.isSelected())) {					//if ham is not selected, you cannot get pineapple or greenPepper
		pineapple.setSelected(false);
		greenPepper.setSelected(false);
	}
	final float cost = gettingthecost();		//display the cost of the current pizzas being customized
display.setText(String.format( "$%.2f", cost));
}
	@FXML 
	private void handleAddtoOrderButtonAction(ActionEvent event) {
		if(!(pineapple.isSelected()) &&			
			!(greenPepper.isSelected()) &&
			!(ham.isSelected()) &&			
			!(small.isSelected()) &&
			!(medium.isSelected()) &&
			!(large.isSelected()) &&
			(cheeseOptions.getValue() == null)) {
			ham.setSelected(true);					//default constructor if no node is selected
			small.setSelected(true);
			cheeseOptions.setValue("Single");
		}
		float cost = 0;
		LineItem lineitem = createpizza();
		cost = gettingthecost();
		summary.appendText(String.format( lineitem + "\n" + "Cost of these Pizzas: $%.2f" + "\n", cost));
		totalCost = totalCost + cost;
		
		pineapple.setSelected(false);
		greenPepper.setSelected(false);
		ham.setSelected(false);
		small.setSelected(false);
		medium.setSelected(false);
		large.setSelected(false);
		cheeseOptions.setValue(null);
		quantitychoice.getValueFactory().setValue(1);
		display.setText("");						//reset all the nodes once a pizza is added to ordered
	}
	
	public LineItem createpizza() {
		Pizza pizza1 = null;
		LineItem lineitem = null;
		quant=quantitychoice.getValue();			//quantity of pizzas chosen 
		try {
			pizza1 = new Pizza(getSize(), getCheese(), getToppings(pineapple), getToppings(greenPepper), getToppings(ham));
		} catch (IllegalPizza ip) {
			System.out.println(ip.getMessage());
		}
		try{
			lineitem = new LineItem(quant,pizza1);
		} catch (IllegalPizza ip) {
			System.out.println(ip.getMessage());
		}
		return lineitem;
	}
	
	private float gettingthecost() {
		float cost = 0;
		LineItem lineitem = createpizza();
		cost = lineitem.getCost();
		return cost;
	}
	
	public String getToppings(CheckBox topping){
		if(topping.isSelected())
			toppingchoice = "Single";
		else 
			toppingchoice = "None";
	return toppingchoice;
	}
	
	@FXML 
	public String getCheese() {
		if( cheeseOptions.getValue() !=null) {
			cheeseChoice=cheeseOptions.getValue();
		}
		else						
			cheeseChoice= "Single";		//if no cheese is selected, put "Single" cheese as default
		return cheeseChoice;
	}
	
	@FXML
	public String getSize() {
		if(medium.isSelected()) {
			sizeofPizza = "Medium";
		}
		else if(large.isSelected()) {
			sizeofPizza = "Large";
		}
		else {							//default if no size is selected is a small Pizza
			sizeofPizza = "Small";
		}
		return sizeofPizza;	
	}
	
	@FXML 
	public void submitOrderAction(ActionEvent event) {
		if(totalCost==0) {				//if no pizzas were selected, you cannot submit the order
			JOptionPane.showMessageDialog(null, String.format( "No Pizzas Selected") );
		}
		else
		JOptionPane.showMessageDialog(null, String.format( "Total Order Cost is: $%.2f" + "\n", totalCost) );
	}

}
