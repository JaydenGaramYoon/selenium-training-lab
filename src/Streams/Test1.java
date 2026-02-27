package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// count the number of names starting alphabet A in list
		regular();
		streamFilter();
		streamMap();
		streamCollect();
	}

	@Test
	public static void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Alex");
		names.add("Danny");
		names.add("Ali");
		names.add("Adam");
		names.add("Ranny");

		// stream = collection of strings
		// lamda expression: leftside(parameter) rightside(action)
		// How stream works: 3 stages
		// 1. create a stream: List.stream()
		// 2. perform intermediate operation on the stream to make another stream:
		// List.filter() => produce another stream after the filter applied
		// 3. perform final operation to the final stream: .count()
		// NOTES:
		// 1.intermediate op does not have life if there's no terminal op
		// 2. termianl op executes only if inter op returns true
		long sizeOfAnotherStream = names.stream().filter(name -> name.startsWith("A")).count();
		System.out.println(sizeOfAnotherStream);
		// 3. using filter in Stream API
		// 4. action part can have the body
		// NOTE: .count() returns long type
		long sizeOfAnotherStream2 = Stream.of("Avc", "ADB", "SDS", "ASDF", "ASDDV").filter(item -> {
			item.startsWith("A");
			return true;
			// return false; //will be not execute
		}).count();
		System.out.println(sizeOfAnotherStream2);
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}

	@Test
	public static void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Alex");
		names.add("Danny");
		names.add("Ali");
		names.add("Adam");
		names.add("Ranny");
		int numOfNameStartingWithA = 0;

		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			if (name.startsWith("A")) {
				numOfNameStartingWithA++;
			}
		}
	}

	@Test // to manipulate the stream
	public static void streamMap() {
		// to manipulate original stream
		Stream.of("Avc", "ADB", "SDS", "ASDF", "ASDDV").filter(item -> item.endsWith("c"))
				.map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
	}

	@Test // to save the result
	public static void streamCollect() {
		// collect(Collectors.toList()) -> then .get(index)
		// Stream<T> T -> object type in the stream
		// Stream API works well with List (cuz it's flexible)
		// Stream API is disposable
		// .collect can save the result
		List<String> ls = Stream.of("Avc", "ADB", "SDS", "ASDF", "ASDDV").filter(s -> s.endsWith("c"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));

		// int array to list: ArrayList is generic,
		List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		// print unique number from the array
		values.stream().distinct().forEach(s -> System.out.println(s));
		// list: list is flexible than array(cannot manipulate)->stream(to use stream
		// API, better to use collection methods)->List(since stream is disposable, so
		// save the result to collection->then to list)
		List<Integer> sortedValues = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedValues.get(2));
	}

}
