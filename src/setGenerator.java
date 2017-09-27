import java.util.*;

public class setGenerator {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        
        System.out.printf("Enter string: \n");
        String str = in.nextLine();
        str = str.replaceAll("\\s", "");

        System.out.printf("Enter key length: \n");
        int keyLength = in.nextInt();
        
        separateSets(str, keyLength);
        
        in.close();
    }

    public static void separateSets(String str, int keyLength){
        //int x = 3;
        //int y = str.length() / x;
        for(int i = 0; i < keyLength; i++){
        	System.out.printf("%d: ", i);
        	for(int j = 0; j < str.length();){
        		if(j+i<str.length())
        			System.out.printf("%c", str.charAt(j+i));
        		j += keyLength;
        	}
        	System.out.printf("\n");
        }
    	/*System.out.printf("First set: \n");
        for(int i = 0; i < str.length();){
            System.out.printf("%c", str.charAt(i));
            i += 3;
        }

        System.out.printf("\nSecond set: \n");
        for(int i = 1; i < str.length();){
            System.out.printf("%c", str.charAt(i));
            i += 3;
        }

        System.out.printf("\nThird set: \n");
        for(int i = 2; i < str.length();){
            System.out.printf("%c", str.charAt(i));
            i += 3;
        }*/
    }
}