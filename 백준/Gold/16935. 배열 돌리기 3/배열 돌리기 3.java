import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, r;
	static int[][] arr, arr1, arr2, arr3, arr4;
	
	// 1. 상하 반전
	private static void rotate1() {
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[n - i - 1][j];
				arr[n - i - 1][j] = temp;		
			}
		}
	}
	
	// 2. 좌우 반전
	private static void rotate2() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][m - j - 1];
				arr[i][m - j - 1] = temp;		
			}
		}
	}
	
	// 3. 오른쪽으로 90도 회전
	private static void rotate3() {
		n = arr[0].length;
		m = arr.length;
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = arr[m - j - 1][i];
			}
		}
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			System.arraycopy(temp[i], 0, arr[i], 0, m);
		}
	}
	
	// 4. 왼쪽으로 90도 회전
	private static void rotate4() {
		n = arr[0].length;
		m = arr.length;
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = arr[j][n - i - 1];
			}
		}
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			System.arraycopy(temp[i], 0, arr[i], 0, m);
		}
	}
	
	private static int[][] divideArr(int sx, int ex, int sy, int ey) {
		int[][] temp = new int[n / 2][m / 2];
		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++) {
				temp[i - sx][j - sy] = arr[i][j];
			}
		}
		return temp;
	}
	
	private static void combineArr(int sx, int ex, int sy, int ey, int[][] temp) {
		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++) {
				arr[i][j] = temp[i - sx][j - sy];
			}
		}
	}

	// 5. 1 -> 2 -> 3 -> 4 -> 1
	private static void rotate5() {
		arr1 = divideArr(0, n / 2, 0, m / 2);
		arr2 = divideArr(0, n / 2, m / 2, m);
		arr3 = divideArr(n / 2, n, m / 2, m);
		arr4 = divideArr(n / 2, n, 0, m / 2);
		
		arr = new int[n][m];
		combineArr(0, n / 2, 0, m / 2, arr4);
		combineArr(0, n / 2, m / 2, m, arr1);
		combineArr(n / 2, n, m / 2, m, arr2);
		combineArr(n / 2, n, 0, m / 2, arr3);
	}
	
	// 6. 1 -> 4 -> 3 -> 2 -> 1
	private static void rotate6() {
		arr1 = divideArr(0, n / 2, 0, m / 2);
		arr2 = divideArr(0, n / 2, m / 2, m);
		arr3 = divideArr(n / 2, n, m / 2, m);
		arr4 = divideArr(n / 2, n, 0, m / 2);
		
		arr = new int[n][m];
		combineArr(0, n / 2, 0, m / 2, arr2);
		combineArr(0, n / 2, m / 2, m, arr3);
		combineArr(n / 2, n, m / 2, m, arr4);
		combineArr(n / 2, n, 0, m / 2, arr1);
	}
	
	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			int op = Integer.parseInt(st.nextToken());
			switch (op) {
				case 1:
					rotate1();
					break;
				case 2:
					rotate2();
					break;
				case 3:
					rotate3();
					break;
				case 4:
					rotate4();
					break;
				case 5:
					rotate5();
					break;
				case 6:
					rotate6();
					break;
			}
		}
		print();
	}

}
