
public class Vip extends Customer{	          // We establish at the start that the class "Vip" is a child class of the class  "Customer".
	
	  //------------//
	 // Attributes //
	//------------//
	
	private int cardVip;					 // We also name the variables that will be used on the class.
	private boolean vip;
	private int num;
	
	
	
	  //------------//
  	 // Constructor//
	//------------//
	
// It's the heritage from the class "Customer". //
	
	public Vip(String name,String dni,long card,int years,int cardVip,boolean vip,int num) {
		super(name,dni,card,years);
		this.cardVip=cardVip;
		this.vip=vip;
		this.num=num;
		
	}
 

	     //---------//
		// Methods //
	   //---------//
	
	public double makeDiscount() {											   ////////////////////////////////////////////////////////////////////////
		double discount = 0.2;												  // Make discount according to Vip state and license possession years. //
		discount+=super.makeDiscount();										 //      This discount is realized only if the customer is VIP.        //
		return discount;													////////////////////////////////////////////////////////////////////////
	}	
		
		
	  //---------------------//
     // Getters and Setters //
	//---------------------//
	
	public int getCardVip() {
		return cardVip;
	}



	public void setCardVip(int cardVip) {
		this.cardVip = cardVip;
	}

}
