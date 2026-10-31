from collections import deque

n, m = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

def bfs(sx, sy):
    q.append([sx, sy])
    visited[sx][sy] = 1
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if not (0 <= nx < n and 0 <= ny < m):
                continue
            if visited[nx][ny] or a[nx][ny] == 0:
                continue
            q.append([nx, ny])
            visited[nx][ny] = 1

q = deque()
visited = [[0] * m for _ in range(n)]

bfs(0, 0)
print(visited[n - 1][m - 1])