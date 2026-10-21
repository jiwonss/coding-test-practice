N, M = map(int, input().split())

# Please write your code here.
def dfs(idx, arr):
    if idx == M:
        print(' '.join(map(str, arr)))
        return
    
    for i in range(N):
        k = i + 1

        if visited[i] or (arr and arr[-1] >= k):
            continue
        
        arr.append(k)
        dfs(idx + 1, arr)
        arr.pop()

visited = [0] * N
dfs(0, [])