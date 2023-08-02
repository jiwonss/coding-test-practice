import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			String str = br.readLine();
			List<Character> list = new LinkedList<>();
			ListIterator<Character> iter = list.listIterator();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				switch (c) {
					case '<':
						if (iter.hasPrevious()) {
							iter.previous();
						}
						break;
					case '>':
						if (iter.hasNext()) {
							iter.next();
						}
						break;
					case '-':
						if (iter.hasPrevious()) {
							iter.previous();
							iter.remove();
						}
						break;
					default:
						iter.add(c);
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

}
