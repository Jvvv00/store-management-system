
public class Mice extends Product{

	private int size;
	private String connectivity, scroll;
	
	//parameterized constructor 
	public Mice(int pNum, String pName, String pManuf, int qAvailable, 
			double price, int size, String connectivity, String scroll) {
		super(pNum, pName, pManuf, qAvailable, price);
		this.size = size;
		this.connectivity = connectivity;
		this.scroll = scroll;
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	public String getScroll() {
		return scroll;
	}

	public void setScroll(String scroll) {
		this.scroll = scroll;
	}
	
	@Override //calculate inventory value
	public double calInValue() {
		double value = super.getPrice() * super.getqAvailable();
		return value;
		
	}
	
	@Override //calculate inventory value
	public String toString() {
		
		System.out.println(super.toString()); //calling superclass toString 
		
		StringBuilder str = new StringBuilder();
		
		str.append("Connectivity: " + connectivity);
		str.append("\nSize: " + size);
		str.append("\nScroll Type: " + scroll);
		
		return str.toString();
	}



}
