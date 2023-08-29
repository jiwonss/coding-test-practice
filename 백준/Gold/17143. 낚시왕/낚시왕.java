import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Shark {
	int r, c, s, d, z;
	public Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}

public class Main {
	
	static int R, C, M, result;
	static Shark[][] board;
	static List<Shark> sharkList;
	// 0 : 제자리, 1 : 위, 2 : 아래, 3 : 오른쪽, 4 : 왼쪽 
	static int[] dr = {0, -1, 1, 0, 0}, dc = {0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new Shark[R + 1][C + 1];
		sharkList = new ArrayList<>();
		
		int r, c, s, d, z;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(r, c, s, d, z);
			sharkList.add(shark);
			board[r][c] = shark;
		}
		
		// 낚시
		result = 0;
		for (int i = 1; i <= C; i++) {
			catchShark(i);
			moveShark();
			killShark();
		}
		System.out.println(result);
	}
	
	// 상어 잡기
	private static void catchShark(int c) {
		for (int r = 1; r <= R; r++) {
			if (board[r][c] == null) continue;
			result += board[r][c].z;
			sharkList.remove(board[r][c]);
			break;
		}
	}
	
	// 상어 이동
	private static void moveShark() {
		int nr, nc, s, d;
		for (Shark shark : sharkList) {
			nr = shark.r; nc = shark.c; s = shark.s; d = shark.d;
			if (d == 1 || d == 2) {
				s = s % (R * 2 - 2);
				for (int i = 0; i < s; i++) {
					if (nr == 1) d = 2;
					if (nr == R) d = 1;
					nr += dr[d];
				}
			}
			if (d == 3 || d == 4) {
				s = s % (C * 2 - 2);
				for (int i = 0; i < s; i++) {
					if (nc == 1) d = 3;
					if (nc == C) d = 4;
					nc += dc[d];
				}
			}
			shark.r = nr; shark.c = nc; shark.d = d;
		}
	}
	
	// 재배치, 중접된 상어 제거
	private static void killShark() {
		board = new Shark[R + 1][C + 1];
		for (int i = sharkList.size() - 1; i >= 0; i--) {
			Shark shark = sharkList.get(i);
			if (board[shark.r][shark.c] == null) {
				board[shark.r][shark.c] = shark;
			} else {
				if (shark.z <= board[shark.r][shark.c].z) {
					sharkList.remove(shark);
				} else {
					sharkList.remove(board[shark.r][shark.c]);
					board[shark.r][shark.c] = shark;
				}
			}
		}
		
	}

	
}
