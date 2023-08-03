import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] cnt, check;
	static char[] str;
	
	private static void count(int i, boolean isAdded) {
		if (isAdded) {
			if (str[i] == 'A') cnt[0]++;
			if (str[i] == 'C') cnt[1]++;
			if (str[i] == 'G') cnt[2]++;
			if (str[i] == 'T') cnt[3]++;
		} else {
			if (str[i] == 'A') cnt[0]--;
			if (str[i] == 'C') cnt[1]--;
			if (str[i] == 'G') cnt[2]--;
			if (str[i] == 'T') cnt[3]--;
		}
	}
	
	private static boolean check() {
		for (int i = 0; i < 4; i++) {
			if (cnt[i] < check[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		String[] temp = br.readLine().split(" ");
		int s = Integer.parseInt(temp[0]);
		int p = Integer.parseInt(temp[1]);
		
		str = br.readLine().toCharArray();
		
		check = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = new int[4];
		for (int i = 0; i < p; i++) {
			count(i, true);
		}
		
		int result = 0;
		if (check()) {
			result++;
		}
		
		for (int i = p; i < s; i++) {
			int j = i - p;
			count(j, false);
			count(i, true);
			if (check()) {
				result++;
			}
		}
		System.out.println(result);
	}

}
