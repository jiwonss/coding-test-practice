import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T, result;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	static List<int[]> list;
	static List<Integer> airCleaner;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[] aux = {-1, 0, 1, 0}, auy = {0, 1, 0, -1};
	static int[] adx = {1, 0, -1, 0}, ady = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		airCleaner = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					airCleaner.add(i);
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			getPM();
			spread();
			run();
		}
		
		result = totalPM();
		System.out.println(result);
	}
	
	// 미세먼지 저장
	private static void getPM() {
		q = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					q.offer(new int[] {i, j});
				}
			}
		}
	}
	
	// 미세먼지 확산
	private static void spread() {
		list = new ArrayList<>();
		visited = new boolean[R][C];
		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int x = pos[0], y = pos[1];
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if (map[nx][ny] == -1) continue;
				cnt++;
				list.add(new int[] {nx, ny, map[x][y] / 5});
			}
			list.add(new int[] {x, y, -(map[x][y] / 5) * cnt});
		}
		
		for (int i = 0; i < list.size(); i++) {
			int[] temp = list.get(i);
			int x = temp[0], y = temp[1], v = temp[2];
			map[x][y] = map[x][y] + v;
		}
	}
	
	// 공기청정기 작동
	private static void run() {
		int x, y, idx, d;
		// 위쪽 공기청정기 바람(상, 우, 하, 좌)
		idx = airCleaner.get(0);
		x = idx; y = 0;
		d = 0;
		while (true) {
			int nx = x + aux[d];
			int ny = y + auy[d];
			if (nx < 0 || nx > idx || ny < 0 || ny >= C) {
				d = (d + 1) % 4;
				continue;
			}
			if (map[x][y] != -1) {
				map[x][y] = map[nx][ny];
				map[nx][ny] = 0;
			}
			x = nx; y = ny;
			if (x == idx && y == 1) break;
		}
		
		// 아래쪽 공기청정기 바람(하, 우, 상, 좌)
		idx = airCleaner.get(1);
		x = idx; y = 0;
		d = 0;
		while (true) {
			int nx = x + adx[d];
			int ny = y + ady[d];
			if (nx < idx || nx >= R || ny < 0 || ny >= C) {
				d = (d + 1) % 4;
				continue;
			}
			if (map[x][y] != -1) {
				map[x][y] = map[nx][ny];
				map[nx][ny] = 0;
			}
			x = nx; y = ny;
			if (x == idx && y == 1) break;
		}
		
	}
	
	// 남은 미세먼지 양 
	private static int totalPM() {
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					result += map[i][j];
				}
			}
		}
		return result;
	}

}
