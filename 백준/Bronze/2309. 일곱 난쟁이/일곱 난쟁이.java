import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] height = new int[9];
		for (int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		
		int[] index = new int[2];
		int sum = Arrays.stream(height).sum();
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if ((sum - (height[i] + height[j])) == 100) {
					index[0] = i;
					index[1] = j;
				}
			}
		}
		
		int[] result = new int[7];
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			if (i == index[0] || i == index[1]) continue;
			result[idx++] = height[i];
		}
		
		Arrays.sort(result);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			sb.append(result[i]).append("\n");			
		}
		System.out.println(sb.toString());
	}

}

