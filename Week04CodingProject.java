package week04;

import java.util.*;


public class Week04CodingProject {

	public static void main(String[] args) {

		// 1. Create an array of int called ages that contains the following values: 3, 9, 23, 64, 2, 8, 28, 93.
 		int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};
 		// initializing the array
 		
 		//	a. Programmatically subtract the value of the first element in the array from the value in the last element of the array (i.e. do not use ages[7] in your code). Print the result to the console.
		System.out.println(ages[ages.length - 1] - ages[0]); // 90
		// To access an array you need to use square brackets and the index you want to access i.e. array[index]
		// When accessing the last item of the array, array.length provides the countable number of items while arrays start at 0, so we must always subtract 1
		
		//	b. Create a new array with 9 elements (one more than the ages array)  Repeat the step above to ensure it is dynamic (works for arrays of different lengths).
		int[] agesPlus = {3, 9, 23, 64, 17, 2, 8, 28, 93}; 
		System.out.println(agesPlus[agesPlus.length - 1] - agesPlus[0]); // 90
		// Didn't do anything special here, regardless of the length of the array code is written to always grab the last index (array.length - 1) and first index

		//	c. Use a loop to iterate through the array and calculate the average age. Print the result to the console.
		int sum = 0;
		for (int i : ages) {
			sum += i;
		}
		System.out.println(sum/ages.length); // 28
		// Loopty loop with enhanced loops, very similar to for-each. Grabs each element in the array and adds it to a summation variable 

		//2. Create an array of String called names that contains the following values: “Sam”, “Tommy”, “Tim”, “Sally”, “Buck”, “Bob”.
		String[] names = {"Sam","Tommy","Tim","Sally","Buck","Bob"};
		// initializing an array

		//	a. Use a loop to iterate through the array and calculate the average number of letters per name. Print the result to the console.
		sum = 0;
		for (String s : names) {
			sum += s.length();
		}
		System.out.println(sum/names.length); // 3
		// Loopty loop with enhanced loops, this time we want the length of each element instead of the element itself and then dividing by the length of the array to get the average

