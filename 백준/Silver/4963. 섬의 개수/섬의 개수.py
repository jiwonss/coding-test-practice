from sys import stdin
from collections import deque

input = stdin.readline

dx, dy = [1, 1, 0, -1, -1, -1, 0, 1], [0, 1, 1, 1, 0, -1, -1, -1]


def out_of_bounds(x, y):
    return not (0 <= x < h and 0 <= y < w)


def bfs():
    while q:
        x, y = q.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if out_of_bounds(nx, ny):
                continue
            if visited[nx][ny] or not board[nx][ny]:
                continue
            visited[nx][ny] = 1
            q.append([nx, ny])


def solve():
    global w, h, board, q, visited

    while True:
        w, h = map(int, input().split())

        if [w, h] == [0, 0]:
            return

        board = [list(map(int, input().split())) for _ in range(h)]

        q = deque()
        visited = [[0] * w for _ in range(h)]

        result = 0
        for i in range(h):
            for j in range(w):
                if not board[i][j] or visited[i][j]:
                    continue
                visited[i][j] = 1
                q.append([i, j])
                bfs()
                result += 1
        print(result)


if __name__ == "__main__":
    solve()
