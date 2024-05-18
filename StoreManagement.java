import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StoreManagement {
	
	public static void main(String[] args) {

		//Display welcome screen
		System.out.println("Welcome to SMS.");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
		LocalDateTime now = LocalDateTime.now(); 
		System.out.println(dtf.format(now)); 
				
		
		//defined variable that is used in the program 
		Scanner input = new Scanner(System.in);
		int num, choice;
		
		//User enter their name, calling AdminInfo class
		String str = AdminInfo.getUserName(input);
		AdminInfo ad = new AdminInfo(str);
				
		//Select maximum number of products user want to store 
		System.out.println("Enter number of product: ");
		num = nonZeroInt(input);
		
		//create an array for store product
		Product[] prod = new Product[num];
						
		//Display array index and product type(Laptop, Desktop, Mice)
		for (int i = 0; i < prod.length; i++) {
			System.out.println("Add product " + i); //show current the array index
			choice = chooseProduct(input);
			if (choice == 0) { //user do not want to add product
				System.out.println("No products to be added! Exit.");
				break;
			}
			addProd(input, prod, choice, i);
		}
		
		//menu
		do {
			choice = menu(input);
			switch (choice) {
			
			case 1: //add new product into the array
				if(addNewProd(prod, input)==false) //calling addNewProd method
					System.out.println("Fail to add product.");
				else
					System.out.println("New product added.");
				break;
			
			case 2: //view the stock enter by user
				viewStock(prod);
				break;	
			
			case 3: //add stock quantity of selected product 
				num = selectProd(prod, input); //display the product in the program and let user to select 
				if (num != -1)
					addStock(prod[num], input);
				break;
				
			case 4: //deduct stock quantity of selected product
				num = selectProd(prod, input); //display the product in the program and let user to select
				if(num != -1) 
					deductStock(prod[num], input);
				break;
					
			case 5: //set product status of selected product
				num = selectProd(prod, input); //display the product in the program and let user to select 
				if(num != -1)
					setProdStatus(prod[num], input);
				break;
					
			case 0: //user want to exit the program, display name and the userID 
				System.out.println("Name: " + ad.getName());
				System.out.println("UserID: " + ad.getUserID());
				System.out.println("Exit.");
				break;
					
			default: //any input not choosing the menu
				System.out.println("Invalid input!");
			}
					
		} while(!(choice == 0)); //repeat until user choose to exit
		
		input.close(); 
	}
	
	//for checking user only enter integer
	public static int validateInt(Scanner input) {
		while(!input.hasNextInt()) { //repeat until user enter valid input, integer 
			System.out.println("Invalid input! Please enter a valid integer. ");
			input.next();
		}
		int num = input.nextInt();
		return num;
	}
	
	//for checking user only enter numbers 
	public static double validateNum(Scanner input) {
		while(!input.hasNextDouble()) { //repeat until user enter valid input, number (can be int or double)
			System.out.println("Invalid input! Please enter a valid number. ");
			input.next();
		}
		double num = input.nextDouble(); 
		return num;
	}
	
	//for checking non negative integer, which is >= 0
	public static int nonNegative(Scanner input) {
		int num;
			do { //repeat until user enter valid input
				num = validateInt(input);
				if(num < 0)
					System.out.println("Invalid input! Please enter a valid integer.");
			} while(num < 0);
				
			return num;
	}
	
	//for checking user only choose number of product that is available 
	public static int chooseProduct(Scanner input) {
		int choice;
		do {
			System.out.println("1. Laptop\n2. Desktop\n3. Mice\n4. Speaker\n0. Exit\nChoose product: ");
			choice = validateInt(input);
			
		} while (choice > 4 || choice < 0);
		
		return choice;
	}
	
	//add Product into the array
	public static void addProd(Scanner input, Product[] p, int choice, int i) {
		
		String name, manuf, color = null, proc = null, formf = null, 
		category = null, storageT = null, connect = null, scroll = null;
		int num, q, ram = 0, storage = 0, size = 0, sens = 0, imp = 0, power = 0;
		double price, screenS = 0;
		
		input.nextLine();
		
		//common data in super class
		System.out.println("Product name: ");
		name = input.nextLine();
		System.out.println("Manufacturer: ");
		manuf = input.nextLine();
		
		//for subclass product 
		
		if (choice == 1) { // Laptop subclass
			System.out.println("Color: ");
			color = input.nextLine();
			System.out.println("Screen size: ");
			screenS = nonZeroNum(input);
			input.nextLine();
			System.out.println("Processor: ");
			proc = input.nextLine();
			System.out.println("Memory (RAM): ");
			ram = nonZeroInt(input);
			System.out.println("Storage size: ");
			storage = nonZeroInt(input);
		}
		
		else if(choice == 2) { //Desktop subclass
			System.out.println("Form factor: ");
			formf = input.nextLine();
			System.out.println("Usage category: ");
			category = input.nextLine();
			System.out.println("Processor: ");
			proc = input.nextLine();
			System.out.println("Memory (RAM): ");
			ram = nonZeroInt(input);
			System.out.println("Storage size: ");
			storage = nonZeroInt(input);
			input.nextLine();
			System.out.println("Storage Type: ");
			storageT = input.nextLine();
			System.out.println("Screen Size: ");
			screenS = nonZeroNum(input);
		}
		
		else if (choice == 3 ) { //Mice subclass
			System.out.println("Connectivity: ");
			connect = input.nextLine();
			System.out.println("Scroll type: ");
			scroll = input.nextLine();
			System.out.println("Size: ");
			size = nonZeroInt(input);
		}
		
		else { //Speaker subclass
			System.out.println("Sensitivity: ");
			sens = nonZeroInt(input);
			System.out.println("Impedance: ");
			imp = nonZeroInt(input);
			System.out.println("Power: ");
			power = nonZeroInt(input);
			input.nextLine();
			System.out.println("Connection Type: ");
			connect = input.nextLine();
			System.out.println("Color: ");
			color = input.nextLine();
		}
		
		//common data in super class
		System.out.println("Quantity available: ");
		q = nonNegative(input);
		System.out.println("Price: ");
		price = validateNum(input);
		System.out.println("Item number: ");
		num = nonNegative(input);
		
		//pass the value into the constructor to create subclass object 
		if (choice == 1)
			p[i] = new Laptop(num, name, manuf, q, price, color, proc, screenS, ram, storage);
		else if (choice == 2)
			p[i] = new Desktop(num, name, manuf, q, price, category, proc, ram, storage, storageT, screenS, formf);
		else if(choice == 3)
			p[i] = new Mice(num, name, manuf, q, price, size, connect, scroll);
		else 
			p[i] = new Speaker(num, name, manuf, q, price, sens, imp, power, connect, color);
		
	}	
	
	//for adding new product into the array
	public static boolean addNewProd(Product[] p, Scanner input) {
		int choice;
		
		for(int i =0; i < p.length; i++) {
			
			if(p[i] == null) { //find empty array index 
				choice = chooseProduct(input); //let user to choose which type of product
				if (choice == 0) {  //user do not want to add product
					System.out.println("No products to be added! Exit.");
					break; //exit the for loop
				}
				addProd(input, p, choice, i); //calling addProd method to add product
				return true; //product is success to enter 
			}
		}
		return false;
	}
	
	//Check input to be > 0 (int)
	public static int nonZeroInt(Scanner input) {
		int num;
		do {
			num = validateInt(input);
			if(num <= 0)
				System.out.println("Invalid input");
			
		} while(num <= 0);
			
		return num;
	}
	
	//Check input to be > 0 (double)
	public static double nonZeroNum(Scanner input) {
		double num;
		do {
			num = validateInt(input);
			if(num <= 0)
				System.out.println("Invalid input");
			
		} while(num <= 0);
			
		return num;
	}
	
	//Display menu
	public static int menu(Scanner input) {
		System.out.println("\n1. Add Product\n2. View Stock \n3. Add Stock \n4. Deduct Stock "
				+ "\n5. Discontinue a Product \n0. Exit \nPlease enter a menu option: ");
		int choice = validateInt(input); //validate the user input only enter integer
		return choice;
	}
	
	//view all the stock in the array
	public static void viewStock(Product[] p) {
		for (int i = 0; i < p.length; i++) { 
			//error handling if the array element is null
			try {
				System.out.println(p[i].toString());
				System.out.println();
			}
			catch (NullPointerException ex) {
				break;
			}
		}
	}
	
	//Select the product to perform add stock or deduct stock
	public static int selectProd(Product[] p, Scanner input) {
		int choice, prodlength = 0;
		
		System.out.println("Number of product: ");
		
		//show the product available
		for (int i = 0; i < p.length; i++) {
			//error handling if the array element is null
			try {
				System.out.println("Product " + i + ": " + p[i].getpName());
			}
			catch (NullPointerException ex) {
				//if there is no product in the element at all
				if(i == 0) {
					System.out.println("No product!");
					prodlength = -1;
				}
				//if there is some element in the array, but the array is not full
				else
					prodlength = i; //assign the array index of last element to product length
				break;
			}
		}
		
		do { //if the product array is null 
			if(prodlength == -1) {
				choice = -1;
				break;
			}
			
			System.out.println("Select number of product: ");
			choice = validateInt(input);
		}while(choice < 0 || choice > prodlength); // prodlength is used instead of prod.length because the array might not be full
		
		return choice;
	}
	
	//add stock value 
	public static void addStock(Product p, Scanner input) {
		System.out.println("Stock value to add: ");
		int num = nonNegative(input);
		p.addStock(p, num); //calling method in product class
	}
	
	//deduct stock value
	public static void deductStock(Product p, Scanner input) {
		System.out.println("Stock value to deduct: ");
		int num = nonNegative(input);
		p.deductProduct(p, num); //calling mehtod in product class
	}
	
	//set product status to active or discontinued
	public static void setProdStatus(Product p, Scanner input) {
		int choice;
		
		do {
			System.out.println("Set product status: 1. Active  2. Discountinued");
			choice = validateInt(input);
			if (choice == 1) {
				p.setpStatus(true);
				System.out.println("Product is active.");
			}
			else if (choice == 2){
				p.setpStatus(false);
				System.out.println("Product is discontinued.");
			}
			else 
				System.out.println("No change in product status.");
			
		} while (choice < 1 && choice > 2);	
	}
	
}
