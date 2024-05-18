
public abstract class Product {
	
	private int pNum, qAvailable;
	private Double price, inValue;
	private String pName, pManuf;
	private Boolean pStatus = true; //true = active
	
	//default constructor
	public Product() {
	}
	
	//parameterized constructor 
	public Product(int pNum, String pName, String pManuf, int qAvailable, double price) {
		this.pNum = pNum;
		this.pName = pName;
		this.pManuf = pManuf;
		this.qAvailable = qAvailable;
		this.price = price;
	}
	
	public int getpNum() {
		return pNum;
	}


	public void setpNum(int pNum) {
		this.pNum = pNum;
	}


	public int getqAvailable() {
		return qAvailable;
	}


	public void setqAvailable(int qAvailable) {
		this.qAvailable = qAvailable;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getInValue() {
		return inValue;
	}


	public void setInValue(Double inValue) {
		this.inValue = inValue;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpManuf() {
		return pManuf;
	}


	public void setpManuf(String pManuf) {
		this.pManuf = pManuf;
	}


	public Boolean getpStatus() {
		return pStatus;
	}


	public void setpStatus(Boolean pStatus) {
		this.pStatus = pStatus;
	}
	
	//add stock value
	public void addStock(Product p, int addNum) {
		if(p.getpStatus()== true) { //check if the status is active or discontinued 
			if (addNum == 0)
				System.out.println("No stock value is added."); 
			else
				p.setqAvailable(p.qAvailable + addNum);
		}
		else 
			System.out.println("The product is discontinued. Cannot add new stock.");
		
	}
	
	//deduct stock value
	public void deductProduct(Product p, int deNum) {
		if (deNum > p.getqAvailable()) //if the number is greater than stock value, operation failed
			System.out.println("Failed.");
		else {
			p.setqAvailable(p.qAvailable - deNum);
			System.out.println(deNum + " stock is deducted.");
			}
	}
	
	//calculate inventory value
	public abstract double calInValue(); //abstract class to be implemented in subclass 

	@Override 
	public String toString() {
		
		StringBuilder str = new StringBuilder();
		
		str.append("Item number: " + pNum);
		str.append("\nProduct name: " + pName);
		str.append("\nProduct manufacturer: " + pManuf);
		str.append("\nQuantity Available: " + qAvailable);
		str.append("\nPrice (RM): " + String.format("%,.2f", price));
		str.append("\nInventory value (RM): " + String.format("%,.2f", calInValue()));
		str.append("\nProduct status: " + pStatus);
		
		return str.toString();
	}


}
