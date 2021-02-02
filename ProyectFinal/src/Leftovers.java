
public class Leftovers extends Vehicles {				  // We establish at the start that the class "Leftovers" is a child class of the class  "Vehicles".
	
														
	private boolean air;                    			// We introduce the variable into it class, how it's explain to us in the project instructions,  //
													   //	because is a variable for only vehicles that are not hybrid.								//
	
	  //-------------//
	 // Constructor //
	//-------------//
	
	public Leftovers(char type, String carRegistration, int mileages, int price, String model,boolean air) {
		super(type, carRegistration, mileages, price, model);
		this.air=air;
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
	public boolean isAir() {
		return air;
	}
	public void setAir(boolean air) {
		this.air = air;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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
	
	
	     //---------//
		// Methods //
	   //---------//
	
	@Override														 ///////////////////////////////////////////////////////////////////////////////////////////////
	public String toString() {										// We used this method "toString" to print all the information about the class that we want. //
		return super.toString() +"air=" + air + " ";			   ///////////////////////////////////////////////////////////////////////////////////////////////
	}
	
}