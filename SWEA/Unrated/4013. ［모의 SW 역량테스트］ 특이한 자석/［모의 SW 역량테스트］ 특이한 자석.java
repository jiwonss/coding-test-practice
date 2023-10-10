import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int K, result;
	static int[][] magnet;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			K = Integer.parseInt(br.readLine());

			magnet = new int[5][8];
			for (int i = 1; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				list = new ArrayList<>();
				list.add(new int[] { n, d });

				check(n, d);

				for (int[] info : list) {
					magnet[info[0]] = rotate(info[0], info[1]);
				}
			}

			result = calc();
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void check(int n, int d) {
		int nd = d;
		for (int i = n; i > 1; i--) {
			if (magnet[i][6] != magnet[i - 1][2]) {
				nd *= (-1);
				list.add(new int[] { i - 1, nd });
			} else break;
		}
		nd = d;
		for (int i = n; i < 4; i++) {
			if (magnet[i][2] != magnet[i + 1][6]) {
				nd *= (-1);
				list.add(new int[] { i + 1, nd });
			} else break;
		}
	}

	private static int[] rotate(int n, int d) {
		int[] temp = new int[8];
		if (d == 1) {
			for (int i = 0; i < 8; i++) {
				temp[i] = magnet[n][(i - 1 + 8) % 8];
			}
		} else {
			for (int i = 0; i < 8; i++) {
				temp[i] = magnet[n][(i + 1 + 8) % 8];
			}
		}
		return temp;
	}

	private static int calc() {
		int result = 0;
		for (int i = 1; i < 5; i++) {
			if (magnet[i][0] == 1) {
				result += Math.pow(2, i - 1);
			}
		}
		return result;
	}
}

