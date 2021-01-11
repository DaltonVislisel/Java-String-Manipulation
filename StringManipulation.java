import java.util.*;
import java.io.*;

public class StringManipulation {
	public static void main(String[] args) {
		int n;
		char in1;
		String userFile, tempS;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Would you like to input from a (f)ile or the (c)onsole? (f or c): ");
		in1 = sc.next().charAt(0);
		System.out.println();
		
		if(in1 != 'f' && in1 != 'F' && in1 != 'c' && in1 != 'C') {
			
			while(in1 != 'f' || in1 != 'F' || in1 != 'c' || in1 != 'C') {
				
				
				System.out.print("That is not a valid input please input f for file or c for console: ");
				in1 = sc.next().charAt(0);
				System.out.println();
				
			}
		}
		
		if(in1 == 'f' || in1 == 'F') {
			System.out.println("Please input the name of the file you wish to use:");
			sc.nextLine();
			userFile = sc.nextLine();
			
					
			
		    try {
		    	File fileName = new File(userFile);
		        Scanner fileReader = new Scanner(fileName);
		        while (fileReader.hasNextLine()) {
		        	n = fileReader.nextInt();
		        	String[] strings = new String[n];
		        	fileReader.nextLine();
		        	
		        	for(int i = 0; i < n; i++) {
		        		strings[i] = fileReader.nextLine();
		        	}
		        	
		        	System.out.println("The strings that were in the file:");
		        	
		        	for(int i = 0; i < n; i++) {
		        		System.out.println((i+1) + ". " + strings[i]);
		        	}
		        	
		        	
		        	for(int i = 0; i < n; i++) {
		        		tempS = "";
		        		for(int j = 0; j < n; j++) {
		        			if(i != j) {
		        				if(isAnagram(strings[i], strings[j]) == true) {
		        					tempS = tempS + j + " ";
		        				}
		        			}
		        		}
		        		if(tempS == "") {
		        			System.out.println("String " + (i+1) + " is not an anagram with any other string.");
		        		}else {
		        			System.out.println("String " + (i+1) + " is an anagram with string(s): " + tempS);
		        		}
		        	}
		        	
		        	for(int i = 0; i < n; i++) {
		        		if(isPalindrome(strings[i]) != true) {	
		        			System.out.println("String " + (i+1) + " is not a palindrome.");
		        		}else {
		        			System.out.println("String " + (i+1) + " is a palindrome.");
		        		}
		        	}
		        	
		        	
		          
		        }
		        fileReader.close();
		        
		      } catch (FileNotFoundException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }
			
		
		}else {
			System.out.print("How many strings would you like in input: ");	        
			n = sc.nextInt();
			String[] strings = new String[n];
			
			System.out.println();
			
			sc.nextLine();
			for (int i = 0; i < n; i++) {
				if(i == 0) {
					System.out.println("Please type your first string and hit enter.");
				}else if (i < n-1){
					System.out.println("Please type your next string and hit enter.");
				}else {
					System.out.println("Please type your last string and hit enter.");
				}
				strings[i] = sc.nextLine();
			}
			
			System.out.println("The strings that were in the file:");
        	
        	for(int i = 0; i < n; i++) {
        		System.out.println((i+1) + ". " + strings[i]);
        	}
        	
        	for(int i = 0; i < n; i++) {
        		tempS = "";
        		for(int j = 0; j < n; j++) {
        			if(i != j) {
        				if(isAnagram(strings[i], strings[j]) == true) {
        					tempS = tempS + j + " ";
        				}
        			}
        		}
        		if(tempS == "") {
        			System.out.println("String " + (i+1) + " is not an anagram with any other string.");
        		}else {
        			System.out.println("String " + (i+1) + " is an anagram with string(s): " + tempS);
        		}
        	}
        	
        	for(int i = 0; i < n; i++) {
        		if(isPalindrome(strings[i]) != true) {	
        			System.out.println("String " + (i+1) + " is not a palindrome.");
        		}else {
        			System.out.println("String " + (i+1) + " is a palindrome.");
        		}
        	}
        	
		}
		
		
		
		System.out.print("Done.");
		
		sc.close();
	}
	
	static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        int sum = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i=0; i<a.length(); i++) {
                if (a.charAt(i) == c) {
                    sum++;
                }
                if (b.charAt(i) == c) {
                    sum--;
                }
            }
            if (sum != 0) {
                return false;
            }
        }
        return true;
        
    }
	
	static boolean isPalindrome(String a) {
		String temp = a;
		StringBuilder strA = new StringBuilder(a); 
		StringBuilder reverseStrA = strA.reverse();
		
		if(reverseStrA.toString().equals(temp)) {
			return true;
		}else {
			return false;
		}
	}
	
}
