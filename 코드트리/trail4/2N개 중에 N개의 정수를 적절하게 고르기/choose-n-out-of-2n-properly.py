n = int(input())
num = list(map(int, input().split()))

# Please write your code here.
def dfs(k, start, a):
    global result

    if k == n:
        b = total - a
        result = min(result, abs(a - b))
        return

    for i in range(start, 2 * n):
        dfs(k + 1, i + 1, a + num[i])

total = sum(num)
result = float('inf')
dfs(0, 0, 0)
print(result)