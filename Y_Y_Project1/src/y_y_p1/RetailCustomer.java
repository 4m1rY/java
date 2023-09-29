package y_y_p1;

public class RetailCustomer extends Customer {

	private double totalPurchases;
	
	public RetailCustomer(String firstName, String lastName, String customerLevel) {
		super(firstName, lastName, customerLevel);
	}
	
	public RetailCustomer(String firstName, String lastName, String customerLevel, double totalPurchases) {
		super(firstName, lastName, customerLevel);
		this.totalPurchases=totalPurchases;
	}
	
	public double getTotalPurchases() {
		return totalPurchases;
	}
	
	public void setTotalPurchases(double totalPurchases) {
		this.totalPurchases=totalPurchases;
	}
	
	public int findDiscountRate() {
		if(totalPurchases<1000.00) {
			return 0;
		} else if (totalPurchases<5000.00) {
			return 5;
		} else if(totalPurchases<10000.00){
			return 10;
		} else {
			return 15;
		}
	}
	
	public double incentives() {
		return totalPurchases*(findDiscountRate()/100.00);
	}
	
	public String toString() {
		
		String display = String.format("%s\r\nRetail Customer\r\nTotal Purchases:    $%,.2f\r\nDiscount Rate:      %d%%\r\nDiscount Incentive: $%,.2f\r\nNet Purchases:      $%,.2f",super.toString(), totalPurchases, findDiscountRate(), incentives(), (totalPurchases-incentives()) );
		return display;
	} 
}
