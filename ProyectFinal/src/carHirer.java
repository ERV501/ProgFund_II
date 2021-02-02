import java.io.File;
import java.io.IOException;
import java.util.*;

public class carHirer {
	
	  //------------//
	 // Attributes //
	//------------//
	
	private Vehicles[] vehicleArray;             // Array of all the vehicles.
	private Customer[] customerArray; 			 // Array of all the customers.
	private int numberVehicle = 0;			     // We initialized the variables.
	private int numberCustomer = 0;

	
	
	  //------------//
 	 // Constructor//
	//------------//
	
	public carHirer() {
		vehicleArray=new Vehicles[25];			// We establish the length of the Vehicles array.
		customerArray=new Customer[25];			// We establish a length to the Customers array.
		readFiles();						// Here we call the method "readFiles".
	}
	
	
	  //---------//
	 // Methods //
	//---------//
	
	public void readFiles() {
		Scanner sc = new Scanner(System.in);
		boolean incorrecto = false;
		String FileVehicles = "list_vehicles";
		String FileCustomer = "list_customers";												////////////////////////////////////////////////////////////////////////////////
		do {																			   ////     This method try to find the file or we can introduce the route      ///
			try {																		  //     manually if there is any exception. If everything goes right the       //
				incorrecto = false;														 ////     method will call the methods "readCustomer" and "readVehicles".    ////
				readCustomer(FileCustomer);										    	////////////////////////////////////////////////////////////////////////////////
			} catch (IOException e) {
				incorrecto = true;
				System.out.println("Introduce file route manually");
				FileCustomer = sc.next();
			}

		} while (incorrecto);

		do {
			try {
				incorrecto = false;
				readVehicles(FileVehicles);
			} catch (IOException e) {
				incorrecto = true;
				System.out.println("Introduce file route manually");
				FileVehicles = sc.next();
			}

		} while (incorrecto);
	}
	
	
	public Customer selectCustomer(String dni) { 
		boolean encontrado = false;
		Customer pos = null;
		for (int i = 0; (i < customerArray.length) && (encontrado == false); i++) {				     //////////////////////////////////////////////////////////////////////////
			if (customerArray[i] != null && customerArray[i].getDni().equalsIgnoreCase(dni)) {		/// With this method we can search for a customer by knowing its DNI.  ///
				encontrado = true;																   //  Gratefully we have the "equalsIgnoreCase" condition that recognize  //
				pos = customerArray[i];															  ////   our DNI even if we write with or without capital letters.      ////
			}																					 //////////////////////////////////////////////////////////////////////////
		}

		return pos;
	}
	
																				  ///////////////////////////////////////////////////////////////////////////////
	public Customer customerGetAt(int i) {										 // We applied this method into the class "Main" calling it from here to know //
																				////          which is the position of the customer on the array.          ////
		return customerArray[i];										       ///////////////////////////////////////////////////////////////////////////////
	}

	public Vehicles[] dispVehicle() { 
		Vehicles pos = null;
		Vehicles[] auxArray= new Vehicles[vehicleArray.length];								//////////////////////////////////////////////////////////////////////
																						   //  We know if a car is free or not to hirer thanks to this method. //
		for (int i = 0, j=0; (i < vehicleArray.length); i++) {						      /// 			because it looks for its availability.               ///
			if (vehicleArray[i] != null && vehicleArray[i].getDisponibility()) {		 //////////////////////////////////////////////////////////////////////
				auxArray[j]=vehicleArray[i];
				j++;
			}
		}
		
		return auxArray;
	}

	public Vehicles selectVehicle(String carRegistration) { 
		boolean encontrado = false;
		Vehicles pos = null;
		for (int i = 0; (i < vehicleArray.length) && (encontrado == false); i++) {
			if (vehicleArray[i] != null && vehicleArray[i].getCarRegistration().equalsIgnoreCase(carRegistration)) {
				
				                                         											//////////////////////////////////////////////////////////////////
																								   /// This method search a car by its registration, only         ///
				encontrado = true;																  // among the available vehicles, but it let's us search easily  //
				pos = vehicleArray[i];															 ///       a vehicle to hire according to its car registration. ///
			}																					//////////////////////////////////////////////////////////////////
		}

		return pos;
	}
	
	public void addCustomer(Customer ncustomer) {
		if(ncustomer!=null) {
			if(numberCustomer<customerArray.length) {
				customerArray[numberCustomer]=ncustomer;
			}
			
		}
	}

	
	 //***********************//
	// Menu functionalities: //
   //***********************//
	
	// Read vehicles that are in the file
	public void readVehicles(String list_vehicles) throws IOException {
		ArrayList<Vehicles> coches = new ArrayList<Vehicles>();
		File f = new File(list_vehicles);
		Scanner data_f = new Scanner(f);
		Vehicles veh = null;																		/////////////////////////////////////////////////////////////////////////
																							       /// This method reads the different vehicles that we have in the      ///
		while (data_f.hasNext()) {																  //  file. Later it has a switch that read these vehicles according     //
			char type = data_f.next().charAt(0); 												 ///             to the type they are, classifying them.			   ///
			String carRegistration = data_f.next();												/////////////////////////////////////////////////////////////////////////
			int mileages = data_f.nextInt();
			int price = data_f.nextInt();
			String model = data_f.next();
			boolean air;
			// Read vehicles according to type;
			switch (type) {
			case 'h':
				int hours = data_f.nextInt();
				boolean gear = data_f.nextBoolean();
				veh = new Hybrid(type, carRegistration, mileages, price, hours, model, gear);
				break;
			case 'c':
			case 'm':
			case 'd':
				air = data_f.nextBoolean();
				veh = new Leftovers(type, carRegistration, mileages, price, model, air);
				break;
			}
			coches.add(veh);
		}
		data_f.close();
		vehicleArray = coches.toArray(new Vehicles[coches.size()]);
	}

	public void readCustomer(String list_customers) throws IOException {
		ArrayList<Customer> clientes = new ArrayList<Customer>();
		File f = new File(list_customers);											/////////////////////////////////////////////////////////////////////////
		Scanner data_f = new Scanner(f);										   // This method reads the customers that are in the file that was given //
		while (data_f.hasNext()) {												  //             to us with the instructions of the project.             //
			Customer customer;													 /////////////////////////////////////////////////////////////////////////
			String name = data_f.next();
			String dni = data_f.next();
			long card = data_f.nextLong();
			
			int years = data_f.nextInt();
			boolean vip = data_f.nextBoolean();
			if (vip) {
				int nc = data_f.nextInt();
				customer = new Vip(name, dni, card, years, nc, vip, nc);
			} else {
				customer = new Customer(name, dni, card, years);

			}
			clientes.add(customer);
		}
		data_f.close();
		customerArray = clientes.toArray(new Customer[clientes.size()]);
	}

	
	
	  //---------------------//
     // Getters and Setters //
	//---------------------//
	
	public int getNumberCustomer() {
		return numberCustomer;
	}
}