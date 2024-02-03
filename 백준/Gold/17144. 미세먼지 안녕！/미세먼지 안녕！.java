import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	/**
	 * x, y : 좌표
	 * v : 좌표에 존재하는 미세먼지 양
	 */
	static class Point {
		int x; int y; int v;
		Point(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}
	
	static BufferedReader br;
	static StringTokenizer st;
	
	static int R, C, T, up, down, result;
	static int[][] map;
	static List<Point> findDustList, spreadInfo;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		init();
		monitoring();
		monitoringResult();
		System.out.println(result);
	}
	
	public static void init() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
	
	// 미세먼지 실시간 모니터링
	public static void monitoring() {
		// 공기청정기 위치 찾기
		up = 0; down = 0;
		for (int i = 0; i < R; i++) {
			if (map[i][0] == -1) {
				up = i;
				down = i + 1;
				break;
			}
		}
		
		for (int i = 0; i < T; i++) {
			spreadFineDust();
			runAirCleaner();
		}
	}
	
	// 모니터링 결과
	public static void monitoringResult() {
		result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					result += map[i][j];
				}
			}
		}
	}
	
	
	// 미세먼지 확산
	public static void spreadFineDust() {
		// 현재 존재하는 미세먼지 리스트에 저장
		findDustList = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					findDustList.add(new Point(i, j, map[i][j]));
				}
			}
		}
		
		// 미세먼지 확산 정보 저장
		for (Point findDust : findDustList) {
			int cnt = 0;
			int amount = (int) (findDust.v / 5);
			for (int i = 0; i < 4; i++) {
				int nx = findDust.x + dx[i];
				int ny = findDust.y + dy[i];
				if (outOfBounds(nx, ny) || map[nx][ny] == -1) continue;
				cnt++;
				map[nx][ny] += amount;
			}
			map[findDust.x][findDust.y] -= (amount * cnt);
		}
	}
	
	public static boolean outOfBounds(int x, int y) {
		if (x < 0 || x >= R || y < 0 || y >= C) return true;
		return false;
	}
	
	
	// 공기청정기 작동
	public static void runAirCleaner() {
		// 위쪽 공기청정기 작동
		int d;
		int upX = up, upY = 0;
		for (int i = 0; i < 4; i++) {
			if (i == 0) d = 2;
			else if (i == 2) d = 0;
			else d = i;
			int temp = 0;
			int nx = upX, ny = upY + 1;
			while (true) {
				nx = upX + dx[d];
				ny = upY + dy[d];
				if (outOfBounds(nx, ny) || nx > up) break;
				if (nx == up && ny == 0) {
					map[up][0] = -1;
					break;
					}
				if (map[nx][ny] <= 0) {
					temp = 0;
					upX = nx; upY = ny;
					continue;
				}
				temp = map[upX][upY];					
				map[upX][upY] = map[nx][ny];
				map[nx][ny] = 0;
				upX = nx; upY = ny;
			}
		}
		
		// 아래쪽 공기청정기 작동
		int downX = down, downY = 0;
		for (int i = 0; i < 4; i++) {
			int temp = 0;
			int nx = downX, ny = downY;
			while (true) {
				nx = downX + dx[i];
				ny = downY + dy[i];
				if (outOfBounds(nx, ny) || nx < down) break;
				if (nx == down && ny == 0) {
					map[down][0] = -1;
					break;
				}
				if (map[nx][ny] <= 0) {
					temp = 0;
					downX = nx; downY = ny;
					continue;
				}
				temp = map[downX][downY];
				map[downX][downY] = map[nx][ny];
				map[nx][ny] = 0;
				downX = nx; downY = ny;
			}
		}
	}

}
