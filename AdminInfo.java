import java.util.Scanner;

public class AdminInfo {
	
	private String name;
	private String userID;
	
	public AdminInfo(String name) {
		this.name = name;
		userID = generateID(name);  //calling generateID method to generate userID
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	//get the input of user for their name
	public static String getUserName(Scanner input) {
		
		String str;
		
		//check valid name is enter, repeat until user enter valid name
		do {
			System.out.print("Enter name: ");
			str = input.nextLine();
			validateName(str);
			
		} while (validateName(str) == false); //keep repeating until valid name is used 
		
		//trim the space before and after the string
		str = str.trim();
		return str;
	}
	

	//for checking user only enter character for name, no special character and numbers is allowed
	public static boolean validateName(String str) {
		
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (!(ch[i] >= 'A' && ch[i] <= 'Z') && !(ch[i] >= 'a' && ch[i] <= 'z') && ch[i] != ' ') {
	             return false;
			}
		}
		return true;
	}
	
	//use to generate userID
	public static String generateID(String str) {
		
		//If there is no space, then default value 'guest' is used for the user ID 
		if (str.indexOf(' ') == -1)
			str = "guest";
		
		else {
		    
			char ch = str.charAt(0); //get the first initial 
		    
			String[] strName = str.split(" "); //spilt the name by space
			StringBuilder sb = new StringBuilder();
			sb.append(ch);
			sb.append(strName[strName.length - 1]); //get the last string in array, in case user enter > 2 space 
			str = sb.toString();
		}
		
		return str;
	}
	
}