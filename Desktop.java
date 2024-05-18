
public class Desktop extends Product{
	
	private String category, processor, storageType, formFactor;
	private int ram, storage;
	private double screenSize;
	
	//parameterized constructor 
	public Desktop(int pNum, String pName, String pManuf, int qAvailable, 
			double price, String category, String processor, int ram, int storage, 
			String storageType, double screenSize, String formFactor) {
		super(pNum, pName, pManuf, qAvailable, price);
		this.category = category;
		this.processor = processor;
		this.ram = ram;
		this.storage = storage;
		this.storageType = storageType;
		this.screenSize = screenSize;
		this.formFactor = formFactor;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
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

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	
	@Override //calculate inventory value, override the abstract method in superclass
	public double calInValue() {
		double value = 1.1 * (super.getPrice() * super.getqAvailable());
		return value;
		
	}

	@Override
	public String toString() {
		
		System.out.println(super.toString()); //calling superclass toString
		
		StringBuilder str = new StringBuilder();
		str.append("Category: " + category);
		str.append("\nProcessor: " + processor);
		str.append("\nMemory (RAM): " + ram);
		str.append("\nStorage Size: " + storage);
		str.append("\nStorage Type: " + storageType);
		str.append("\nScreen Size: " + screenSize);
		str.append("\nForm Factor: " + formFactor);
		
		return str.toString();
		
		}
		
}
