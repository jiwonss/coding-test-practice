n = int(input())
num = [list(map(int, input().split())) for _ in range(n)]
move_dir = [list(map(int, input().split())) for _ in range(n)]
r, c = map(int, input().split())

# Please write your code here.
dx, dy = [0, -1, -1, 0, 1, 1, 1, 0, -1], [0, 0, 1, 1, 1, 0, -1, -1, -1]

def dfs(x, y, move_cnt):
    global result
    result = max(result, move_cnt)
    
    N, M = num[x][y], move_dir[x][y]
    for i in range(1, n): 
        nx = x + dx[M] * i
        ny = y + dy[M] * i 
        if not (0 <= nx < n and 0 <= ny < n):
            continue
        if num[nx][ny] <= N:
            continue
        dfs(nx, ny, move_cnt + 1)

result = 0
dfs(r - 1, c - 1, 0)
print(result)