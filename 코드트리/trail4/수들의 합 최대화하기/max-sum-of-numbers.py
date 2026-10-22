n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
def dfs(k, total):
    global result

    if k == n:
        result = max(result, total)
        return
    
    for i in range(n):
        if visited[i]:
            continue
        
        visited[i] = 1
        dfs(k + 1, total + grid[k][i])
        visited[i] = 0
            


visited = [0] * n
result = 0
dfs(0, 0)
print(result)

