package y_y_p1;

public class BusinessCustomer extends Customer {
	private String companyName;
	private int discountRate;
	private double totalPurchases;
	
	public BusinessCustomer(String firstName, String lastName, String customerLevel) {
		super(firstName, lastName, customerLevel);
	}
	
	public BusinessCustomer(String firstName, String lastName, String customerLevel, String companyName, int discountRate, double totalPurchases) {
		super(firstName, lastName, customerLevel);
		this.companyName=companyName;
		this.discountRate=discountRate;
		this.totalPurchases=totalPurchases;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public int getDiscountRate() {
		return discountRate;
	}
	
	public double getTotalPurchases() {
		return totalPurchases;
	}
	
	public void setCompanyName (String companyName) {
		this.companyName=companyName;
	}
	
	public void setDiscountRate(int discountRate) {
		this.discountRate=discountRate;
	}
	
	public void setTotalPurchases(double totalPurchases) {
		this.totalPurchases=totalPurchases;
	}

	@Override
	public double incentives() {
		return totalPurchases*(discountRate/100.0);
	}

	public String toString() {
		String display = String.format("%s\r\nBusiness Customer for %s\r\nTotal Purchases:    $%,.2f\r\nDiscount Rate:      %d%%\r\nDiscount Incentive: $%,.2f\r\nNet Purchases:      $%,.2f",super.toString(),companyName,totalPurchases,discountRate, incentives(), (totalPurchases - incentives()));
		return display;
	} 
}
