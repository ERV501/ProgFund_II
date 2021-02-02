import java.io.*;																	// We import all the libraries that will be needed to implement into the class.
import java.util.*;
import java.util.Scanner;

public class G2_RodriguezGarcia {
	
	
	  //------------//
	 // Attributes //
	//------------//
	
	static Scanner in = new Scanner(System.in);
	

	public static void main(String[] args) {
	

		carHirer ncarHirer = new carHirer();
		
																			 /////////////////////////////////////////////////////////////////////////////
		in.useDelimiter("\r\n");											// We invoke the method "useDelimeter" to print the information in another //
																		   //                    line when we write "/n" or "/r". 					  //
		int option = -1;												  /////////////////////////////////////////////////////////////////////////////
		do {
			try {

				System.out.println("\n Select an option: ");
				System.out.println("Option 1: Available for hire vehicles ");
				System.out.println("Option 2: Make a request ");
				System.out.println("Option 3: Vehicles hired ");
				System.out.println("Option 4: Request info ");
				System.out.println("Option 5: VIP status ");
				System.out.println("Option 6: Discounts ");
				System.out.println("Option 7: Create client");
				System.out.println("Option 0: Exit");
				option = in.nextInt();
				chooseOption(option, 0, 7); 									// Call the method to choose an option. //
				
				menu(option, ncarHirer);										// Call the method "menu". //
			
			} catch (InputMismatchException excepcion) {		   	// In this case an exception is run to print "Introduce a valid option" if the introduce token is not valid. //
																	// For example, is an "@". //
				System.out.println("Introduce a valid option");
				in.next();
			} catch (Exception e) {									// Throws another exception that show us a message of the exception e. //
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

		} while (option != 0);										// This do is repeated until we write the token "0", then we left from the program. //
	}
	
	
	 //---------//
	// Methods //
   //---------//

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void chooseOption(int option, int min, int max) throws Exception {

		if (option < min || option > max) {													////////////////////////////////////////////////////////////////////////////////
			throw new Exception("The option is not valid");								   // The message which is shown to us into the Exception e is this. It happens  //
																						  //  when we introduce a number which is not valid. Thanks to this method.		//				
		}																				 ////////////////////////////////////////////////////////////////////////////////

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}

	private static void menu(int option, carHirer ncarHirer) throws Exception {

		Customer customer;
		String dni;
		String carRegistration;
		Vehicles nvehicle;
		
		switch (option) {
		case 1:
			System.out.println("Available for hire vehicles ");				 /////////////////////////////////////////////////////////////////////////////////////
			Vehicles[] arrayVehicles = ncarHirer.dispVehicle();				// With this method we are able to see all the vehicles that we can hire with also // 
			for (int i = 0; i < arrayVehicles.length; i++) {			   //                     all its information that its in the files.                  //
				if (arrayVehicles[i] != null) {							  /////////////////////////////////////////////////////////////////////////////////////
					System.out.println(arrayVehicles[i]);
				}
			}

			
			break;

		case 2:
			System.out.println("Insert car registration");
			carRegistration = in.next();
			nvehicle=ncarHirer.selectVehicle(carRegistration);						     //..........................................................................................//
			int time;																    // This case allows us to make a request for hire a car. First of all it demands us to      //
			if(nvehicle==null) {													   // write the vehicle registration, we introduce it and it calls "seletcVehicle" method      //
				System.out.println("The vehicle doesn't exist");					  // which searches into the file of Vehicles to see if the vehicle exist or not. Then, if    //
																					 // the vehicle doesn't exist it returns us this message.  We use "getDisponibility" method, //
			}else if(!nvehicle.getDisponibility()) {								// if the vehicle exists, and if it can be hired. If we can hired it we have to register or //
				System.out.println("This vehicle is already hired");			   //	            log in, but if it can't be hired we receive a message...      			   //
			}else {																  //..........................................................................................//
				System.out.println(" /1 register new\n /2 log in");
				int select;
				select=in.nextInt();

				if(select==1) {
					customer=addCustomer(ncarHirer);				 		     //................................................................................................//
																	 		    // Well, if we can hire the vehicle we have to register or log in. In order to this we have an    //
				}else {													       // "if" in where, if we have to register we call the method "addCustomer" to create a new client. //
					for(int i=0;i< ncarHirer.getNumberCustomer();i++) {	  	  // And if we log in we call the getter "getNumberCustomer" and the methods "customerGetAt" and    //
						customer=ncarHirer.customerGetAt(i);			     // "selectCustomer" looking for it by its DNI. And, at the end we have to say how many days we    //
						if(customer!=null) {							    // are going to hire the car. Then we call the method "makeRequest" which will allows us to       //
							System.out.println(customer);		  	   	   //                                     complete our request.                                      //
						}												  //................................................................................................//
					}
					System.out.println("Write customer's DNI");
					dni=in.next();
					customer=ncarHirer.selectCustomer(dni);
					
					
				}
				
				System.out.println("Time for hire (days)");
				time=in.nextInt();
				customer.makeRequest(time,nvehicle);
				System.out.println("Operation completed, thank you for your purchase");
			}
			
			break;

		case 3:
			System.out.println("Insert dni");										//.......................................................................................//
			dni = in.next();													   //      This case allows us to see how many vehicles has been hired by a specific        //
			customer = ncarHirer.selectCustomer(dni);							  // customer selecting the customer by "selectCustomer" method and getting its number of  //
			if (customer != null) {												 //        request thanks to "getNumberRequest" getter. Showing us that information.      //
				System.out.println(customer.getNumberRequest());				//.......................................................................................//
			}
			break;

		case 4:
			System.out.println("Insert dni");
			dni = in.next();														//........................................................................................//
			customer = ncarHirer.selectCustomer(dni);							   // In this case we can see all the information of the request performed by a specific     //
			if (customer != null) {												  // customer. We use again "selectCustomer" to get its identity and then we use the getter //
				Request[] request=customer.getRequestArray();					 // "getRequestArray" in order to get all the information concerning to the request.	   //
				for(int i=0;i<request.length;i++) {								//........................................................................................//
					if(request[i]!=null) {
					System.out.println(request[i]);
				}
			}
			}
			break;

		case 5:
			System.out.println("Insert dni");												//........................................................................................//
			dni = in.next();													   // This case tells us if a customer is VIP or not by searching its information by         //
			customer = ncarHirer.selectCustomer(dni);							  //  its DNI. Then, prints the information depending on which is the client's information. //
			if (customer != null && customer instanceof Vip) {					 //........................................................................................//
				System.out.println("Your current status is Vip");
			}else {
				System.out.println("Your current status is not Vip");
			}
			break;
		case 6:
			System.out.println("Insert dni");												//.......................................................................................//
			dni = in.next();													   // In this case we select a customer by its DNI and then we see the discounts that will  //
			customer = ncarHirer.selectCustomer(dni);							  //   be implement to the hire of the car because of the attributes of the customer.      //
			if (customer != null) {												 //.......................................................................................//
				System.out.println(customer.makeDiscount() * 100 + "%");

			}
			break;
			
		case 7:																	//.....................................................................................//
																			   // In this case we call the method "addCustomer" whose function we will comment later. //
			addCustomer(ncarHirer);											  //.....................................................................................//
			break;
																			 //...............................................................................................//	
		case 0:																// It's the case in which we left the program we let it empty because in the do/while we already //
																		   //                mark the "0" as the exit of the loop, so the menu and the program.             //
			break;														  //...............................................................................................//

		}
	}

	public static Customer addCustomer(carHirer ncarHirer) throws Exception {
		Customer ncustomer = null;
		System.out.println("Are you vip? True/False");							  ////////////////////////////////////////////////////////////////////////////////////////////////////
		boolean vip = in.nextBoolean();											 /// With this method we are allowed to create a new client which would let us to hire a vehicle   //
		System.out.println("Introduce your name");								//    We introduce all the information that is demand and if the DNI is already registered it     //
		String name = in.next();											   //   doesn't allow us to create the client. Then we call the method "validateDNI" in order to     //
		System.out.println("Introduce your dni");							  /// verify it. Then we introduce the rest of the information and we have an "if" where, if we    ///
		String dni = in.next();												 // are VIP clients we have to introduce more data, but if we aren't the client will be created as //		
		Customer naux = ncarHirer.selectCustomer(dni);						// a new "Customer", but if we are VIP we created a new "Vip" which is an especial customer.      //
		if(naux!=null) {												   ////////////////////////////////////////////////////////////////////////////////////////////////////
			throw new Exception("Customer already exists");
		}
		
		
		
		
		validateDNI(dni);
		System.out.println("Introduce your card");
		long card = in.nextLong();
		System.out.println("Introduce your driving licence years");
		int years = in.nextInt();
		if (vip) {
			System.out.println("Please, introduce your Vip card");
			int cardVip = in.nextInt();
			System.out.println("Please, introduce your Vip number");
			int num = in.nextInt();
			ncustomer = new Vip(name, dni, card, years, cardVip, vip, num);

		} else {
			ncustomer = new Customer(name, dni, card, years);
		}
		/*
		 * Customer[] customerArray = new Customer[this.customerArray.length + 1]; int
		 * i; for (i = 0; i < this.customerArray.length; i++) customerArray[i] =
		 * this.customerArray[i]; customerArray[i] = ncustomer; this.customerArray =
		 * customerArray;
		 */
		ncarHirer.addCustomer(ncustomer);
		return ncustomer;										// In both cases the method returns a new customer "ncustomer". //

	}

	public static void validateDNI(String dni) throws Exception{
																												////////////////////////////////////////////////////////////////////
		if( !dni.toUpperCase().matches("^[0-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$")) {	   	   // This method as its name said validate the DNI introduced       //
			throw new Exception("Your DNI is not valid");													  // into the console and in case it doesn't match, it will return  //
		}																									 // the message of exception. The method "toUpperCase" that we use //
																											// converts all the alphabetic characters in the string "dni"     //
																										   //				      to capital letters.                        //
	}																									  ////////////////////////////////////////////////////////////////////

}
