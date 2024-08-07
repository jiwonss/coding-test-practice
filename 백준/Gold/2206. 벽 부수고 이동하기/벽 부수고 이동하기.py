from sys import stdin
from collections import deque
input = stdin.readline

n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

q = deque()
distance = [[[-1, -1] for _ in range(m)] for _ in range(n)]

distance[0][0] = [1, 1]
q.append([0, 0, 0])

def bfs():
    while q:
        x, y, broken = q.popleft()
        if x == n - 1 and y == m - 1:
            print(distance[x][y][broken])
            return 
        next_distance = distance[x][y][broken] + 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if board[nx][ny] == '0' and distance[nx][ny][broken] == -1:
                distance[nx][ny][broken] = next_distance
                q.append([nx, ny, broken])
            if not broken and board[nx][ny] == '1' and distance[nx][ny][broken] == -1:
                distance[nx][ny][1] = next_distance
                q.append([nx, ny, 1])
    print(-1)

bfs()


