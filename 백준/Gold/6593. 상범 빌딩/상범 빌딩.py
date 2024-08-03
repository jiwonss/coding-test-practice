from sys import stdin
from collections import deque
input = stdin.readline

dx, dy, dz = [1, 0, -1, 0, 0, 0], [0, 1, 0, -1, 0, 0], [0, 0, 0, 0, 1, -1]


def out_of_bounds(x, y, z):
    return not (0 <= x < R and 0 <= y < C and 0 <= z < L)


def bfs():
    while q:
        x, y, z, time = q.popleft()
        for d in range(6):
            nx = x + dx[d]
            ny = y + dy[d]
            nz = z + dz[d]
            if out_of_bounds(nx, ny, nz):
                continue
            if visited[nz][nx][ny] or building[nz][nx][ny] == '#':
                continue
            if building[nz][nx][ny] == 'E':
                return time + 1
            visited[nz][nx][ny] = 1
            q.append([nx, ny, nz, time + 1])
    return 0


def solve():
    global L, R, C, building, q, visited

    while True:
        L, R, C = map(int, input().split())

        if L == R == C == 0:
            return

        building = [[] for _ in range(L)]
        q, visited = deque(), [[[0 for _ in range(C)] for _ in range(R)] for _ in range(L)]
        for z in range(L):
            for x in range(R):
                building[z].append(list(input().strip()))
                for y in range(C):
                    if building[z][x][y] == 'S':
                        visited[z][x][y] = 1
                        q.append([x, y, z, 0])
            input()

        result = bfs()
        if result:
            print(f'Escaped in {result} minute(s).')
        else:
            print('Trapped!')


if __name__ == "__main__":
    solve()
