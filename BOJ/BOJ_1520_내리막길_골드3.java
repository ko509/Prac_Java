import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 : 320ms
// 메모리 : 39252KB
public class Main {

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static int N;
	static int M;
	static int[][] map;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] cnt = new int[N][M];
		cnt[0][0] = 1;
		boolean[][] v = new boolean[N][M];
		v[0][0] = true;
		
		System.out.println(dfs(cnt, v, N - 1, M - 1));
	}

	private static int dfs(int[][] cnt, boolean[][] v, int r, int c) {

		if(v[r][c]) return cnt[r][c];
		
		v[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= N || nc >= M || nr < 0 || nc < 0 || map[nr][nc] <= map[r][c]) continue;
			cnt[r][c] += dfs(cnt, v, nr, nc);
		}
		return cnt[r][c];
	}

}
