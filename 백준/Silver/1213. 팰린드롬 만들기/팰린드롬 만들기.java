import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] alpha = new int[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder front = new StringBuilder();
		StringBuilder back = new StringBuilder();
		
		char[] name = br.readLine().toCharArray();
		for (char n : name) {
			alpha[n - 'A']++;
		}
		
		int odd = 0, center = 0;
		for (int i = 0; i < 26; i++) {
			if (alpha[i] % 2 != 0) {
				odd++;
				center = i;
			}
		}
		
		// 홀수가 1개 이상이거나, 홀수는 1개인데 길이가 2의 배수인 경우
		// 임한수의 영어 이름을 팰린드롬으로 바꿀 수 없다.
		if (odd > 1 || (odd == 1 && name.length % 2 == 0)) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < alpha[i] / 2; j++) {
				front.append((char) ('A' + i));
				back.insert(0, (char) ('A' + i));
			}
		}
		
		if (odd == 0) {
			sb.append(front).append(back);
		} else {
			sb.append(front).append((char) ('A' + center)).append(back);
		}
		System.out.println(sb);
	}

}
