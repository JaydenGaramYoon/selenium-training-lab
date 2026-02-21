package java_basics;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myNum = 5; //give datatype, premitive
		String website = "UniStyle"; //non-premitive
		char letter = 'u';
		double dec = 6.11;
		boolean answer = true;
		
		System.out.println(myNum + "is the number"); //concactinate
		System.out.println("This is the website of ".concat(website));
		System.out.println(letter);
		System.out.println(dec);
		System.out.println(answer);
		
		//Arrays
		//define the length of array
		int[] arr = new int[5]; //new: create a memory to store the variable
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		//shortcut of initializing array
//		int[] arr2 = {1,2,4,5,6};
//		System.out.println(arr2[2]);
		
		//for loop
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]); 
//		}
		
		String[] name = {"I", "love", "you"};
		for(String s: name) {
			System.out.println(s);
		}
	
	}

}
