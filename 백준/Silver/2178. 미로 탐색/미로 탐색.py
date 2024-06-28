from sys import stdin
from collections import deque
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def out_of_bounds(x, y):
    return 0 <= x < N and 0 <= y < M


def bfs():
    q = deque()
    q.append([0, 0])
    maze[0][0] = 2
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if not out_of_bounds(nx, ny) or maze[nx][ny] != 1:
                continue
            if nx == N - 1 and ny == M - 1:
                return maze[x][y]
            maze[nx][ny] = maze[x][y] + 1
            q.append([nx, ny])


def solve():
    global N, M, maze

    N, M = map(int, input().split())
    maze = [list(map(int, input().strip())) for _ in range(N)]

    print(bfs())


if __name__ == "__main__":
    solve()
