from sys import stdin
from collections import deque

input = stdin.readline

mx, my = [1, 0, -1, 0], [0, 1, 0, -1]
hx, hy = [2, 1, -1, -2, -2, -1, 1, 2], [1, 2, 2, 1, -1, -2, -2, -1]


def out_of_bounds(x, y):
    return not (0 <= x < H and 0 <= y < W)


def bfs():
    q = deque()
    visited = [[[0] * (K + 1) for _ in range(W)] for _ in range(H)]

    q.append([0, 0, K])

    while q:
        x, y, cnt = q.popleft()

        if x == H - 1 and y == W - 1:
            return visited[x][y][cnt]

        if cnt:
            for i in range(8):
                nx = x + hx[i]
                ny = y + hy[i]
                if out_of_bounds(nx, ny):
                    continue
                if visited[nx][ny][cnt - 1] or board[nx][ny]:
                    continue
                visited[nx][ny][cnt - 1] = visited[x][y][cnt] + 1
                q.append([nx, ny, cnt - 1])

        for i in range(4):
            nx = x + mx[i]
            ny = y + my[i]
            if out_of_bounds(nx, ny):
                continue
            if visited[nx][ny][cnt] or board[nx][ny]:
                continue
            visited[nx][ny][cnt] = visited[x][y][cnt] + 1
            q.append([nx, ny, cnt])

    return -1


def solve():
    global K, W, H, board, q, visited

    K = int(input())
    W, H = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(H)]

    print(bfs())


if __name__ == "__main__":
    solve()
