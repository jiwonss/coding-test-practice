import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, W, H, initCnt, cnt, result;
	static int[] selected;
	static int[][] map, visited;
	static Queue<int[]> q = new ArrayDeque<>();
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			initCnt = 0;
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						initCnt++;
				}
			}

			result = Integer.MAX_VALUE;
			selected = new int[N];
			dfs(0);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	// 1. 구슬 떨어뜨리기
	private static void dfs(int k) {
		if (k == N) {
			cnt = initCnt;
			int[][] temp = copy();
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < H; i++) {
					if (temp[i][selected[j]] != 0) {
						temp = bfs(temp, i, selected[j], temp[i][selected[j]] - 1);
						temp = fall(temp);
						break;
					}
				}
			}
			result = Math.min(result, cnt);
			return;
		}

		for (int i = 0; i < W; i++) {
			selected[k] = i;
			dfs(k + 1);
		}
	}

	// 2. 벽돌 깨기
	private static int[][] bfs(int[][] map, int x, int y, int power) {
		visited = new int[H][W];

		visited[x][y] = 1;
		q.offer(new int[] { x, y, power });

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int k = 1; k < pos[2] + 1; k++) {
				for (int d = 0; d < 4; d++) {
					int nx = pos[0] + (dx[d] * k);
					int ny = pos[1] + (dy[d] * k);
					if (OOB(nx, ny) || visited[nx][ny] == 1 || map[nx][ny] == 0)
						continue;
					visited[nx][ny] = 1;
					q.offer(new int[] { nx, ny, map[nx][ny] - 1 });
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (visited[i][j] == 1) {
					cnt--;
					map[i][j] = 0;
				}
			}
		}
		return map;
	}

	// 3. 벽돌 밑으로 내리기
	private static int[][] fall(int[][] map) {
		for (int j = 0; j < W; j++) {
			int idx = -1;
			for (int i = H - 1; i > -1; i--) {
				if (map[i][j] == 0) {
					idx = i;
					break;
				}
			}
			if (idx != -1) {
				List<Integer> list = new ArrayList<>();
				for (int i = idx; i > -1; i--) {
					if (map[i][j] != 0) {
						list.add(map[i][j]);
						map[i][j] = 0;
					}
				}
				for (int i = 0; i < list.size(); i++) {
					map[idx--][j] = list.get(i);
				}
			}
		}
		return map;
	}

	private static boolean OOB(int x, int y) {
		return x < 0 || x >= H || y < 0 || y >= W;
	}

	private static int[][] copy() {
		int[][] temp = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
}
