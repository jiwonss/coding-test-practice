n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
def dfs(x, y):
    visited[x][y] = 1
    for dx, dy in [[0, 1], [1, 0]]:
        nx = x + dx
        ny = y + dy
        if not (0 <= nx < n and 0 <= ny < m):
            continue
        if visited[nx][ny] or grid[nx][ny] == 0:
            continue
        visited[nx][ny] = 1
        dfs(nx, ny)

visited = [[0] * m for _ in range(n)]
dfs(0, 0)
print(visited[n - 1][m - 1])