import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int sum = 0, result = 0;
		int left = 0, right = N - 1;
		while (left < right) {
			sum = arr[left] + arr[right];
			if (sum < M) {
				left++;
			} else if (sum > M) {
				right--;
			} else {
				result++;
				left++;
				right--;
			}
		}
		System.out.println(result);
	}

}
