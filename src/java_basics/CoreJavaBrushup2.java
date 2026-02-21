package java_basics;
import java.util.ArrayList;
import java.util.List;

public class CoreJavaBrushup2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr2 = {1,2,3,4,5,6,7,8,9};
		
		//output: multiple by 2
		
		for(int i = 0; i < arr2.length; i++)
		{
			if(arr2[i] % 2 == 0)
			{
				System.out.println(arr2[i]);
			}
			else if (arr2[i] % 3 == 0)
			{
				System.out.println(arr2[i]);
				break;
			}
		}
		
	     int[] numbers = {1,2,3,4,5};
	        System.out.println("First element: " + numbers[0] + "Last element: " + numbers[numbers.length-1]);
	        
	        for(int i = numbers.length-1; i >= 0; i--){
	            System.out.println(numbers[i]);
	        }
	        
	        for(int count = 1; count <= numbers.length; count++){
		        if(count == numbers.length){
		            System.out.println(count);
		            break;
		        }
		    }
	        
//	        ArrayList<String> a = new ArrayList<String>();
	        //using interface to change to linkedlist later
	        List<String> a = new ArrayList<String>();
	        a.add("a");
	        a.add("b");
	        a.remove(1); //remove using index
	        System.out.println(a.get(0));
	        
	        for(int i=0; i < a.size(); i++) { //arrayList uses size() not length()
	        	System.out.println(a.get(i));
	        }
	        
	        for( String val :a) {
	        	System.out.println("arrayList2: "+val);
	        }
	        
	        if(a.contains(a)) {
	        	
	        }
	}

}
