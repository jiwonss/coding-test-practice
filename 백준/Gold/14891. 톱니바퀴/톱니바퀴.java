import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	
	static int K, result;
	static char[][] wheel;
	static int[] direction;
	static int[][] rotateInfo;
	
	public static void main(String[] args) throws IOException {
		init();
		rotate();
		calc();
		System.out.println(result);
	}
	
	public static void init() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		wheel = new char[4][8];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			wheel[i] = st.nextToken().toCharArray();
		}
		
		K = Integer.parseInt(br.readLine());
		rotateInfo = new int[K][2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			rotateInfo[i][0] = n - 1; rotateInfo[i][1] = d;
		}	
		
		br.close();
	}
	
	public static void rotate() {
		for (int i = 0; i < K; i++) {
			int n = rotateInfo[i][0];
			int d = rotateInfo[i][1];
			
			// 회전할 방향 구하기
			direction = new int[4];
			direction[n] = d;
			for (int j = n; j > 0; j--) {
				if (wheel[j][6] != wheel[j - 1][2]) {
					direction[j - 1] = direction[j] * (-1);
				} else {
					break;
				}
			}
			for (int j = n; j < 3; j++) {	
				if (wheel[j][2] != wheel[j + 1][6]) {
					direction[j + 1] = direction[j] * (-1);
				} else {
					break;
				}
			}
			
			// 회전
			for (int j = 0; j < 4; j++) {
				if (direction[j] != 0) {
					rotateWheel(j, direction[j]);					
				}
			}
		}
	}
	
	public static void rotateWheel(int n, int d) {
		if (d == 1) {
			char temp = wheel[n][7];
			for (int i = 7; i > 0; i--) {
				wheel[n][i] = wheel[n][i - 1];
			}
			wheel[n][0] = temp;
		} else {
			char temp = wheel[n][0];
			for (int i = 0; i < 7; i++) {
				wheel[n][i] = wheel[n][i + 1];
			}
			wheel[n][7] = temp;
		}
	}
	
	public static void calc() {
		result = 0;
		for (int i = 0; i < 4; i++) {
			if (wheel[i][0] == '1') {
				result += Math.pow(2, i);				
			}
		}
	}

}
