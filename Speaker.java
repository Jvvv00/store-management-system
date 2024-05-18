
public class Speaker extends Product {
	
	private int sensitivity, impedance, power;
	private String connectionType, color;
	
	//parameterized constructor 
	public Speaker(int pNum, String pName, String pManuf, int qAvailable, 
			double price, int sensitivity, int impedance, int power, String connectionType, String color) {
		super(pNum, pName, pManuf, qAvailable, price);
		this.sensitivity = sensitivity;
		this.impedance = impedance;
		this.power = power;
		this.connectionType = connectionType;
		this.color = color;
	}

	public int getSensitivity() {
		return sensitivity;
	}

	public void setSensitivity(int sensitivity) {
		this.sensitivity = sensitivity;
	}

	public int getImpedance() {
		return impedance;
	}

	public void setImpedance(int impedance) {
		this.impedance = impedance;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public double calInValue() { //calculate inventory value
		double value = super.getPrice() * super.getqAvailable();
		return value;
	}
	
	@Override 
	public String toString() { 
		System.out.println(super.toString()); //calling superclass toString 
		StringBuilder str = new StringBuilder();
		str.append("Sensitivity: " + sensitivity);
		str.append("\nImpedance: " + impedance);
		str.append("\nPower: " + power);
		str.append("\nConnection Type: " + connectionType);
		str.append("\nColor: " + color);
	
		return str.toString();
		
	}

}
