from sys import stdin
from collections import deque
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def out_of_bounds(x, y):
    return not (0 <= x < N and 0 <= y < N)


def bfs(i, j):
    visited[i][j] = 1
    q.append([i, j])

    cnt = 1
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if out_of_bounds(nx, ny):
                continue
            if visited[nx][ny] or board[nx][ny] == '0':
                continue
            cnt += 1
            visited[nx][ny] = 1
            q.append([nx, ny])
    return cnt


def solve():
    global N, board, q, visited

    N = int(input())
    board = [list(input().strip()) for _ in range(N)]

    q, visited = deque(), [[0] * N for _ in range(N)]

    cnt, result = 0, []
    for i in range(N):
        for j in range(N):
            if visited[i][j] or board[i][j] == '0':
                continue
            cnt += 1
            result.append(bfs(i, j))

    print(cnt)
    for r in sorted(result):
        print(r)


if __name__ == "__main__":
    solve()
