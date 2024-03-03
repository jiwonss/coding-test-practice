import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static class Shark {
		int x, y, sum, d;
		Shark(int x, int y, int sum, int d) {
			this.x = x;
			this.y = y;
			this.sum = sum;
			this.d = d;
		}
	}
    static class Fish {
        int x, y, n, d;
        boolean status;
        Fish(int x, int y, int n, int d, boolean status) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.d = d;
            this.status = status;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N = 4, result;
    static int[][] map;
    static List<Fish> fishList;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        map = new int[N][N];
        fishList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;
                map[i][j] = n;
                fishList.add(new Fish(i, j, n, d, true));
            }
        }
    }
    
    public static void solve() {
    	fishList.sort(Comparator.comparingInt(o -> o.n));
        
        Fish fish = fishList.get(map[0][0] - 1);
        Shark shark = new Shark(0, 0, fish.n, fish.d);
        fish.status = false;
        map[0][0] = -1;
        
        result = 0;
        dfs(map, fishList, shark);
        System.out.println(result);
    }

    public static void dfs(int[][] map, List<Fish> fishList, Shark shark) {
    	moveFish(map, fishList);

    	int x = shark.x, y = shark.y, sum = shark.sum, d = shark.d;
    	for (int i = 0; i < N - 1; i++) {
    		int nx = x + dx[d] * (i + 1);
    		int ny = y + dy[d] * (i + 1);
    		if (!isIn(nx, ny)) {
    			result = Math.max(result, shark.sum);
    			return;
    		}
    		if (map[nx][ny] <= 0) continue; 	
    		
    		int[][] copyMap = copyArray(map);
    		List<Fish> copyFishList = copyList(fishList);
    			
    		Fish fish = copyFishList.get(map[nx][ny] - 1);
    		Shark newShark = new Shark(fish.x, fish.y, sum + fish.n, fish.d);
    			
    		copyMap[x][y] = 0;
    		fish.status = false;
    		copyMap[fish.x][fish.y] = -1;
    			
    		dfs(copyMap, copyFishList, newShark);
    	}
    }
    
    public static void moveFish(int[][] map, List<Fish> fishList) {
        for (int i = 0; i < N * N; i++) {
        	Fish fish = fishList.get(i);
        	if (!fish.status) continue;
            
        	int x = fish.x, y = fish.y, n = fish.n, d = fish.d;        
            for (int j = 0; j < 8; j++) {
            	int nd = (d + j) % 8;
                int nx = x + dx[nd];
                int ny = y + dy[nd];
                if (!isIn(nx, ny) || map[nx][ny] == -1) continue;
                map[x][y] = 0;
                if (map[nx][ny] == 0) {
                    fish.x = nx; fish.y = ny;
                } else {
                    Fish target = fishList.get(map[nx][ny] - 1);           
                    target.x = x; target.y = y;
                    map[x][y] = target.n;
                    fish.x = nx; fish.y = ny;         	
                }
                map[nx][ny] = n;
                fish.d = nd;
                break;
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }

    public static int[][] copyArray(int[][] map) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
    }
    
    public static List<Fish> copyList(List<Fish> fishList) {
    	List<Fish> temp = new ArrayList<>();
    	fishList.forEach(f -> temp.add(new Fish(f.x, f.y, f.n, f.d, f.status)));
        return temp;
    }
}