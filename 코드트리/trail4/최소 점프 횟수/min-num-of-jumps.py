n = int(input())
num = list(map(int, input().split()))

# Please write your code here.
def dfs(idx, jump):
    global result

    if idx == n - 1:
        result = min(result, jump)
        return
    
    for i in range(1, num[idx] + 1):
        if idx + i < n:
            dfs(idx + i, jump + 1)
        
result = 1e9
dfs(0, 0)
print(result if result != 1e9 else -1)