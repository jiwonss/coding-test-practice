from sys import stdin
from collections import deque
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def out_of_bounds(x, y):
    return not (0 <= x < M and 0 <= y < N)


def bfs(i, j):
    q.append([i, j])
    board[i][j] = 1

    area = 1
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if out_of_bounds(nx, ny) or board[nx][ny] != 0:
                continue
            area += 1
            board[nx][ny] = 1
            q.append([nx, ny])
    return area


def solve():
    global M, N, board, q, visited

    M, N, K = map(int, input().split())

    board = [[0] * N for _ in range(M)]
    for _ in range(K):
        x1, y1, x2, y2 = map(int, input().split())
        for i in range(x1, x2):
            for j in range(y1, y2):
                board[j][i] = -1

    q = deque()
    cnt, area = 0, []
    for i in range(M):
        for j in range(N):
            if board[i][j] != 0:
                continue
            cnt += 1
            area.append(bfs(i, j))
    print(cnt)
    print(*sorted(area))


if __name__ == "__main__":
    solve()
