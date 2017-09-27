import java.util.*;

public class estimateKeyLength {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.printf("Length of string(n)?: ");
		int n = in.nextInt();
		
		System.out.printf("Index of coincidence(I)?: ");
		float i = in.nextFloat();
		
		float key = estimateKey(i, n);
		
		System.out.printf("\nEstimated key length is: %.03f\n", key);
		
		in.close();
	}
	
	public static float estimateKey(float ioC, int n){
		//System.out.printf("Running key length estimate: ioC: %.04f - L: %d", ioC, n);
		float key = (0.0265f*n)/((0.065f - ioC)+(n*(ioC - 0.0385f)));
		
		return key;
	}
}