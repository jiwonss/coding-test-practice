from sys import stdin
from collections import deque
input = stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def out_of_bounds(x, y):
    return 0 <= x < n and 0 <= y < m


def bfs(i, j):
    area = 1
    visited[i][j] = 1
    q.append([i, j])
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if not out_of_bounds(nx, ny) or visited[nx][ny] or board[nx][ny] == '0':
                continue
            area += 1
            visited[nx][ny] = 1
            q.append([nx, ny])
    return area


def solve():
    global n, m, board, q, visited

    n, m = map(int, input().split())
    board = [list(input().split()) for _ in range(n)]

    q = deque()
    visited = [[0] * m for _ in range(n)]

    cnt, area = 0, 0
    for i in range(n):
        for j in range(m):
            if not visited[i][j] and board[i][j] == '1':
                cnt += 1
                area = max(area, bfs(i, j))
    print(cnt)
    print(area)


if __name__ == "__main__":
    solve()
