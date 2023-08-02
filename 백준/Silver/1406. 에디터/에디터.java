import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int m = Integer.parseInt(br.readLine());
		List<Character> list = new LinkedList<>();
		for (char s : str) {
			list.add(s);
		}
		
		ListIterator<Character> iter = list.listIterator();
		while (iter.hasNext()) {
			iter.next();
		}
		
		for (int i = 0; i < m; i++) {
			String temp = br.readLine();
			char op = temp.charAt(0);
			switch (op) {
				case 'L':
					if (iter.hasPrevious()) {
						iter.previous();
					}
					break;
				case 'D':
					if (iter.hasNext()) {
						iter.next();
					}
					break;
				case 'B':
					if (iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				default:
					iter.add(temp.charAt(2));
					break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (Character c : list) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}

}
