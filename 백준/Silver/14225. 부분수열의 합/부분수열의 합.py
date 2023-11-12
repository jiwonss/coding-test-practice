from sys import stdin
input = stdin.readline

def solve(k):
    if k == N:
        sum = 0
        for i in range(N):
            if visited[i]:
                sum += S[i]
        if sum != 0:
            num.add(sum)
        return

    visited[k] = 0
    solve(k + 1)
    visited[k] = 1
    solve(k + 1)

N = int(input())
S = list(map(int, input().split()))

num = set()
visited = [0] * N
solve(0)

result = 1
max_value = sum(S) + 1
for i in range(1, max_value):
    if i not in num:
        result = i
        break
else:
    result = max_value
print(result)
