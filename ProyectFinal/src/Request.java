
public class Request {
	
	private int time;
	private Vehicles vehiclesReq;


	//Getters and Setters
	
	public Request(int time, Vehicles vehiclesReq ) {
		this.time=time;
		this.vehiclesReq=vehiclesReq;
	}
	
	public String infoVehicle () { //The info about the vehicle
		String message = "Vehicle type:" + vehiclesReq.getType() + "Car registration" + vehiclesReq.carRegistration + "Price" + vehiclesReq.price + "Mileages"+ vehiclesReq.mileages +"model"+vehiclesReq.model;
		return message;
	}
	public String toString () { //Prints request
		String message = "Hired time:" + time + "Vehicle"+ vehiclesReq.toString();
		return message;
	}
	
	
	//Methods
	public Vehicles getVehicle() {
	return vehiclesReq;
	}
	
	
	
}
