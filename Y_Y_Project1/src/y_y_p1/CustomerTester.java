package y_y_p1;

public class CustomerTester {

	public static void main(String[] args) {
		
		System.out.print("Welcome to the Customer tester!\r\n--------------------------------------------------------------------------------------------\r\n");
		System.out.print("This program will instantiate objects of the Customer hierarchy and test their methods.\r\n");
		System.out.print("--------------------------------------------------------------------------------------------\r\n");
		
		//1
		Customer[] customers = new Customer[3];
		
		//2, 3
		customers[0] = new BusinessCustomer("Mike","Holmes","1","Home Depot",10, 3105.50);
		
		customers[1] = new RetailCustomer("Dev","Gelda","3", 11200.00);
		
		customers[2] = new PreferredCustomer("Wei","Ping","1", 6456.85, 5);
		
		//4
		for(int i=0;i<customers.length;i++) {
			customers[i].setCustomerId();
			System.out.println("\r\n"+customers[i].toString());
		}
		
		//5
		for (int i=0;i<customers.length;i++) {
			System.out.printf("\r\n%s %s earns a discount incentive of $%,.2f",customers[i].getFirstName(),customers[i].getLastName(),customers[i].incentives());
		}
		
		System.out.println("");
		
		//6, 7
		BusinessCustomer c1 = new BusinessCustomer("Tristan","Lee","4","Starbucks",15,9875.25);
		c1.setCustomerId();
		System.out.println("\r\n"+c1.toString());
		
		
		RetailCustomer c2 = new RetailCustomer("Carlos","Beltran","3",3100.50);
		c2.setCustomerId();
		System.out.println("\r\n"+c2.toString());
		
		PreferredCustomer c3 = new PreferredCustomer("Arti","Patel","4",10450.00, 10);
		c3.setCustomerId();
		System.out.println("\r\n"+c3.toString());
		
		//8
		c1.setTotalPurchases(8895.00);
		c1.setDiscountRate(12);
		
		c2.setTotalPurchases(100500.00);
		
		c3.setTotalPurchases(14987.24);
		c3.setLastName("Patel-Ruhil");
		c3.setCashbackRate(13);
		
		//9
		System.out.println("\r\n"+c1.toString());
		System.out.println("\r\n"+c2.toString());
		System.out.println("\r\n"+c3.toString());
		
	}

}
