n = int(input())

# Please write your code here.
def dfs(k):
    if k == n: 
        print(*result)
        return
    
    for i in range(1, n + 1):
        if visited[i]:
            continue
        visited[i] = 1
        result.append(i)
        dfs(k + 1)
        visited[i] = 0
        result.pop()

visited = [0] * (n + 1)
result = []
dfs(0)