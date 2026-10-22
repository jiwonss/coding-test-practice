from collections import deque

n = int(input())
grid = [list(input()) for _ in range(n)]

# Please write your code here.
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]

def bfs(sx, sy):
    q = deque([(sx, sy)])
    visited[sx][sy] = 0

    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if not (0 <= nx < n and 0 <= ny < n) or visited[nx][ny] != -1:
                continue
            visited[nx][ny] = visited[x][y] + 1
            q.append([nx, ny])

def dfs(k, current, next_coin, total):
    global result

    if k >= 3:
        result = min(result, total + distance[current][size - 1])

    for i in range(next_coin, size - 1):
        dfs(k + 1, i, i + 1, total + distance[current][i])
    
start, end = [0, 0], [0, 0]
coins = {}
for i in range(n):
    for j in range(n):
        if grid[i][j] == 'S':
            start = [i, j]
        if grid[i][j] == 'E':
            end = [i, j]
        if grid[i][j].isdigit():
            coins[int(grid[i][j])] = [i, j]

points = [start] + [v for k, v in sorted(coins.items())] + [end]

size = len(points)
distance = [[0] * size for _ in range(size)]

for i, (sx, sy) in enumerate(points):
    visited = [[-1] * n for _ in range(n)]
    bfs(sx, sy)    
    for j, (ex, ey) in enumerate(points):
        distance[i][j] = visited[ex][ey]

result = float('inf')
dfs(0, 0, 1, 0)  
print(result if result != float('inf') else -1)

