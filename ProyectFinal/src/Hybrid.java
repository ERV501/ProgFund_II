
public class Hybrid extends Vehicles {				// We establish at the start that the class "Hybrid" is a child class of the class  "Vehicles".

	private boolean gear;							// We name the variables that belong to this class
	private int hours;

	
	  //------------//
 	 // Constructor//
	//------------//
	
//It's the heritage from the class "Vehicles". //
	
	public Hybrid(char type, String carRegistration, int mileages, int price, int hours, String model, boolean gear) {
		super(type, carRegistration, mileages, price, model);
		this.gear = gear;																// We use again the "this." to avoid any conflicts.
		this.hours = hours;
	}

	
	  //---------------------//
     // Getters and Setters //
	//---------------------//
	
	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public boolean isGear() {
		return gear;
	}

	public void setGear(boolean gear) {
		this.gear = gear;
	}

	
	  //---------//
	 // Methods //
	//---------//
	
	@Override
	public String toString() {
		return super.toString() + " gear=" + gear + ", hours=" + hours;
	}

	
}