
public class Laptop extends Product{
	private String color, processor;
	private double screenSize;
	private int ram, storage;
	
	//Parameterized constructor 
	public Laptop(int pNum, String pName, String pManuf, int qAvailable, 
			double price, String color, String processor, double screenSize, int ram, int storage) {
		super(pNum, pName, pManuf, qAvailable, price); //calling superclass constructor
		this.color = color;
		this.processor = processor;
		this.screenSize = screenSize;
		this.ram = ram;
		this.storage = storage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}
	
	@Override //calculate inventory value
	public double calInValue() {
		double value = 1.1 * (super.getPrice() * super.getqAvailable());
		return value;
		
	}
	
	@Override 
	public String toString() {
		
		System.out.println(super.toString()); //calling superclass toString 
		
		StringBuilder str = new StringBuilder();
		str.append("Color: " + color);
		str.append("\nScreen Size: " + screenSize);
		str.append("\nMemory (RAM): " + ram);
		str.append("\nStorage Size: " + storage);
		
		return str.toString();
	}

}
