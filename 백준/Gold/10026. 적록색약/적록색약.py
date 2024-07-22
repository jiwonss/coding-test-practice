from sys import stdin
from collections import deque
input = stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

n = int(input())
grid = [list(input().strip()) for _ in range(n)]

def bfs(i, j):
    q = deque()
    visited[i][j] = 1
    q.append([i, j])
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if grid[x][y] != grid[nx][ny] or visited[nx][ny]:
                continue
            visited[nx][ny] = 1
            q.append([nx, ny])

def area():
    cnt = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                cnt += 1
                bfs(i, j)
    return cnt
            
visited = [[0] * n for _ in range(n)]
not_cw = area()

visited = [[0] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if grid[i][j] == 'G':
            grid[i][j] = 'R'
is_cw = area()

print(not_cw, is_cw)