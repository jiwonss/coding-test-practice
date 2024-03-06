import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        solve();
        print();
    }

    public static void solve() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        star(0, 0, N);
    }

    public static void star(int x, int y, int n) {
        if (n == 1) return;

        int t = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i % 3 == 1 && j % 3 == 1) continue;
                map[x + i * t][y + j * t] = '*';
                star(x + i * t, y + j * t, t);
            }
        }
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*') {
                    sb.append(map[i][j]);
                } else {
                    sb.append(" ");
                }
            }
           sb.append("\n");
        }
        System.out.println(sb);
    }
}
