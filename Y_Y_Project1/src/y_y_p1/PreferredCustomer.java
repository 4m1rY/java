package y_y_p1;

public class PreferredCustomer extends RetailCustomer {
	
	private int cashbackrate;
	
	public PreferredCustomer(String FirstName, String LastName, String CustomerLevel, double TotalPurchases, int CashBackRate) {
		super(FirstName, LastName, CustomerLevel, TotalPurchases);
		this.cashbackrate = CashBackRate;
	}
	
	public int getCashBackRate() {
		return cashbackrate;
	}
	
	public void setCashbackRate(int newCBR) {
		this.cashbackrate = newCBR;
	}
	
	public double incentives() {
		double CBR = ((double) cashbackrate/100)*super.incentives();	
		return CBR+super.incentives();
	}
	
	public String toString() {
		String display = String.format("%s, %s %s\r\nPreferred Customer\r\nTotal Purchases:    $%,.2f\r\nDiscount Rate:      %d%%\r\nDiscount Incentive: $%,.2f\r\nNet Purchases:      $%,.2f\r\nCashback Rate:      %d%%",super.getCustomerId(),super.getFirstName(),super.getLastName(), super.getTotalPurchases(), findDiscountRate(), incentives(), (super.getTotalPurchases()-incentives()), cashbackrate);
		return display;
	}
}
