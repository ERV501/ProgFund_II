import java.util.*;													// We import all the libraries that will be needed to implement into the class.

public class Customer {
	
	  //------------//
 	 // Attributes //
	//------------//

	protected String name;
	protected String dni;
	protected long card;
	protected int years;
	protected Request[] requestArray = new Request[25];				// Also we create an array of request so then we can make more than only one.
	protected int numberRequest = 0;								// We initialized also another variables that we will need later.
	protected int contados = 0;
	
	
	
      //------------//
   	 // Constructor//
	//------------//
	
	public Customer(String name, String dni, long card, int years) {
		this.name = name;												// In case of find another variable who has the same name we use "this." to avoid conflicts.
		this.dni = dni;
		this.card = card;
		this.years = years;
	}
	
	

	 //---------//
	// Methods //
   //---------//
	
	public String toString() {																			// We use a toString to show all the information we want.
		String message = "Name:" + name + "\n dni:" + dni + "\n card:" + card + "\n years:" + years;
		return message;
	}

	public void makeRequest(int time, Vehicles vehiclesReq) { 					  ////////////////////////////////////////////////////////////////////////////////////////
		Request request = new Request(time, vehiclesReq);			     		 // The method "makeRequest" is created to let us make a request and later assign a    //
		vehiclesReq.setDisponibility(false);									// position into the array, increasing at the end the number of requests that we have.//
		requestArray[numberRequest]=request;						   		   ////////////////////////////////////////////////////////////////////////////////////////
		numberRequest++;
	}

	public double makeDiscount() {  										 /////////////////////////////////////////////////////////////////////////////////
		double discount;													// This method applies the discount establish by the project instructions that //
		if (years > 10) {												   // will be applied to the drivers who has the car license more than 10 years.  //
			discount = 0.05;											  /////////////////////////////////////////////////////////////////////////////////
		} else {
			discount = 0;

		}
		return discount;
	}

	
	  //---------------------//
     // Getters and Setters //
	//---------------------//
	
	public Request[] getRequestArray() {										
		return requestArray;
	}

	public void setRequestArray(Request[] requestArray) {
		this.requestArray = requestArray;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public long getCard() {
		return card;
	}

	public void setCard(long card) {
		this.card = card;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
public int getNumberRequest() {
	return numberRequest;
}
}