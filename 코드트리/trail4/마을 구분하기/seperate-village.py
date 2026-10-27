n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

def dfs(x, y):
    global count

    visited[x][y] = 1
    
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if not (0 <= nx < n and 0 <= ny < n):
            continue
        if visited[nx][ny] or grid[nx][ny] == 0:
            continue
        count += 1
        dfs(nx, ny)

visited = [[0] * n for _ in range(n)]
result = [0, []]
for i in range(n):
    for j in range(n):
        if visited[i][j] or grid[i][j] == 0:
            continue
        result[0] += 1
        count = 1
        dfs(i, j)
        result[1].append(count)

print(result[0])
for i in sorted(result[1]):
    print(i)