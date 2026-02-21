package java_basics;

public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1st way to initiate object : String literal, string is an object
		//String s = "Garam Yoon Welcome";
		String s1 = "Garam Yoon"; //cannot be created
		
		//2nd way : using 'new' keyword, creating new object in the memory
		String s2 = new String ("Welcome");
		String s3 = new String ("Welcome");

		String s = "Garam Yoon Welcome"; //array of character
		String[] splittedString = s.split("Yoon");
		System.out.println(splittedString[0].trim());
		System.out.println(splittedString[1].trim());
		for (int i = s.length()-1; i >=0 ; i--) { //reverse the string
			System.out.println(s.charAt(i));
		}
	}

}
