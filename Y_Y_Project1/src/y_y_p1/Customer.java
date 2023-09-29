package y_y_p1;
import java.util.Random;
import java.lang.String;
public abstract class Customer {
	private String firstName;
	private String lastName;
	private String customerId;
	private String customerLevel;
	
	public Customer(String FirstName, String LastName, String CustomerLevel){
		this.firstName = FirstName;
		this.lastName = LastName;
		this.customerLevel = CustomerLevel;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public String getCustomerLevel() {
		return customerLevel;
	}
	
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	
	void setCustomerId() {
		Random rand = new Random();
		int ceiling = 10;
		int n1 = rand.nextInt(ceiling);
		int n2 = rand.nextInt(ceiling);
		int n3 = rand.nextInt(ceiling);
		int n4 = rand.nextInt(ceiling);
		int n5 = rand.nextInt(ceiling);
		String ln ="";
		if(this.lastName.length()<4) {
			ln = this.lastName.toUpperCase();
			int loopCount = 4-this.lastName.length();
			for(int i=0;i<loopCount;i++) {
				ln=ln+"X";
			}
		} else {
			ln = this.lastName.substring(0, 4).toUpperCase();
		}
		this.customerId = ln+"-"+n1+n2+n3+n4+n5;
	}
	
	private void setCustomerLevel (String customerLevel) {
		this.customerLevel = customerLevel;
	}
	
	public abstract double incentives();
	
	public String toString() {
		String display = String.format("%s, %s %s",customerId,firstName,lastName);
		return display;
	} 
}
