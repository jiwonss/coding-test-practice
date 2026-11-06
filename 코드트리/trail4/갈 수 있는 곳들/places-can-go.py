from collections import deque

n, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
points = [tuple(map(int, input().split())) for _ in range(k)]

# Please write your code here.
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

def bfs(r, c):
    visited[r][c] = 1
    q.append([r, c])

    while q:
        x, y = q.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if not (0 <= nx < n and 0 <= ny < n):
                continue
            if visited[nx][ny] or grid[nx][ny] == 1:
                continue
            visited[nx][ny] = 1
            q.append([nx, ny])

q = deque()
visited = [[0] * n for _ in range(n)]
for r, c in points:
    bfs(r - 1, c - 1)

result = 0
for v in visited:
    result += sum(v)
print(result)
