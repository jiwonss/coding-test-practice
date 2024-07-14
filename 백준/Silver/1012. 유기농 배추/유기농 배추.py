from sys import stdin
from collections import deque
input = stdin.readline


dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < M)


def bfs():
    q = deque()
    visited = [[0] * M for _ in range(N)]
    cnt = 0
    for i in range(N):
        for j in range(M):
            if visited[i][j] or board[i][j] == 0:
                continue
            cnt += 1
            visited[i][j] = 1
            q.append([i, j])
            while q:
                x, y = q.popleft()
                for d in range(4):
                    nx = x + dx[d]
                    ny = y + dy[d]
                    if out_of_bounds(nx, ny) or visited[nx][ny] or board[nx][ny] == 0:
                        continue
                    visited[nx][ny] = 1
                    q.append([nx, ny])
    return cnt


def solve():
    global N, M, board, visited

    T = int(input())
    for _ in range(T):
        M, N, K = map(int, input().split())

        board = [[0] * M for _ in range(N)]
        for _ in range(K):
            Y, X = map(int, input().split())
            board[X][Y] = 1

        print(bfs())


if __name__ == "__main__":
    solve()
