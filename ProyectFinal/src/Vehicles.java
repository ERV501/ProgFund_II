
public class Vehicles {

	  //------------//
  	 // Attributes //
	//------------//
// We indicated all the variables that will be useful in the class. //
	
	protected char type;
	protected String carRegistration;
	protected int mileages;
	protected int price;
	protected String model;
	protected boolean disponibility;
	
	
	  //-------------//
 	 // Constructor //
	//-------------//
		
	public Vehicles(char type,String carRegistration,int mileages,int price,String model) {
			this.type=type;																		// Again, we resort to the word "this." to avoid conflicts among variables.
			this.carRegistration=carRegistration;
			this.mileages=mileages;
			this.price=price;
			this.model=model;
			this.disponibility=true;
		}
		
	
	
	
	
	  //---------------------//
     // Getters and Setters //
	//---------------------//
	
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public String getCarRegistration() {
		return carRegistration;
	}
	public void setCarRegistration(String carRegistration) {
		this.carRegistration = carRegistration;
	}
	public int getMileages() {
		return mileages;
	}
	public void setMileages(int mileages) {
		this.mileages = mileages;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public boolean getDisponibility() {
		return disponibility;
	}
	public void setDisponibility(boolean disponibility) {
		this.disponibility = disponibility;
	}

	
      //---------//
	 // Methods //
	//---------//
	
	@Override
	public String toString() {
		return "type=" + type + ", carRegistration=" + carRegistration + ", mileages=" + mileages + ", price="
				+ price + ", model=" + model + ", disponibility=" + disponibility + " ";
	}
	
	
	
	
	
	
	
}