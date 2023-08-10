import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] check = new int[26];
		for (int i = 0; i < n; i++) {
			char[] name = br.readLine().toCharArray();
			check[name[0] - 'a']++;
		}
		
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			if (check[i] >= 5) {
				list.add((char) (i + 'a'));
			}
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		System.out.println(list.size() > 0 ? sb.toString() : "PREDAJA");
	}

}
