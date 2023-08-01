import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 입력
		int switchCnt = Integer.parseInt(br.readLine()) + 1;
		int[] switchStatus = new int[switchCnt];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < switchCnt; i++) {
			switchStatus[i] = Integer.parseInt(st.nextToken());
		}
		
		int studentCnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < studentCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			// 남학생
			if (gender == 1) {
				for (int idx = num; idx < switchCnt; idx++) {
					if (idx % num == 0) {						
						switchStatus[idx] = (switchStatus[idx] == 0) ? 1 : 0;
					}
				}
			}
			// 여학생
			if (gender == 2) {
				int start = num, end = num;
				while (switchStatus[start] == switchStatus[end]) {
					start--;
					end++;
					if (start < 1 || end >= switchCnt) break;
				}
				for (int idx = start + 1; idx < end; idx++) {
					switchStatus[idx] = (switchStatus[idx] == 0) ? 1 : 0;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 1; i < switchCnt; i++) {
			if (cnt == 20) {
				sb.append("\n");
				cnt = 0;
			}
			sb.append(switchStatus[i]).append(" ");
			cnt++;
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}

}