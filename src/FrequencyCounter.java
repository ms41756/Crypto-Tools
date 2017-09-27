import java.util.*;
import java.io.*;
import java.lang.*;

public class FrequencyCounter {
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		String str;
		int[] frequency = new int[26];
		int length = 0;
		float indexOfCoincidence;
		
		System.out.printf("Enter the string to count frequency of: \n");
		str = in.nextLine();
		
		//length = str.length();
		
		System.out.printf("Frequencies:\n");
		length = calculateFrequency(str, frequency);
		
		indexOfCoincidence = indexOfCoincidence(frequency, length);
		System.out.printf("Index of coincidence: %.04f\n", indexOfCoincidence);		
		
		float keyEstimate = estimateKeyLength(indexOfCoincidence, length);
		
		System.out.printf("Key Estimate: %.03f\n", keyEstimate);
		
		in.close();
	}
	
	public static int calculateFrequency(String word, int[] frequency) {
		//array for decimal frequencies
		float[] decFrequency = new float[26];
		int length = 0;
		//variable to hold the current char
		char c;
		
		//var for the values of chars
		int charVal;
		
		//loop through all the characters of the string
		for(int i = 0; i < word.length(); i++){
			c = word.charAt(i);
			charVal = Character.getNumericValue(c) - 10;
			
			if(charVal >= 0 && charVal <= 25) {
				//System.out.printf("-----%c - %d-----\n", c, charVal);
				length++;
				frequency[charVal] += 1;
			}
		}
		
		for(int j = 0; j < 26; j++){
			//length += frequency[j];
			decFrequency[j] = (float)(frequency[j]/length);
			
			System.out.printf("%c - %d - %.02f%%\n", (char)(j+97), frequency[j], 100*(frequency[j]/(float)length));
		}
		
		return length;
	}
	
	public static float indexOfCoincidence(int[] frequency, int length){
		float sum = 0;
		
		for(int k = 0; k < 26; k++){
			sum += (frequency[k])*(frequency[k]-1);
			//System.out.println(sum);
		}
		//System.out.print(length);
		return (float)sum/(length*(length-1));
	}
	
	public static float estimateKeyLength(float ioC, int n){
		//System.out.printf("Running key length estimate: ioC: %.04f - L: %d", ioC, n);
		float key = (0.0265f*n)/((0.065f - ioC)+(n*(ioC - 0.0385f)));
		
		return key;
	}
}