		//	b. Use a loop to iterate through the array again and concatenate all the names together, separated by spaces, and print the result to the console.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if (i == names.length - 1) {
				sb.append(names[i]);
			}else {
				sb.append(names[i] + " ");
			}
		}
		System.out.println(sb.toString()); // Sam Tommy Tim Sally Buck Bob
		// Normal for loop :(, using stringbuilder to dynamically create the string and then if we're looking at the last element of the array making sure to not add an extra space, could have used trim too

		//3. How do you access the last element of any array?
		System.out.println(names[names.length - 1]); // Bob
		// With magic, last element of the array is accessed using array.length - 1. Length gives us the countable value while arrays start at 0

		//4. How do you access the first element of any array?
		System.out.println(names[0]); // Sam
		// Array starts at 0, input 0 for the requested index

		//5. Create a new array of int called nameLengths. Write a loop to iterate over the previously created names array and add the length of each name to the nameLengths array.
		int[] nameLengths = {0,0,0,0,0,0};
		for (int i = 0; i < names.length; i++) {
			nameLengths[i] = names[i].length();
		}
		System.out.println(Arrays.toString(nameLengths)); // [3, 5, 3, 5, 4, 3]
		// normal for loop :(, I know the length of the output array so initializing so I can easily add items to it. Then looping over both arrays and setting the values of the output array to be the length of the elements of the input arrays

		//6. Write a loop to iterate over the nameLengths array and calculate the sum of all the elements in the array. Print the result to the console.
		sum = 0;
		for (int i : nameLengths) {
			sum += i;
		}
		System.out.println(sum); // 23
		// Loopty loop with enhanced array, similar function as 2b, but not including the division since we just want the sum
		
		// 7. Tests
		System.out.println(repeatWord("Hello", 3)); // HelloHelloHello
		System.out.println(repeatWord("Hello", 6)); // HelloHelloHelloHelloHelloHello
		System.out.println(repeatWord("Hello", 0)); // Please choose a number greater than 0.
		System.out.println(repeatWord("Hello", -5)); // Please choose a number greater than 0.

		// 8. Tests
		System.out.println(fullName("Tyler", "Pooschke")); // Tyler Pooschke
		System.out.println(fullName("A", "B")); // A B
		
		// 9. Tests
		int[] test = {1,2,3,5,4};
		System.out.println(largeSum(test)); // false
		int[] test2 = {99, 2};
		System.out.println(largeSum(test2)); // true
		int[] test3 = {101};
		System.out.println(largeSum(test3)); // true
		int[] test4 = {101, -10};
		System.out.println(largeSum(test4)); // false
		
		// 10. Tests
		double[] test5 = {1.0,2.0,3.0,4.0};
		System.out.println(average(test5)); // 2.5
		double[] test6 = {-1.0,2.0,-3.0,4.0, 10.0};
		System.out.println(average(test6)); // 2.4
		
		// 11. Tests
		System.out.println(compare(test5, test6)); // true
		System.out.println(compare(test6, test5)); // false
		
		// 12. Tests
		boolean isHotOutside = true;
		double moneyInPocket = 10.51;
		System.out.println(willBuyDrink(isHotOutside, moneyInPocket)); // true
		isHotOutside = false;
		System.out.println(willBuyDrink(isHotOutside, moneyInPocket)); // false
		moneyInPocket = 9.00;
		System.out.println(willBuyDrink(isHotOutside, moneyInPocket)); // false
		isHotOutside = true;
		System.out.println(willBuyDrink(isHotOutside, moneyInPocket)); // false
		
		
		List<String> testingList = new ArrayList<String>(Arrays.asList("Sam","Tommy","Tim","Sally","Buck"));
		System.out.println(halfTheList(testingList));
		
		
	}
	//7. Write a method that takes a String, word, and an int, n, as arguments and returns the word concatenated to itself n number of times. (i.e. if I pass in “Hello” and 3, I expect the method to return “HelloHelloHello”).
	public static String repeatWord(String word, int n) {
		String result = "";
		if (n > 0) {
			for (int i = 1; i <= n; i++) {
				result += word;
			}
		} else {
			result = "Please choose a number greater than 0.";
		}
		return result;
	}
	// Used a for loop to do string concatenation, then included some error handling in case an invalid integer was input
	
	
	//8. Write a method that takes two Strings, firstName and lastName, and returns a full name (the full name should be the first and the last name as a String separated by a space).
	public static String fullName(String firstName, String lastName) {
		StringBuilder sb = new StringBuilder();
		sb.append(firstName + " ");
		sb.append(lastName);
		String result = sb.toString();
		return result;
	}
	// Simple stringbuilder use case to play with it some more with a touch of concatenation. Could have also just used concatenation only
	
	//9. Write a method that takes an array of int and returns true if the sum of all the ints in the array is greater than 100.
	public static boolean largeSum (int[] array) {
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		return sum > 100;
	}
	// Typical for each loop with a summation and returned the calculated boolean in the return statement
	
	//10. Write a method that takes an array of double and returns the average of all the elements in the array.
	public static double average (double[] array) {
		double sum = 0;
		for (double d : array) {
			sum += d;
		}
		return sum/array.length;	
	}
	// Similar to many items above but with doubles and returning the average
	
	//11. Write a method that takes two arrays of double and returns true if the average of the elements in the first array is greater than the average of the elements in the second array.
	public static boolean compare (double[] array, double[] array2) {
		double sum = 0;
		double sum2 = 0;
		for (double d : array) {
			sum += d;
		}
		for (double d: array2) {
			sum2 += d;
		}
		return sum/array.length > sum2/array2.length;
	}
	// Exercise #9 and #10, but combined! and kind of duplicated?
	
	//12. Write a method called willBuyDrink that takes a boolean isHotOutside, and a double moneyInPocket, and returns true if it is hot outside and if moneyInPocket is greater than 10.50.
	public static boolean willBuyDrink (boolean isHotOutside, double moneyInPocket) {
		return isHotOutside && moneyInPocket > 10.50;
	}
	// Playing with and/or statements, if true and number bigger than 10.50 then return true. Either of those statements are false and return false.
	
	//13. Create a method of your own that solves a problem. In comments, write what the method does and why you created it.
	public static List<String> halfTheList(List<String> listOfNames){
		List<String> resultList = new ArrayList<>();
		for (int i = 0; i < listOfNames.size(); i++) {
			if (!(i % 2 == 0)) {
				resultList.add(listOfNames.get(i));
			}
		}
		return resultList;
	}
	// I honestly don't remember writing this, but looks like I'm taking a list and splitting it in half and returning it. Use a for loop to loop over the input list and then only add to the output list if 
	
	
}
