from sys import stdin
from collections import deque
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def out_of_bounds(x, y):
    return 0 <= x < N and 0 <= y < M


def bfs():
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if not out_of_bounds(nx, ny) or visited[nx][ny] or box[nx][ny] == '-1':
                continue
            visited[nx][ny] = visited[x][y] + 1
            q.append([nx, ny])


def solve():
    global M, N, box, q, visited

    M, N = map(int, input().split())
    box, q = [], deque()
    visited = [[0] * M for _ in range(N)]
    for i in range(N):
        box.append(input().split())
        for j in range(M):
            if box[i][j] == '-1':
                visited[i][j] = -1
            if box[i][j] == '1':
                q.append([i, j])
                visited[i][j] = 1

    bfs()

    result = 0
    for v in visited:
        if 0 in v:
            print(-1)
            return
        result = max(result, max(v))
    print(result - 1)


if __name__ == "__main__":
    solve()
