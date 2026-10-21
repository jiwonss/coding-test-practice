n, m = map(int, input().split())
A = list(map(int, input().split()))

# Please write your code here.
def dfs(start, arr):
    global result

    if len(arr) == m:
        temp = 0
        for a in arr:
            temp ^= a
        result = max(result, temp)
        return

    for i in range(start, n):
        arr.append(A[i])
        dfs(i + 1, arr)
        arr.pop()

result = 0
dfs(0, [])
print(result)