from sys import stdin
from collections import deque
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]


def is_in(x, y):
    return 0 <= x < R and 0 <= y < C


def solve():
    global R, C

    R, C = map(int, input().split())

    maze, q = [], deque()
    for i in range(R):
        maze.append(list(input().strip()))
        for j in range(C):
            if maze[i][j] == 'J':
                q.appendleft([i, j, 0])
            if maze[i][j] == 'F':
                q.append([i, j, -1])

    while q:
        x, y, time = q.popleft()
        if maze[x][y] == 'J':
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if not is_in(nx, ny):
                    print(time + 1)
                    return
                if maze[nx][ny] != '.':
                    continue
                maze[nx][ny] = 'J'
                q.append([nx, ny, time + 1])
        else:
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if not is_in(nx, ny):
                    continue
                if maze[nx][ny] == '#' or maze[nx][ny] == 'F':
                    continue
                maze[nx][ny] = 'F'
                q.append([nx, ny, -1])
    print('IMPOSSIBLE')


if __name__ == "__main__":
    solve()
