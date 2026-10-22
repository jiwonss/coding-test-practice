n = int(input())
A = [list(map(int, input().split())) for _ in range(n)]

# Please write your code here.
def dfs(current, count, total):
    global result

    if total >= result:
        return
    
    if count == n:
        if A[current][0] > 0:
            result = min(result, total + A[current][0])
        return
    
    for next in range(1, n):
        if visited[next] or A[current][next] == 0:
            continue
        
        visited[next] = 1
        dfs(next, count + 1, total + A[current][next])
        visited[next] = 0

visited = [0] * n
result = float('inf')
dfs(0, 1, 0)
print(result)