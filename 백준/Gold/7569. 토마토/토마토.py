from sys import stdin
from collections import deque
input = stdin.readline

dx, dy, dz = [1, 0, -1, 0, 0, 0], [0, 1, 0, -1, 0, 0], [0, 0, 0, 0, 1, -1]


def out_of_bounds(x, y, z):
    return not (0 <= x < N and 0 <= y < M and 0 <= z < H)


def bfs():
    while tomato:
        x, y, z = tomato.popleft()
        for d in range(6):
            nx = x + dx[d]
            ny = y + dy[d]
            nz = z + dz[d]
            if out_of_bounds(nx, ny, nz):
                continue
            if box[nz][nx][ny] != 0:
                continue
            box[nz][nx][ny] = box[z][x][y] + 1
            tomato.append([nx, ny, nz])


def solve():
    global N, M, H, box, tomato

    M, N, H = map(int, input().split())

    box, tomato = [[] for _ in range(H)], deque()
    for h in range(H):
        for i in range(N):
            box[h].append(list(map(int, input().split())))
            for j in range(M):
                if box[h][i][j] == 1:
                    tomato.append([i, j, h])

    bfs()

    result = 0
    for z in range(H):
        for x in range(N):
            if 0 in box[z][x]:
                print(-1)
                return
            result = max(result, max(box[z][x]))
    print(result - 1)


if __name__ == "__main__":
    solve()
